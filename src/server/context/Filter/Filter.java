package server.context.Filter;

import shared.request.Request;
import shared.util.Config;

import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Filter {

    public static String[][] ostad = new String[1][4];


    public static String[][] FilterDaneshkadeRiazi(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] dt = new String[j + 1][3];

        dt[0][0] = "واحد";
        dt[0][1] = "استاد";
        dt[0][2] = "درس";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("ریاضی")) {
                    dt[n][0] = uni[0];
                    dt[n][1] = uni[1];
                    dt[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return dt;

    }

    public static String[][] FilterDaneshkadeBargh(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] dt = new String[j + 1][3];

        dt[0][0] = "واحد";
        dt[0][1] = "استاد";
        dt[0][2] = "درس";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("برق")) {
                    dt[n][0] = uni[0];
                    dt[n][1] = uni[1];
                    dt[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return dt;
    }

    public static String[][] FilterDaneshkadePhysics(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] dt = new String[j + 1][3];

        dt[0][0] = "واحد";
        dt[0][1] = "استاد";
        dt[0][2] = "درس";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("فیزیک")) {
                    dt[n][0] = uni[0];
                    dt[n][1] = uni[1];
                    dt[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return dt;
    }

    public static String[][] FilterDaneshkadeCs(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] dt = new String[j + 1][3];

        dt[0][0] = "واحد";
        dt[0][1] = "استاد";
        dt[0][2] = "درس";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("کامپیوتر")) {
                    dt[n][0] = uni[0];
                    dt[n][1] = uni[1];
                    dt[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return dt;
    }

    public static String[][] FilterDaneshkadeOmran(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");


        String[][] dt = new String[j + 1][3];

        dt[0][0] = "واحد";
        dt[0][1] = "استاد";
        dt[0][2] = "درس";

        int n = 1;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[3].equals("عمران")) {
                    dt[n][0] = uni[0];
                    dt[n][1] = uni[1];
                    dt[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return dt;
    }

    public static String[][] FilterVahedOne(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] oneVahed = new String[j][3];

        int n = 0;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[0].equals("1")) {
                    oneVahed[n][0] = uni[3];
                    oneVahed[n][1] = uni[1];
                    oneVahed[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return oneVahed;

    }

    public static String[][] FilterVahedTwo(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] twoVahed = new String[j][3];

        int n = 0;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[0].equals("2")) {
                    twoVahed[n][0] = uni[3];
                    twoVahed[n][1] = uni[1];
                    twoVahed[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }


        return twoVahed;
    }

    public static String[][] FilterVahedThree(int j) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] threeVahed = new String[j][3];

        int n = 0;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[0].equals("3")) {
                    threeVahed[n][0] = uni[3];
                    threeVahed[n][1] = uni[1];
                    threeVahed[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }


        return threeVahed;
    }

    public static String[][] FilterVahedFour(int j) {


        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String[][] fourVahed = new String[j][3];

        int n = 0;
        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] uni = d.split(" ");
                if(uni[0].equals("4")) {
                    fourVahed[n][0] = uni[3];
                    fourVahed[n][1] = uni[1];
                    fourVahed[n][2] = uni[2];
                    n++;
                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }


        return fourVahed;
    }

    public static String[][] FilterOstad(Request request) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        ostad[0][0] = " ";
        ostad[0][1] = " ";
        ostad[0][2] = " ";
        ostad[0][3] = " ";

        try {
            File file = new File(uniFileAddress);
            Scanner File = new Scanner(file);
            while (File.hasNextLine()) {
                String d = File.nextLine();
                String[] data = d.split(" ");
                if(data[1].equals(request.getData("OstadName"))) {
                    ostad[0][0] = data[0];
                    ostad[0][1] = data[3];
                    ostad[0][2] = data[1];
                    ostad[0][3] = data[2];

                }
            }
            File.close();
        }
        catch(FileNotFoundException f) {
            System.out.println("An error occurred.");
            f.printStackTrace();
        }

        return ostad;

    }

}
