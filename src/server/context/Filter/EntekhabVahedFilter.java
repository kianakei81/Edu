package server.context.Filter;

import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class EntekhabVahedFilter {

    public static String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

    public static String[][] RiaziFilter(int j) {
        String[][] data = new String[j + 1][12];
        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";
        data[0][3] = "دانشکده";
        data[0][4] = "کد";
        data[0][5] = "مقطع";
        data[0][6] = "ظرفیت";
        data[0][7] = "پیشنیاز";
        data[0][8] = "همنیاز";
        data[0][9] = "دستیار";
        data[0][10] = "زمان";
        data[0][11] = "امتحان";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("ریاضی")) {
                    for(int i = 0; i < 12; i++) {
                        data[n][i] = uni[i];
                    }
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return data;
    }

    public static String[][] MaarefFilter(int j) {
        String[][] data = new String[j + 1][12];
        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";
        data[0][3] = "دانشکده";
        data[0][4] = "کد";
        data[0][5] = "مقطع";
        data[0][6] = "ظرفیت";
        data[0][7] = "پیشنیاز";
        data[0][8] = "همنیاز";
        data[0][9] = "دستیار";
        data[0][10] = "زمان";
        data[0][11] = "امتحان";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("معارف")) {
                    for(int i = 0; i < 12; i++) {
                        data[n][i] = uni[i];
                    }
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return data;
    }

    public static String[][] PhysicsFilter(int j) {
        String[][] data = new String[j + 1][12];
        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";
        data[0][3] = "دانشکده";
        data[0][4] = "کد";
        data[0][5] = "مقطع";
        data[0][6] = "ظرفیت";
        data[0][7] = "پیشنیاز";
        data[0][8] = "همنیاز";
        data[0][9] = "دستیار";
        data[0][10] = "زمان";
        data[0][11] = "امتحان";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("فیزیک")) {
                    for(int i = 0; i < 12; i++) {
                        data[n][i] = uni[i];
                    }
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return data;

    }

    public static String[][] BarghFilter(int j) {
        String[][] data = new String[j + 1][12];
        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";
        data[0][3] = "دانشکده";
        data[0][4] = "کد";
        data[0][5] = "مقطع";
        data[0][6] = "ظرفیت";
        data[0][7] = "پیشنیاز";
        data[0][8] = "همنیاز";
        data[0][9] = "دستیار";
        data[0][10] = "زمان";
        data[0][11] = "امتحان";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("برق")) {
                    for(int i = 0; i < 12; i++) {
                        data[n][i] = uni[i];
                    }
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return data;

    }

    public static String[][] CsFilter(int j) {
        String[][] data = new String[j + 1][12];
        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";
        data[0][3] = "دانشکده";
        data[0][4] = "کد";
        data[0][5] = "مقطع";
        data[0][6] = "ظرفیت";
        data[0][7] = "پیشنیاز";
        data[0][8] = "همنیاز";
        data[0][9] = "دستیار";
        data[0][10] = "زمان";
        data[0][11] = "امتحان";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("کامپیوتر")) {
                    for(int i = 0; i < 12; i++) {
                        data[n][i] = uni[i];
                    }
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return data;

    }

    public static String[][] OmranFilter(int j) {
        String[][] data = new String[j + 1][12];
        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";
        data[0][3] = "دانشکده";
        data[0][4] = "کد";
        data[0][5] = "مقطع";
        data[0][6] = "ظرفیت";
        data[0][7] = "پیشنیاز";
        data[0][8] = "همنیاز";
        data[0][9] = "دستیار";
        data[0][10] = "زمان";
        data[0][11] = "امتحان";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("عمران")) {
                    for(int i = 0; i < 12; i++) {
                        data[n][i] = uni[i];
                    }
                    n++;
                }
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
