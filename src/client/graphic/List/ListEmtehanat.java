package client.graphic.List;


import javax.swing.*;

public class ListEmtehanat {

    String[][] studentone = new String[6][4];
    String[][] studenttwo = new String[6][4];
    String[][] studentthree = new String[6][4];
    String[][] studentfour = new String[6][4];
    String[][] studentfive = new String[6][4];
    String[][] studentsix = new String[6][4];
    String[][] studentseven = new String[6][4];
    String[][] studenteight = new String[6][4];
    String[][] studentnine = new String[6][4];

    String[] title = new String[4];

    private JTable s1, s2, s3, s4, s5, s6, s7, s8, s9;


    public JTable STUDENTONE(String[][] data) {

        studentone = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s1 = new JTable(studentone, title);

        return s1;

    }

    public JTable STUDENTTWO(String[][] data) {

        studenttwo = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s2 = new JTable(studenttwo, title);

        return s2;

    }

    public JTable STUDENTTHREE(String[][] data) {

        studentthree = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s3 = new JTable(studentthree, title);

        return s3;
    }

    public JTable STUDENTFOUR(String[][] data) {

        studentfour = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s4 = new JTable(studentfour, title);

        return s4;
    }

    public JTable STUDENTFIVE(String[][] data) {

        studentfive = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s5 = new JTable(studentfive, title);

        return s5;
    }

    public JTable STUDENTSIX(String[][] data) {

        studentsix = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s6 = new JTable(studentsix, title);

        return s6;
    }

    public JTable STUDENTSEVEN(String[][] data) {

        studentseven = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s7 = new JTable(studentseven, title);

        return s7;
    }

    public JTable STUDENTEIGHT(String[][] data) {

        studenteight = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s8 = new JTable(studenteight, title);

        return s8;
    }

    public JTable STUDENTNINE(String[][] data) {

        studentnine = data;

        title[0] = "روز";
        title[1] = "تاریخ";
        title[2] = "درس";
        title[3] = "ساعت";

        s9 = new JTable(studentnine, title);

        return s9;
    }

}

