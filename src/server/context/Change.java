package server.context;

import shared.util.Config;

import javax.swing.*;
import java.io.*;
import java.util.Scanner;

public class Change {

    public static String usersFileAddress = Config.getConfig().getProperty(String.class, "USERS_FILE_ADDRESS");

    public static boolean result = false;

    public static boolean changeEmail(String username, String old, String NEW) {

        String[] info = new String[11];
        try {
            File file = new File(usersFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String data = File.nextLine();
                String[] users = data.split(" ");
                if(users[0].equals(username)) {
                    for(int i = 0; i < 11; i++) {
                        info[i] = users[i];
                    }
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        if(info[7].equals(old)) {
            LISTENER(info, old, NEW);
            result = true;
        } else {
            result = false;
        }

        return result;
    }

    public static boolean changeNumber(String username, String old, String NEW) {

        String[] info = new String[11];
        try {
            File file = new File(usersFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String data = File.nextLine();
                String[] users = data.split(" ");
                if(users[0].equals(username)) {
                    for(int i = 0; i < 11; i++) {
                        info[i] = users[i];
                    }
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        if(info[6].equals(old)) {
            LISTENER(info, old, NEW);
            result = true;
        } else {
            result = false;
        }

        return result;

    }

    public static void LISTENER(String[] info, String oldString, String newString) {
        File FILE = new File(usersFileAddress);
        String oldContent = "";
        BufferedReader reader = null;
        FileWriter writer = null;

        try {
            reader = new BufferedReader(new FileReader(FILE));

            String line = reader.readLine();

            while (line != null) {
                oldContent = oldContent + line + System.lineSeparator();
                line = reader.readLine();
            }

            String newContent = oldContent.replaceAll(oldString, newString);

            writer = new FileWriter(FILE);

            writer.write(newContent);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                reader.close();
                writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

}
