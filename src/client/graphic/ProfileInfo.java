package client.graphic;


import javax.swing.*;

public class ProfileInfo {

    private JRadioButton RB1, RB2;
    private JTable sP, tP;
    String[][] StudentData;
    String[][] TeacherData;
    String[] title;

    public JTable studentProfile(String[] information) {
        StudentData = new String[12][2];
        StudentData[0][1] = "نام";
        StudentData[1][1] = "نام خانوداگی";
        StudentData[2][1] = "کد ملی";
        StudentData[3][1] = "شماره دانشجویی";
        StudentData[4][1] = "شماره موبایل";
        StudentData[5][1] = "پست الکترونیک";
        StudentData[6][1] = "معدل کل";
        StudentData[7][1] = "دانشکده";
        StudentData[8][1] = "استاد راهنما";
        StudentData[9][1] = "سال ورود";
        StudentData[10][1] = "مقطع";
        StudentData[11][1] = "وضعیت";

        StudentData[0][0] = information[3];
        StudentData[1][0] = information[4];
        StudentData[2][0] = information[5];
        StudentData[3][0] = information[1];
        StudentData[4][0] = information[6];
        StudentData[5][0] = information[7];
        StudentData[6][0] = information[8];
        StudentData[7][0] = information[9];
        StudentData[8][0] = information[10];
        StudentData[9][0] = information[11];
        StudentData[10][0] = information[12];
        StudentData[11][0] = "در حال تحصیل";

        title = new String[2];
        title[0] = "اطلاعات";
        title[1] = "عنوان";

        sP = new JTable(StudentData, title);
        sP.setBounds(10,190,480,230);

        return sP;
    }

    public JTable teacherProfile(String[] information) {
        TeacherData = new String[9][2];
        TeacherData[0][1] = "نام";
        TeacherData[1][1] = "نام خانوداگی";
        TeacherData[2][1] = "کد ملی";
        TeacherData[3][1] = "شماره استادی";
        TeacherData[4][1] = "شماره موبایل";
        TeacherData[5][1] = "پست الکترونیک";
        TeacherData[6][1] = "دانشکده";
        TeacherData[7][1] = "شماره اتاق";
        TeacherData[8][1] = "درجه استادی";

        TeacherData[0][0] = information[3];
        TeacherData[1][0] = information[4];
        TeacherData[2][0] = information[5];
        TeacherData[3][0] = information[1];
        TeacherData[4][0] = information[6];
        TeacherData[5][0] = information[7];
        TeacherData[6][0] = information[8];
        TeacherData[7][0] = information[9];
        TeacherData[8][0] = information[10];

        title = new String[2];
        title[0] = "اطلاعات";
        title[1] = "عنوان";

        tP = new JTable(TeacherData, title);
        tP.setBounds(10,200,480,230);

        return tP;

    }

    public JRadioButton CHANGE_EMAIL() {
        RB1 = new JRadioButton("تغییر ایمیل");
        RB1.setBounds(180,65,70,30);
        return RB1;
    }

    public JRadioButton CHANGE_PHONE() {
        RB2 = new JRadioButton("تغییر شماره تلفن");
        RB2.setBounds(180,100,100,30);
        return RB2;
    }


}

