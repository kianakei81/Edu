package client.controller;

import client.graphic.MainMenu.DaneshjuMainMenu;
import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class profListController {

    public static String[][] profList(String message, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        Response response = ServerController.sendAnyRequest(request, token);
        if(response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("data");
        }
        return data;
    }

}
