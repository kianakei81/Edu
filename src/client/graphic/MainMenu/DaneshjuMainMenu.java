package client.graphic.MainMenu;


import client.controller.*;
import client.graphic.*;
import client.graphic.Edit.Changing;
import client.graphic.Filter.FilterDars;
import client.graphic.List.BarnameHaftegi;
import client.graphic.List.ListDars;
import client.graphic.List.ListEmtehanat;
import client.graphic.List.ListOstad;
import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;
import shared.util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;



public class DaneshjuMainMenu extends JFrame {

    JFrame newFrame = new JFrame();
    JPanel newPanel = new JPanel();
    private JTable table, ostadTable, StudentProfileTable, BARNAME_HAFTEGI, LISTEMTEHAN;
    private JRadioButton rb1, rb2, rb3, changingPhone, changingEmail;

    String[] information;

    private Date date;

    JFrame fr = new JFrame("سامانه آموزش");
    JPanel pane = new JPanel();

    private JMenuBar menuBar;
    private JMenu SabteNam, Amuzeshi, Karname, Profile, cw;
    private JMenuItem Dars, Ostad, Barname, Emtehan, Darkhast, Movaghat,
            Tahsili, profileKarbar, entekhabVahed, peygham, cwItem;

    private JButton exit, bazgasht, click, ok;

    private JLabel email, email_address, photo, name, nameLabel,
            AkharinVorud, AkharinVorudLabel,
            OstadRahnama, OstadRahnamaLabel, vaziat, vaziatLabel,
            mojavez, mojavezLabel, saat, saatLabel, fil, AX;


    public DaneshjuMainMenu(String username) {

        Request request = new Request(RequestType.Profile);
        request.addData("username", username);
        Response response = ServerController.sendAnyRequest(request, ServerController.AuthToken);

        if(response.getStatus() == ResponseStatus.OK) {
            information = (String[]) response.getData("data");
        }


        Integer w = Config.getConfig().getProperty(Integer.class, "USER_MAIN_MENU");
        newFrame.setSize(new Dimension(w,w));
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);
        newFrame.setLayout(null);
        newPanel.setSize(new Dimension(w,w));
        newPanel.setLayout(null);


        // panel setting
        pane.setSize(new Dimension(500, 500));
        pane.setBackground(Color.gray);

