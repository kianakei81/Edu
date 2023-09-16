package client;

import shared.util.Config;

public class ClientMain {
    public static void main(String[] args) {
        Integer port = Config.getConfig().getProperty(Integer.class, "port");
        Client client = new Client(port);
        new Thread(client).start();
    }
}