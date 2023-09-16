package server.responseSender;

import server.context.List.ProfList;
import shared.response.Response;
import shared.response.ResponseStatus;
import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class listOstadResponse {

    public static String usersFileAddress = Config.getConfig().getProperty(String.class, "USERS_FILE_ADDRESS");

    public static Response sendListOstadResponse(int id, boolean result, int token) {
        Response response;
        if(result) {
            response = new Response(ResponseStatus.OK);
            // پیدا میکنه چند تا استاد داریم
            int j = 0;
            try {
                File file = new File(usersFileAddress);
                Scanner File = new Scanner(file);
                while (File.hasNextLine()) {
                    String d = File.nextLine();
                    String[] users = d.split(" ");
                    String[] user = users[0].split("");
                    if(user[0].equals("o")) {
                        j++;
                    }
                }
                File.close();
            }
            catch(FileNotFoundException f) {
                System.out.println("An error occurred.");
                f.printStackTrace();
            }

            String[][] data = ProfList.ostad(j);
            response.addData("data", data);
            response.addData("authToken", token);
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