        // frame setting
        fr.setSize(new Dimension(500, 500));
        fr.setResizable(false);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);

        // menu
        menuBar = new JMenuBar();
        SabteNam = new JMenu("امور ثبت نام");
        Amuzeshi = new JMenu("خدمات آموزشی");
        Karname = new JMenu("امور کارنامه");
        Profile = new JMenu("پروفایل کاربر");
        Dars = new JMenuItem("لیست دروس");
        Ostad = new JMenuItem("لیست اساتید");
        entekhabVahed = new JMenuItem("انتخاب واحد");
        SabteNam.add(entekhabVahed);
        SabteNam.add(Dars);
        SabteNam.add(Ostad);
        Barname = new JMenuItem("برنامه هفتگی");
        Emtehan = new JMenuItem("لیست امتحانات دانشجو");
        Darkhast = new JMenuItem("درخواست ها");
        peygham = new JMenuItem("صفحه پیغام ها");
        Amuzeshi.add(peygham);
        Amuzeshi.add(Barname);
        Amuzeshi.add(Emtehan);
        Amuzeshi.add(Darkhast);
        Movaghat = new JMenuItem("نمرات موقت");
        Tahsili = new JMenuItem("وضعیت تحصیلی");
        Karname.add(Movaghat);
        Karname.add(Tahsili);
        profileKarbar = new JMenuItem("پروفایل کاربر");
        Profile.add(profileKarbar);
        cw = new JMenu("درس افزار");
        cwItem = new JMenuItem("درس افزار");
        cw.add(cwItem);
        menuBar.add(cw);
        menuBar.add(SabteNam);
        menuBar.add(Amuzeshi);
        menuBar.add(Karname);
        menuBar.add(Profile);

        // email
        email = new JLabel("آدرس ایمیل:");
        email.setBounds(400, 255, 50,30);
        email_address = new JLabel(information[7]);
        email_address.setBounds(230,255, 200, 30);

        // photo
        if(username.equals("studentone")) {
            photo = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\female.jpg"));
            photo.setBounds(320,65,150,180);
            pane.add(photo);
        } else {
            photo = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\male.jpg"));
            photo.setBounds(320,65,150,190);
            pane.add(photo);
        }

        // name
        nameLabel = new JLabel("نام و نام خانوادگی:");
        nameLabel.setBounds(380,280,80,30);
        name = new JLabel(information[3]+" "+information[4]);
        name.setBounds(260,280, 120,30);

        exit = new JButton("خروج");
        exit.setBounds(10,10, 60,60);
        exit.setBackground(Color.pink);

        bazgasht = new JButton("صفحه اصلی");
        bazgasht.setBounds(80,10,90,50);

        table = new JTable();
        rb1 = new JRadioButton();
        rb2 = new JRadioButton();
        rb3 = new JRadioButton();
        fil = new JLabel("فیلتر بر اساس:");
        fil.setBounds(250,60,70,30);
        ostadTable = new JTable();
        StudentProfileTable = new JTable();
        changingPhone = new JRadioButton();
        changingEmail = new JRadioButton();
        click = new JButton("click");
        ok = new JButton("فیلتر");
        BARNAME_HAFTEGI = new JTable();
        LISTEMTEHAN = new JTable();


        // Last Login
        AkharinVorudLabel = new JLabel("آخرین ورود:");
        AkharinVorudLabel.setBounds(360,20,80,30);
        String LASTLOGIN = LastLogin(username);
        AkharinVorud = new JLabel(LASTLOGIN);
        AkharinVorud.setBounds(220, 20, 140, 30);

        SaveLogin();


        // ostad rahnama
        OstadRahnamaLabel = new JLabel("استاد راهنما:");
        OstadRahnamaLabel.setBounds(390,305, 70, 30);
        OstadRahnama = new JLabel(information[10]);
        OstadRahnama.setBounds(290, 305, 80, 30);

        vaziatLabel = new JLabel("وضعیت تحصیلی:");
        vaziatLabel.setBounds(380,330,70,30);
        vaziat = new JLabel("در حال تحصیل");
        vaziat.setBounds(290,330,80,30);

        // مجوز ثبت نام
        mojavezLabel = new JLabel("مجوز ثبت نام:");
        mojavezLabel.setBounds(380,350, 70, 30);
        mojavez = new JLabel("مجوز ثبت نام صادر شده است");
        mojavez.setBounds(250,350,120,30);

        // ساعت ثبت نام
        saatLabel = new JLabel("ساعت ثبت نام:");
        saatLabel.setBounds(380,380,70,30);
        saat = new JLabel("از ساعت 7:0 روز 3/12/1400 تا پایان زمان تعیین شده");
        saat.setBounds(120,380,240,30);


        // add
        pane.add(exit);
        pane.add(email);
        pane.add(email_address);
        pane.add(nameLabel);
        pane.add(name);
        pane.add(AkharinVorudLabel);
        pane.add(AkharinVorud);
        pane.add(OstadRahnama);
        pane.add(OstadRahnamaLabel);
        pane.add(vaziat);
        pane.add(vaziatLabel);
        pane.add(mojavez);
        pane.add(mojavezLabel);
        pane.add(saat);
        pane.add(saatLabel);


        pane.setLayout(null);
        fr.add(pane);
        fr.setJMenuBar(menuBar);
        fr.setLayout(null);
        fr.setVisible(true);

        // گزینه ورود به صفحه درس افزار
        cwItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // گزینه انتخاب واحد
        entekhabVahed.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EntekhabVahed.MainMenu(username, ServerController.AuthToken);
            }
        });

        // بازگشت به صفحه ورود
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.setVisible(false);
                EnteringFrame frame = new EnteringFrame();
            }
        });

        // بازگشت به صفحه اصلی دانشجو
        bazgasht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(false);
                new DaneshjuMainMenu(username);
            }
        });

        // لیست دروس
        Dars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request to see the list of lessons
                String[][] data = lessonListController.lessonList("LessonList", ServerController.AuthToken);

                if(data != null) {
                    newPanel.removeAll();
                    newFrameSetting();
                    ListDars ld = new ListDars();
                    rb1 = ld.filter1();
                    rb2 = ld.filter2();
                    rb3 = ld.filter3();
                    table = ld.ListDars(data);
                    ok.setBounds(150,150,70,40);
                    newPanel.add(ok);
                    newPanel.add(fil);
                    newPanel.add(rb1);
                    newPanel.add(rb2);
                    newPanel.add(rb3);
                    newPanel.add(table);
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(newFrame,"ERROR!");
                }
            }
        });

        // دکمه فیلتر کردن دروس
        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(rb2.isSelected() && !rb1.isSelected() && !rb3.isSelected()) {
                    FilterDars fd = new FilterDars();
                    fd.DaneshkadeFilter();
                } else if(!rb2.isSelected() && rb1.isSelected() && !rb3.isSelected()) {
                    FilterDars fd = new FilterDars();
                    fd.VahedFilter();
                } else if(!rb2.isSelected() && !rb1.isSelected() && rb3.isSelected()) {
                    FilterDars fd = new FilterDars();
                    fd.OstadFilter();
                } else {
                    JOptionPane.showMessageDialog(newFrame,"select one");
                }
            }
        });

        // دکمه برای ویرایش ایمیل یا شماره موبایل
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(changingEmail.isSelected() && !changingPhone.isSelected()) {
                    Changing a = new Changing();
                    a.ChangingEmail(username);
                } else if(changingPhone.isSelected() && !changingEmail.isSelected()) {
                    Changing b = new Changing();
                    b.ChangingNumber(username);
                } else if (changingPhone.isSelected() && changingEmail.isSelected()) {
                    JOptionPane.showMessageDialog(newFrame,"select one");
                }
            }
        });

        // برنامه هفتگی دانشجو
        Barname.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPanel.removeAll();
                newFrameSetting();
                BarnameHaftegi bh = new BarnameHaftegi();


                String[][] data = barnameController.barname("Barname", username, ServerController.AuthToken);

                if(data != null) {
                    if(username.equals("studentone")) {
                        BARNAME_HAFTEGI = bh.STUDENTONE(data);
                    } else if(username.equals("studenttwo")) {
                        BARNAME_HAFTEGI = bh.STUDENTTWO(data);
                    } else if(username.equals("studentthree")) {
                        BARNAME_HAFTEGI = bh.STUDENTTHREE(data);
                    } else if(username.equals("studentfour")) {
                        BARNAME_HAFTEGI = bh.STUDENTFOUR(data);
                    } else if(username.equals("studentfive")) {
                        BARNAME_HAFTEGI = bh.STUDENTFIVE(data);
                    } else if(username.equals("studentsix")) {
                        BARNAME_HAFTEGI = bh.STUDENTSIX(data);
                    } else if(username.equals("studentseven")) {
                        BARNAME_HAFTEGI = bh.STUDENTSEVEN(data);
                    } else if(username.equals("studenteight")) {
                        BARNAME_HAFTEGI = bh.STUDENTEIGHT(data);
                    } else if(username.equals("studentnine")) {
                        BARNAME_HAFTEGI = bh.STUDENTNINE(data);
                    }
                    BARNAME_HAFTEGI.setBounds(50,120,350,180);
                    newPanel.add(BARNAME_HAFTEGI);
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(newFrame,"error!");
                }

            }
        });

        // لیست امتحانات دانشجو
        Emtehan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPanel.removeAll();
                newFrameSetting();
                ListEmtehanat le = new ListEmtehanat();

                // send request
                String[][] inf = examsListController.examsList("ListEmtehanat", username, ServerController.AuthToken);

                if(inf != null) {
                    if(username.equals("studentone")) {
                        LISTEMTEHAN = le.STUDENTONE(inf);
                    } else if(username.equals("studenttwo")) {
                        LISTEMTEHAN = le.STUDENTTWO(inf);
                    } else if(username.equals("studentthree")) {
                        LISTEMTEHAN = le.STUDENTTHREE(inf);
                    } else if(username.equals("studentfour")) {
                        LISTEMTEHAN = le.STUDENTFOUR(inf);
                    } else if(username.equals("studentfive")) {
                        LISTEMTEHAN = le.STUDENTFIVE(inf);
                    } else if(username.equals("studentsix")) {
                        LISTEMTEHAN = le.STUDENTSIX(inf);
                    } else if(username.equals("studentseven")) {
                        LISTEMTEHAN = le.STUDENTSEVEN(inf);
                    } else if(username.equals("studenteight")) {
                        LISTEMTEHAN = le.STUDENTEIGHT(inf);
                    } else if(username.equals("studentnine")) {
                        LISTEMTEHAN = le.STUDENTNINE(inf);
                    }

                    LISTEMTEHAN.setBounds(50,120,350,180);
                    newPanel.add(LISTEMTEHAN);
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);
                }

            }
        });




        // لیست اساتید
        Ostad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] data = profListController.profList("ListOstad", ServerController.AuthToken);

                if(data != null) {
                    newPanel.removeAll();
                    newFrameSetting();
                    ListOstad lo = new ListOstad();
                    ostadTable = lo.ListOstad(data);
                    newPanel.add(ostadTable);
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(newFrame,"ERROR!");
                }

            }
        });

        // درخواست ها
        Darkhast.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                client.graphic.Darkhast d = new Darkhast();
                d.MainFrame();
            }
        });


        profileKarbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPanel.removeAll();
                newFrameSetting();
                ProfileInfo PI = new ProfileInfo();

                String[] data = profileController.profile("Profile", ServerController.AuthToken, username);

                if(data != null) {

                    StudentProfileTable = PI.studentProfile(data);
                    changingEmail = PI.CHANGE_EMAIL();
                    changingPhone = PI.CHANGE_PHONE();

                    click.setBounds(180,130,70,40);
                    if(username.equals("studentone")) {
                        AX = new JLabel(new ImageIcon("C:\\Users\\Global Village\\IdeaProjects\\FAZE_2\\src\\client\\resources\\Images\\female.jpg"));
                        AX.setBounds(320,65,120,150);
                        newPanel.add(AX);
                    } else {
                        AX = new JLabel(new ImageIcon("C:\\Users\\Global Village\\IdeaProjects\\FAZE_2\\src\\client\\resources\\Images\\male.jpg"));
                        AX.setBounds(320,65,120,150);
                        newPanel.add(AX);
                    }
                    newPanel.add(click);
                    newPanel.add(changingEmail);
                    newPanel.add(changingPhone);
                    newPanel.add(StudentProfileTable);
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                }

            }
        });

    }

    public void saveInformation() {

    }



    // ثبت زمان ورود در فایل
    public void SaveLogin() {
        Date date = new Date();
        SimpleDateFormat SDF = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
        String d = SDF.format(date);

        try {
            BufferedWriter out = new BufferedWriter(new FileWriter("LastLogin.txt", true));
            out.write(information[0] + " " + d + "\n");
            out.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // پیدا کردن زمان اخرین ورود از فایل
    public String LastLogin(String username) {
        String[] d = new String[3];
        String[] loginTime = new String[2];
        loginTime[0] = "null";
        loginTime[1] = "null";
        try {
            File file = new File("C:\\Users\\Global Village\\Edu\\LastLogin.txt");
            Scanner f = new Scanner(file);
            while (f.hasNextLine()) {
                String data = f.nextLine();
                d = data.split(" ");
                if(d[0].equals(username)) {
                    loginTime[0] = d[1];
                    loginTime[1] = d[2];
                }
            }
        } catch(FileNotFoundException w) {
            w.printStackTrace();
        }
        if(loginTime[0].equals("null")) {
            Date date = new Date();
            SimpleDateFormat dd = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
            return dd.format(date);
        } else {
            return loginTime[0] + " " + loginTime[1];
        }
    }

    // تنظیمات فریم جدید
    public void newFrameSetting() {

        newFrame.setJMenuBar(menuBar);
        newPanel.add(exit);
        newPanel.add(AkharinVorud);
        newPanel.add(AkharinVorudLabel);
        newPanel.add(bazgasht);
    }



}

