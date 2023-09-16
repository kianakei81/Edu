package server.network;

import org.codehaus.jackson.map.ObjectMapper;

import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.List;
import java.util.Scanner;

import server.Server;
import shared.util.Jackson;
import shared.request.Request;
import shared.response.Response;

public class ClientHandler {

    private final int id;
    private final Server server;
    private PrintStream printStream;
    private Scanner scanner;
    private ObjectMapper objectMapper;

    private int AuthToken;


    public ClientHandler(int id, Server server, Socket socket) {
        this.id = id;
        this.server = server;

        try {
            printStream = new PrintStream(socket.getOutputStream());
            scanner = new Scanner(socket.getInputStream());
            objectMapper = Jackson.getNetworkObjectMapper();
            makeListenerThread();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void makeListenerThread() {
        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    String requestString = scanner.nextLine();
                    Request request = objectMapper.readValue(requestString, Request.class);
                    handleRequest(request);
                } catch (Exception e) {
                    // disconnect

                }
            }
        });
        thread.start();
    }

    private void handleRequest(Request request) {
        server.handleRequest(id, request);
    }

    public void sendResponse(Response response) {
        try {
            String responseString = objectMapper.writeValueAsString(response);
            printStream.println(responseString);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public int getId() {
        return id;
    }


    public int getAuthToken() {
        return AuthToken;
    }

    public void setAuthToken(int authToken) {
        AuthToken = authToken;
    }
}