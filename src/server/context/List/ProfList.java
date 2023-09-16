package server.context.List;

import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProfList {

    public static String usersFileAddress = Config.getConfig().getProperty(String.class, "USERS_FILE_ADDRESS");

    public static String[][] data;

    public static int j;

    public static String[][] ostad(int k) {

        data = new String[k + 1][5];
        j = 1;

        try {
            File file = new File(usersFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] users = d.split(" ");
                String[] username = users[0].split("");
                if(username[0].equals("o")) {
                    data[j][0] = users[2];
                    data[j][1] = users[3];
                    data[j][2] = users[4];
                    data[j][3] = users[7];
                    data[j][4] = users[9];
                    j++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        data[0][0] = "سمت";
        data[0][1] = "نام";
        data[0][2] = "نام خانوادگی";
        data[0][3] = "ایمیل";
        data[0][4] = "شماره اتاق";

        return data;

    }

}
