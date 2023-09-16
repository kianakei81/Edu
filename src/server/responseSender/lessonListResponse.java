package server.responseSender;

import server.context.List.LessonList;
import shared.response.Response;
import shared.response.ResponseStatus;
import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class lessonListResponse {

    public static String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

    public static Response sendLessonListResponse(int id, boolean result, int token) {
        Response response;
        if(result) {
            int k = 0;
            // پیدا میکنه فایل چندخطه
            try {
                File file = new File(uniFileAddress);
                Scanner File = new Scanner(file);
                while (File.hasNextLine()) {
                    String d = File.nextLine();
                    k++;
                }
                File.close();
            }
            catch(FileNotFoundException f) {
                System.out.println("An error occurred.");
                f.printStackTrace();
            }

            String[][] data = LessonList.lessonsList(k);
            response = new Response(ResponseStatus.OK);
            response.addData("authToken", token);
            response.addData("lessonList", data);
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
