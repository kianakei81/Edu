package server.context.List;

import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public  class LessonList {

    public static String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

    public static int j;

    public static String[][] lessonsList(int k) {

        String[][] data = new String[k][12];

        j = 0;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                for(int i = 0; i < 12; i++) {
                    data[j][i] = uni[i];
                }
                j++;
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return data;
    }

}
