package client.controller;

import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class addLessonController {

    public static boolean addLesson(String message, int token, String username, String vahed, String dars, String daneshkade,
                                    String ostad, String maghta, String dastyar, String code, String pishniaz, String hamniaz,
                                    String zaman, String emtehan, String zarfiat) {

        boolean result = false;

        Request request = new Request(RequestType.valueOf(message));
        request.addData("username", username);
        request.addData("vahed", vahed);
        request.addData("dars", dars);
        request.addData("daneshkade", daneshkade);
        request.addData("ostad", ostad);
        request.addData("maghta", maghta);
        request.addData("dastyar", dastyar);
        request.addData("code", code);
        request.addData("pishniaz", pishniaz);
        request.addData("hamniaz", hamniaz);
        request.addData("zaman", zaman);
        request.addData("emtehan", emtehan);
        request.addData("zarfiat", zarfiat);
        Response response = ServerController.sendAnyRequest(request, token);
        if (response.getStatus() == ResponseStatus.OK) {
            result = true;
        }
        return result;
    }

}
