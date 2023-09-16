package server.responseSender;

import server.context.Filter.Filter;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;
import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class filterResponse {

    public static String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

    public static Response sendFilterResponse(int id, boolean result, int token, Request request) {
        Response response;
        if(result) {
            response = new Response(ResponseStatus.OK);
            if(request.getRequestType() == RequestType.FilterDaneshkadeRiazi) {

                // تعداد دروس دانشکده ریاضی
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[3].equals("ریاضی")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterDaneshkadeRiazi(j);
                response.addData("filterRiazi", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterDaneshkadeCs) {

                // تعداد دروس دانشکده کامپیوتر
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[3].equals("کامپیوتر")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterDaneshkadeCs(j);
                response.addData("filterCs", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterDaneshkadeBargh) {

                // تعداد دروس دانشکده برق
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[3].equals("برق")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterDaneshkadeBargh(j);
                response.addData("filterBargh", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterDaneshkadePhysics) {

                // تعداد دروس دانشکده فیزیک
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[3].equals("فیزیک")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }


                String[][] data = Filter.FilterDaneshkadePhysics(j);
                response.addData("filterPhysics", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterDaneshkadeOmran) {

                // تعداد دروس دانشکده عمران
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[3].equals("عمران")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterDaneshkadeOmran(j);
                response.addData("filterOmran", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterVahedOne) {

                // تعداد دروس یک واحدی
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[0].equals("1")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterVahedOne(j);
                response.addData("filterOne", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterVahedTwo) {

                // تعداد دروس دو واحدی
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[0].equals("2")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterVahedTwo(j);
                response.addData("filterTwo", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterVahedThree) {

                // تعداد دروس سه واحدی
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[0].equals("3")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterVahedThree(j);
                response.addData("filterThree", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterVahedFour) {

                // تعداد دروس چهار واحدی
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[0].equals("4")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = Filter.FilterVahedFour(j);
                response.addData("filterFour", data);
                response.addData("authToken", token);
            } else if(request.getRequestType() == RequestType.FilterOstad) {
                String[][] data = Filter.FilterOstad(request);
                response.addData("filterOstad", data);
                response.addData("authToken", token);
            }
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
