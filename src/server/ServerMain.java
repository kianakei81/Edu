package server;

import shared.util.Config;

public class ServerMain {
    public static void main(String[] args) {
        Integer port = Config.getConfig().getProperty(Integer.class, "port");
        Server server = new Server(port);
        server.start();
    }
}