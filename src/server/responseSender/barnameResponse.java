package server.responseSender;

import server.context.List.Barname;
import shared.response.Response;
import shared.response.ResponseStatus;

public class barnameResponse {

    public static Response sendBarnameResponse(int id, boolean result, String username, int token) {
        Response response;
        if(result) {
            String[][] data = new String[5][5];
            response = new Response(ResponseStatus.OK);
            if(username.equals("studentone")) {
                data = Barname.STUDENTONE();
            } else if(username.equals("studenttwo")) {
                data = Barname.STUDENTTWO();
            } else if(username.equals("studentthree")) {
                data = Barname.STUDENTTHREE();
            } else if(username.equals("studentfour")) {
                data = Barname.STUDENTFOUR();
            } else if(username.equals("studentfive")) {
                data = Barname.STUDENTFIVE();
            } else if(username.equals("studentsix")) {
                data = Barname.STUDENTSIX();
            } else if(username.equals("studentseven")) {
                data = Barname.STUDENTSEVEN();
            } else if(username.equals("studenteight")) {
                data = Barname.STUDENTEIGHT();
            } else if(username.equals("studentnine")) {
                data = Barname.STUDENTNINE();
            }
            response.addData("data", data);
            response.addData("authToken", token);
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
