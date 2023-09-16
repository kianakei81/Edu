package client.graphic.List;


import javax.swing.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ListDars {

    private JTable table;
    private String[] title;
    private JRadioButton RB1, RB2, RB3;


    public JTable ListDars(String[][] data) {

        title = new String[12];
        title[0] = "امتحان";
        title[1] = "زمان";
        title[2] = "دستیار";
        title[3] = "همنیاز";
        title[4] = "پیشنیاز";
        title[5] = "ظرفیت";
        title[6] = "مقطع";
        title[7] = "کد";
        title[8] = "دانشکده";
        title[9] = "درس";
        title[10] = "استاد";
        title[11] = "واحد";

        table = new JTable(data, title);
        table.setBounds(30,230,550,250);

        return table;

    }

    public JRadioButton filter1() {
        RB1 = new JRadioButton("واحد");
        RB1.setBounds(230,80,50,50);
        return RB1;
    }

    public JRadioButton filter2() {
        RB2 = new JRadioButton("دانشکده");
        RB2.setBounds(230,110,60,60);
        return RB2;
    }

    public JRadioButton filter3() {
        RB3 = new JRadioButton("استاد");
        RB3.setBounds(230,150,50,50);
        return RB3;
    }



}

