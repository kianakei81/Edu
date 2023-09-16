package client.controller;

import client.network.ResponseVisitor;
import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class profileController {

    public static String[] profile(String message, int token, String username) {
        String[] data = null;
        Request request1 = new Request(RequestType.valueOf(message));
        request1.addData("username", username);
        Response response1 = ServerController.sendAnyRequest(request1, token);
        if (response1.getStatus() == ResponseStatus.OK) {
            data = (String[]) response1.getData("data");
        }
        return data;
    }

}
