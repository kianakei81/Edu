package server.responseSender;

import server.context.List.ExamsList;
import shared.request.Request;
import shared.response.Response;
import shared.response.ResponseStatus;

public class listEmtehanResponse {

    public static Response sendListEmtehanatResponse(int id, boolean result, Request request, int token) {
        Response response;
        if(result) {
            String[][] data = new String[6][4];
            response = new Response(ResponseStatus.OK);
            if(request.getData("username").equals("studentone")) {
                data = ExamsList.StudentOne();
            } else if(request.getData("username").equals("studenttwo")) {
                data = ExamsList.StudentTwo();
            } else if(request.getData("username").equals("studentthree")) {
                data = ExamsList.StudentThree();
            } else if(request.getData("username").equals("studentfour")) {
                data = ExamsList.StudentFour();
            } else if(request.getData("username").equals("studentfive")) {
                data = ExamsList.StudentFive();
            } else if(request.getData("username").equals("studentsix")) {
                data = ExamsList.StudentSix();
            } else if(request.getData("username").equals("studentseven")) {
                data = ExamsList.StudentSeven();
            } else if(request.getData("username").equals("studenteight")) {
                data = ExamsList.StudentEight();
            } else if(request.getData("username").equals("studentnine")) {
                data = ExamsList.StudentNine();
            }
            response.addData("data", data);
            response.addData("authToken", token);
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
