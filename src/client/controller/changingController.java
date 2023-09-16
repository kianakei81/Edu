package client.controller;

import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class changingController {

    public static boolean changing(String message, int token, String username, String old, String New) {
        boolean result = false;
        Request request = new Request(RequestType.valueOf(message));
        request.addData("username", username);
        request.addData("oldNumber", old);
        request.addData("newNumber", New);
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            result = (boolean) response.getData("result");
        }
        return result;
    }

}
