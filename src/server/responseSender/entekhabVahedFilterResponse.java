package server.responseSender;

import server.context.Filter.EntekhabVahedFilter;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;
import shared.util.Config;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class entekhabVahedFilterResponse {

    public static String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

    public static Response sendEntekhabVahedFilterResponse(int id, boolean result, Request request) {
        Response response;
        int token = (int) request.getData("authToken");
        if(result) {
            response = new Response(ResponseStatus.OK);
            if(request.getRequestType() == RequestType.RiaziFilter) {

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

                String[][] data = EntekhabVahedFilter.RiaziFilter(j);
                response.addData("RiaziFilter", data);
                response.addData("authToken", token);

            } else if(request.getRequestType() == RequestType.PhysicsFilter){

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

                String[][] data = EntekhabVahedFilter.PhysicsFilter(j);
                response.addData("satr", j);
                response.addData("PhysicsFilter", data);
                response.addData("authToken", token);

            } else if(request.getRequestType() == RequestType.OmranFilter){

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

                String[][] data = EntekhabVahedFilter.OmranFilter(j);
                response.addData("OmranFilter", data);
                response.addData("authToken", token);

            } else if(request.getRequestType() == RequestType.CsFilter){

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

                String[][] data = EntekhabVahedFilter.CsFilter(j);
                response.addData("CsFilter", data);
                response.addData("authToken", token);

            } else if(request.getRequestType() == RequestType.BarghFilter) {

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

                String[][] data = EntekhabVahedFilter.BarghFilter(j);
                response.addData("BarghFilter", data);
                response.addData("authToken", token);

            } else if(request.getRequestType() == RequestType.MaarefFilter) {
                // تعداد دروس دانشکده معارف
                int j = 0;
                try {
                    File file = new File(uniFileAddress);
                    Scanner File = new Scanner(file);
                    while (File.hasNextLine()) {
                        String d = File.nextLine();
                        String[] uni = d.split(" ");
                        if(uni[3].equals("معارف")) {
                            j++;
                        }
                    }
                    File.close();
                }
                catch(FileNotFoundException f) {
                    System.out.println("An error occurred.");
                    f.printStackTrace();
                }

                String[][] data = EntekhabVahedFilter.MaarefFilter(j);
                response.addData("MaarefFilter", data);
                response.addData("authToken", token);

            }
        } else {
            response = new Response(ResponseStatus.ERROR);
        }
        return response;
    }

}
