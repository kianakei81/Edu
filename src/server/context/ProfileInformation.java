package server.context;

import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ProfileInformation {

    public static String usersFileAddress = Config.getConfig().getProperty(String.class, "USERS_FILE_ADDRESS");

    public static String[] StudentInfo(String username) {
        String[] ID = new String[14];
        try {
            File file = new File(usersFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String data = File.nextLine();
                String[] users = data.split(" ");
                if(users[0].equals(username)) {
                    for(int i = 0; i < 14; i++) {
                        ID[i] = users[i];
                    }
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }
        return ID;
    }

    public static String[] TeacherInfo(String username) {
        String[] ID = new String[11];
        try {
            File file = new File(usersFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String data = File.nextLine();
                String[] users = data.split(" ");
                if(users[0].equals(username)) {
                    for(int i = 0; i < 11; i++) {
                        ID[i] = users[i];
                    }
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }
        return ID;
    }

}
