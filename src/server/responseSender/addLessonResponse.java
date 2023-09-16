package server.responseSender;

import server.context.AddLesson;
import shared.request.Request;
import shared.response.Response;
import shared.response.ResponseStatus;

public class addLessonResponse {

    public static Response sendAddLessonResponse(int id, boolean result, Request request) {
        Response response;
        if(result) {
            response = new Response(ResponseStatus.OK);
            AddLesson.addlessons(request);
            response.addData("authToken", request.getData("authToken"));
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
