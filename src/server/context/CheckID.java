package server.context;

import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CheckID {

    public static String usersFileAddress = Config.getConfig().getProperty(String.class, "USERS_FILE_ADDRESS");

    public static boolean checkId(String username, String password) {

        boolean isIdValid = false;

        // پیدا میکنه فایل users چند خطه
        int j = 0;
        try {
            File file = new File(usersFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                j++;
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        String[][] ID = CollectInfo.collectUserAndPass(j);
        for(int i = 0; i < j; i++) {
            if(ID[i][0].equals(username) && ID[i][1].equals(password)) {
                isIdValid = true;
            }
        }
        return isIdValid;
    }

}
