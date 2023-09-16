package server;

import server.context.*;
import server.context.Filter.EntekhabVahedFilter;
import server.context.Filter.Filter;
import server.context.List.Barname;
import server.context.List.ExamsList;
import server.context.List.ProfList;
import server.network.ClientHandler;
import server.responseSender.*;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Server {
    private final List<ClientHandler> clients;

    private List<ClientHandler> onlineUsers;
    private static int clientCount = 0;
    private ServerSocket serverSocket;
    private final int port;
    private boolean running;

    private SecureRandom secureRandom;

    private int AuthToken;

    public Server(int port) {
        this.port = port;
        clients = new ArrayList<>();
    }

    public void start() {
        try {
            serverSocket = new ServerSocket(port);
            secureRandom = new SecureRandom();
            running = true;
            listenForNewConnection();
        } catch (IOException e) {
            // Failed to run the server
            e.printStackTrace();
        }
    }

    // کلاینت های جدید رو به لیست اضافه میکنه
    private void listenForNewConnection() {
        while (running) {
            try {
                clientCount++;
                Socket socket = serverSocket.accept();
                ClientHandler clientHandler = new ClientHandler(clients.size(), this, socket);
                clients.add(clientHandler);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // به درخواست ها جواب میده
    public void handleRequest(int id, Request req) {
        boolean result = false;
        switch (req.getRequestType()) {
            case Login -> {
                // check user and pass
                result = checkUserPass(req);
                sendLoginResponse(id, result, req);
            } case LessonList -> {
                result = check(id, req);
                Response response = lessonListResponse.sendLessonListResponse(id, result, (int) req.getData("authToken"));
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case FilterDaneshkadeRiazi, FilterDaneshkadeBargh, FilterDaneshkadeCs, FilterDaneshkadeOmran, FilterDaneshkadePhysics,
                    FilterVahedOne, FilterVahedTwo, FilterVahedThree, FilterVahedFour, FilterOstad -> {
                result = check(id, req);
                Response response = filterResponse.sendFilterResponse(id, result, (int) req.getData("authToken"), req);
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case Profile -> {
                result = check(id, req);
                Response response = profileResponse.sendProfileResponse(id, result, (String) req.getData("username"), (int) req.getData("authToken"));
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case Barname -> {
                result = check(id, req);
                Response response = barnameResponse.sendBarnameResponse(id, result, (String) req.getData("username"), (int) req.getData("authToken"));
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case ChangingEmail, ChangingNumber -> {
                result = check(id, req);
                Response response = changingEmailOrNumberResponse.sendChangingEmailOrNumberResponse(id, result, req, (int) req.getData("authToken"));
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case ListEmtehanat -> {
                result = check(id, req);
                Response response = listEmtehanResponse.sendListEmtehanatResponse(id, result, req, (int) req.getData("authToken"));
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case ListOstad -> {
                result = check(id, req);
                Response response = listOstadResponse.sendListOstadResponse(id, result, (int) req.getData("authToken"));
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case addLesson -> {
                result = check(id, req) && checkMoaven(req);
                Response response = addLessonResponse.sendAddLessonResponse(id, result, req);
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            } case RiaziFilter, PhysicsFilter, OmranFilter, CsFilter, BarghFilter, MaarefFilter -> {
                result = check(id, req);
                Response response = entekhabVahedFilterResponse.sendEntekhabVahedFilterResponse(id, result, req);
                findClientAndSendResponse(id, response, (int) req.getData("authToken"));
            }
        }
    }

    // چک میکنه که توکن درخواست و درخواست کننده یکی باشه
    private boolean check(int id, Request req) {
        boolean result = false;
        ClientHandler clientHandler = getClientHandler(id);
        if((int) req.getData("authToken") == clientHandler.getAuthToken()) {
            result = true;
        }
        return result;
    }

    // چک میکنه معاون درس دانشکده خودش رو اد کنه
    private boolean checkMoaven(Request request) {
        boolean result = false;
        String username = (String) request.getData("username");
        String[] info = ProfileInformation.TeacherInfo(username);
        String daneshkade = (String) request.getData("daneshkade");

        if(info[8].equals("riazi") && daneshkade.equals("ریاضی")) {
            result = true;
        } else if(info[8].equals("physic") && daneshkade.equals("فیزیک")) {
            result = true;
        } else if(info[8].equals("omran") && daneshkade.equals("عمران")) {
            result = true;
        } else if(info[8].equals("bargh") && daneshkade.equals("برق")) {
            result = true;
        } else if(info[8].equals("cs") && daneshkade.equals("کامپیوتر")) {
            result = true;
        }

        return result;
    }


    private boolean checkUserPass(Request request) {
        boolean result = false;

        String user = (String) request.getData("username");
        String pass = (String) request.getData("password");

        result = CheckID.checkId(user, pass);

        return result;
    }

    // به درخواست لاگین جواب میده
    private void sendLoginResponse(int clientId, Boolean result, Request request) {
        Response response;
        String username = (String) request.getData("username");
        String password = (String) request.getData("password");
        String type = null;
        if (result) {
            AuthToken = secureRandom.nextInt(Integer.MAX_VALUE);
            ClientHandler ch = getClientHandler(clientId);
            if(ch != null) {
                ch.setAuthToken(AuthToken);
            }
            response = new Response(ResponseStatus.OK);

            // پیدا میکنه فایل users چند خطه
            int j = 0;
            try {
                File file = new File("C:\\Users\\Global Village\\IdeaProjects\\FAZE_2\\src\\server\\resources\\users.txt");
                Scanner File = new Scanner(file);
                while (File.hasNextLine()) {
                    String d = File.nextLine();
                    j++;
                }
                File.close();
            }
            catch(FileNotFoundException f) {
                System.out.println("An error occurred.");
                f.printStackTrace();
            }

            String[][] ID = new String[j][3];

            ID = CollectInfo.collectUserAndPass(j);
            for (int i = 0; i < j; i++) {
                if(ID[i][0].equals(username) && ID[i][1].equals(password)) {
                    type = ID[i][2];
                }
            }
            response.addData("type", type);
            response.addData("username", username);
            response.addData("authToken", AuthToken);
            findClientAndSendResponse(clientId, response, AuthToken);
        } else {
            response = new Response(ResponseStatus.ERROR);
            findClientAndSendResponse(clientId, response, AuthToken);
        }
    }

    private void findClientAndSendResponse(int clientId, Response response, int token) {
        ClientHandler clientHandler = getClientHandler(clientId);
        if (clientHandler != null) {
            clientHandler.sendResponse(response);
        }
    }


    private ClientHandler getClientHandler(int clientId) {
        for(ClientHandler clientHandler: clients) {
            if (clientHandler.getId() == clientId) {
                return clientHandler;
            }
        }
        return null;
    }


    // Remove client from clients
    public void clientDisconnected(ClientHandler ch) {
        clients.remove(ch);
    }

}

