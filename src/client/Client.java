package client;

import client.graphic.MainMenu.EnteringFrame;
import client.network.ServerController;


import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client implements Runnable {

    private ServerController serverController;
    private final int port;
    public Client(int port) {
        this.port = port;
    }

    public void start() {
        serverController = new ServerController(8080);
        serverController.connectToServer();
        // برنامه اجرا میشه
        EnteringFrame frame = new EnteringFrame();
    }

    @Override
    public void run() {
        start();
    }
}