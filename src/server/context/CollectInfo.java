package server.context;

import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class CollectInfo {

    public static String usersFileAddress = Config.getConfig().getProperty(String.class, "USERS_FILE_ADDRESS");

    public static String[][] collectUserAndPass(int j) {
        int i = 0;
        String[][] ID = new String[j][3];
        try {
            File file = new File(usersFileAddress);
            Scanner myReader = new Scanner(file);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] users = data.split(" ");
                ID[i][0] = users[0];
                ID[i][1] = users[1];
                ID[i][2] = users[2];
                i++;
            }
            myReader.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }
        return ID;
    }

}
