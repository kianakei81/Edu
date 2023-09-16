package server.context;

import shared.request.Request;
import shared.util.Config;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AddLesson {

    public static void addlessons(Request request) {

        String uniFileAddress = Config.getConfig().getProperty(String.class, "UNI_FILE_ADDRESS");

        String emtehan = (String) request.getData("emtehan");
        String zaman = (String) request.getData("zaman");
        String dastyar = (String) request.getData("dastyar");
        String hamniaz = (String) request.getData("hamniaz");
        String pishniaz = (String) request.getData("pishniaz");
        String zarfiat = (String) request.getData("zarfiat");
        String maghta = (String) request.getData("maghta");
        String code = (String) request.getData("code");
        String daneshkade = (String) request.getData("daneshkade");
        String dars = (String) request.getData("dars");
        String ostad = (String) request.getData("ostad");
        String vahed = (String) request.getData("vahed");

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter(uniFileAddress, true));
            out.write("\n" +vahed + " " + ostad + " " + dars + " " + daneshkade + " " + zarfiat + " " +
                    pishniaz + " " + code + " " + maghta + " " + hamniaz + " " + dastyar + " " + zaman + " " + emtehan);
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }

}
