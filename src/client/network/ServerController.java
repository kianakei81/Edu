package client.network;

import org.codehaus.jackson.map.ObjectMapper;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.util.Jackson;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;
import java.net.Socket;
import java.util.Scanner;

public class ServerController {
    public static PrintStream printStream;
    public static Scanner scanner;
    private final int port;
    public static ObjectMapper objectMapper;

    public static int AuthToken;

    public ServerController(int port) {
        this.port = port;
        objectMapper = Jackson.getNetworkObjectMapper();
        AuthToken = 0;
    }

    public void connectToServer() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), port);
            printStream = new PrintStream(socket.getOutputStream());
            scanner = new Scanner(socket.getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void sendRequest(Request request) {
        try {
            String requestString = objectMapper.writeValueAsString(request);
            printStream.println(requestString);
            printStream.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // درخواست لاگین رو دریافت میکنه و جواب میده
    public static Response sendLoginRequest(Request request) {

        sendRequest(request);

        Response response = null;

        try {
            response = objectMapper.readValue(scanner.nextLine(), Response.class);
        } catch (Exception e) {
            System.out.println("hello");
        }
        return response;
    }

    public static Response sendAnyRequest(Request request, int token) {
        request.addData("authToken", token);
        sendRequest(request);

        Response response = null;

        try {
            response = objectMapper.readValue(scanner.nextLine(), Response.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return response;

    }


    public static int getAuthToken() {
        return AuthToken;
    }
}