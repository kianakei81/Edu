package client.controller;

import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class barnameController {

    public static String[][] barname(String message, String username, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        request.addData("username", username);
        Response response = ServerController.sendAnyRequest(request, token);
        if(response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("data");
        }
        return data;
    }

}
