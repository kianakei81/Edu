package client.controller;

import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class lessonListController {

    public static String[][] lessonList(String message, int token) {

        String[][] data = null;
        // TODO
        try {
            Request request = new Request(RequestType.valueOf(message));
            Response response = ServerController.sendAnyRequest(request, token);
            if (response.getStatus() == ResponseStatus.OK) {
                data = (String[][]) response.getData("lessonList");
            }
        } catch (Exception e) {
            // TODO
            // offline database
        }

        return data;
    }


}
