package server.responseSender;

import server.context.ProfileInformation;
import shared.response.Response;
import shared.response.ResponseStatus;

public class profileResponse {

    public static Response sendProfileResponse(int id, Boolean result, String username, int token) {
        Response response;
        if(result) {
            String[] data;
            response = new Response(ResponseStatus.OK);
            String[] user = username.split("");
            // ostad
            if(user[0].equals("o")) {
                data = ProfileInformation.TeacherInfo(username);
            } else { // daneshjoo
                data = ProfileInformation.StudentInfo(username);
            }
            response.addData("data", data);
            response.addData("authToken", token);

        } else {
            response = new Response(ResponseStatus.ERROR);
        }

        return response;
    }

}
