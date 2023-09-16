package server.responseSender;

import server.context.Change;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

public class changingEmailOrNumberResponse {

    public static Response sendChangingEmailOrNumberResponse(int id, boolean result, Request request, int token) {
        Response response;
        if (result) {
            response = new Response(ResponseStatus.OK);
            if(request.getRequestType() == RequestType.ChangingEmail) {
                boolean res = Change.changeEmail((String) request.getData("username"),
                        (String) request.getData("oldEmail"),
                        (String) request.getData("newEmail"));
                response.addData("result", res);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.ChangingNumber) {
                boolean res = Change.changeNumber((String) request.getData("username"),
                        (String) request.getData("oldNumber"),
                        (String) request.getData("newNumber"));
                response.addData("result", res);
                response.addData("authToken", token);
            }
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
