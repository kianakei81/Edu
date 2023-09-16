package client.graphic.List;


import javax.swing.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListOstad {

    private JTable table;

    private String[] title;

    private String[][] data;


    public JTable ListOstad(String[][] input) {

        data = input;

        title = new String[5];
        title[0] = "سمت";
        title[1] = "نام";
        title[2] = "نام خانوادگی";
        title[3] = "ایمیل";
        title[4] = "شماره اتاق";


        table = new JTable(data, title);
        table.setBounds(10,180,480,230);

        return table;

    }



}

