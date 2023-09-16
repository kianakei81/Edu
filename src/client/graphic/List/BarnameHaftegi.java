package client.graphic.List;


import javax.swing.*;

public class BarnameHaftegi {

    String[][] studentone = new String[5][5];
    String[][] studenttwo = new String[5][5];
    String[][] studentthree = new String[5][5];
    String[][] studentfour = new String[5][5];
    String[][] studentfive = new String[5][5];
    String[][] studentsix = new String[5][5];
    String[][] studentseven = new String[5][5];
    String[][] studenteight = new String[5][5];
    String[][] studentnine = new String[5][5];
    String[] title = new String[5];

    private JTable s1, s2, s3, s4, s5, s6, s7, s8, s9;


    public JTable STUDENTONE(String[][] data) {

        studentone = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s1 = new JTable(studentone, title);

        return s1;
    }

    public JTable STUDENTTWO(String[][] data) {

        studenttwo = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s2 = new JTable(studenttwo, title);

        return s2;
    }

    public JTable STUDENTTHREE(String[][] data) {

        studentthree = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s3 = new JTable(studentthree, title);

        return s3;
    }

    public JTable STUDENTFOUR(String[][] data) {

        studentfour = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s4 = new JTable(studentfour, title);

        return s4;
    }

    public JTable STUDENTFIVE(String[][] data) {

        studentfive = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s5 = new JTable(studentfive, title);

        return s5;
    }

    public JTable STUDENTSIX(String[][] data) {

        studentsix = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s6 = new JTable(studentsix, title);

        return s6;
    }

    public JTable STUDENTSEVEN(String[][] data) {

        studentseven = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s7 = new JTable(studentseven, title);

        return s7;
    }

    public JTable STUDENTEIGHT(String[][] data) {

        studenteight = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s8 = new JTable(studenteight, title);

        return s8;
    }

    public JTable STUDENTNINE(String[][] data) {

        studentnine = data;

        title[0] = "ساعت";
        title[1] = "درس";
        title[2] = "ساعت";
        title[3] = "درس";
        title[4] = "روز";

        s9 = new JTable(studentnine, title);

        return s9;
    }

}

