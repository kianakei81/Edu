package client.controller;

import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class filterDarsController {

    public static String[][] filterRiazi(String message, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("filterRiazi");
        }
        return data;
    }

    public static String[][] filterBargh(String message, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("filterBargh");
        }
        return data;
    }

    public static String[][] filterCs(String message, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("filterCs");
        }
        return data;
    }

    public static String[][] filterPhysic(String message, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("filterPhysic");
        }
        return data;
    }

    public static String[][] filterOmran(String message, int token) {
        String[][] data = null;
        Request request = new Request(RequestType.valueOf(message));
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            data = (String[][]) response.getData("filterOmran");
        }
        return data;
    }

}
