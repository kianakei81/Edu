package client.graphic.MainMenu;




import client.controller.lessonListController;
import client.controller.profListController;
import client.controller.profileController;
import client.graphic.Edit.Changing;
import client.graphic.Edit.EditLesson;
import client.graphic.Edit.Virayesh;
import client.graphic.Filter.FilterDars;
import client.graphic.List.ListDars;
import client.graphic.List.ListOstad;
import client.graphic.ProfileInfo;
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


public class OstadMainMenu extends JFrame {

    JFrame newFrame = new JFrame();
    JPanel newPanel = new JPanel();
    private JTable table, ostadTabel, StudentProfileTable;
    private JRadioButton rb1, rb2, rb3, changingEmail, changingPhone;

    String[] information;

    private Date date;

    JFrame fr = new JFrame("سامانه آموزش");
    JPanel pane = new JPanel();

    private JMenuBar menuBar;
    private JMenu Tarmim, Amuzeshi, Karname, Profile, Sabt, paygham, cw;
    private JMenuItem Dars, Ostad, profileKarbar, KarnameDars, peygham, cwItem;

    private JButton exit, bazgasht, click, ok, virayesh, edit;

    private JLabel email, email_address, photo, name, nameLabel,
            ZamanJari, ZamanJariLabel, AkharinVorud, AkharinVorudLabel, fil, AX;


    public OstadMainMenu(String username, String type) {

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


        // pane settings
        pane.setSize(new Dimension(500, 500));
        pane.setBackground(Color.gray);

        // frame settings
        fr.setSize(new Dimension(500, 500));
        fr.setResizable(false);
        fr.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        fr.setLocationRelativeTo(null);

        // menuBar settings
        menuBar = new JMenuBar();
        Tarmim = new JMenu("امور ثبت نام و ترمیم");
        Dars = new JMenuItem("لیست دروس");
        Ostad = new JMenuItem("لیست اساتید");
        Tarmim.add(Dars);
        Tarmim.add(Ostad);
        KarnameDars = new JMenuItem("کارنامه دروس و دانشجوها");
        Karname = new JMenu("کارنامه دروس و دانشجوها");
        Profile = new JMenu("پروفایل کاربر");
        profileKarbar = new JMenuItem("پروفایل کاربر");
        Karname.add(KarnameDars);
        Profile.add(profileKarbar);
        paygham = new JMenu("پیغام ها");
        peygham = new JMenuItem("صفحه پیغام ها");
        cw = new JMenu("درس افزار");
        cwItem = new JMenuItem("درس افزار");
        cw.add(cwItem);
        paygham.add(peygham);
        menuBar.add(cw);
        menuBar.add(paygham);
        menuBar.add(Tarmim);
        menuBar.add(Karname);
        menuBar.add(Profile);


        if(type.equals("moaven")) {
            Sabt = new JMenu("ثبت کاربر جدید");
            menuBar.add(Sabt);
        }

        // name
        nameLabel = new JLabel("نام و نام خانوادگی:");
        nameLabel.setBounds(380,340,80,30);
        name = new JLabel(information[3]+" "+information[4]);
        name.setBounds(260,340, 120,30);

        // email
        email = new JLabel("آدرس ایمیل:");
        email.setBounds(400, 300, 50,30);
        email_address = new JLabel(information[7]);
        email_address.setBounds(230,300, 200, 30);

        // photo
        if(username.equals("ostadtwo") || username.equals("ostadsix")) {
            photo = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\female.jpg"));
            photo.setBounds(320,110,150,180);
            pane.add(photo);
        } else {
            photo = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\male.jpg"));
            photo.setBounds(320,110,150,190);
            pane.add(photo);
        }

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
        fil.setBounds(230,60,70,30);
        ostadTabel = new JTable();
        StudentProfileTable = new JTable();
        changingEmail = new JRadioButton();
        changingPhone = new JRadioButton();
        edit = new JButton("ویرایش");
        click = new JButton("click");
        ok = new JButton("فیلتر");
        virayesh = new JButton("ویرایش");



        AkharinVorudLabel = new JLabel("آخرین ورود:");
        AkharinVorudLabel.setBounds(360,20,80,30);

        String LASTLOGIN = LastLogin(username);
        AkharinVorud = new JLabel(LASTLOGIN);
        AkharinVorud.setBounds(220, 20, 140, 30);

        SaveLogin();


        // add
        pane.add(exit);
        pane.add(email);
        pane.add(email_address);
        pane.add(name);
        pane.add(nameLabel);
        pane.add(AkharinVorudLabel);
        pane.add(AkharinVorud);


        pane.setLayout(null);
        fr.add(pane);
        fr.setJMenuBar(menuBar);
        fr.setLayout(null);
        fr.setVisible(true);


        cwItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        // دکمه خروج از پنل کاربری
        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fr.setVisible(false);
                EnteringFrame frame = new EnteringFrame();
            }
        });

        // نمایش لیست درس
        Dars.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] data = lessonListController.lessonList("LessonList", ServerController.AuthToken);

                if(data != null) {
                    newPanel.removeAll();
                    newFrameSetting();
                    ListDars ld = new ListDars();
                    rb1 = ld.filter1();
                    rb2 = ld.filter2();
                    rb3 = ld.filter3();
                    table = ld.ListDars(data);
                    ok.setBounds(140,150,70,40);
                    if(information[2].equals("moaven")) {
                        virayesh.setBounds(340, 150,70,40);
                        newPanel.add(virayesh);
                    }
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

        // ویرایش درس توسط معاون اموزشی
        virayesh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EditLesson.mainframe(ServerController.AuthToken, username);
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

        // دکمه بازگشت به صفحه اصلی کاربر
        bazgasht.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newFrame.setVisible(false);
                new OstadMainMenu(username, type);
            }
        });

        // نمایش لیست اساتید
        Ostad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] data = profListController.profList("ListOstad", ServerController.AuthToken);

                if(data != null) {
                    newPanel.removeAll();
                    newFrameSetting();
                    ListOstad lo = new ListOstad();
                    ostadTabel = lo.ListOstad(data);
                    newPanel.add(ostadTabel);
                    if(information[2].equals("raees")) {
                        edit.setBounds(340,110,70,50);
                        newPanel.add(edit);
                    }
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);
                } else {
                    JOptionPane.showMessageDialog(newFrame,"ERROR!");
                }


            }
        });

        // ویرایش توسط رییس دانشکده
        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Virayesh v = new Virayesh();
                v.mainframe();
            }
        });

        // پروفایل کاربر
        profileKarbar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                newPanel.removeAll();
                newFrameSetting();
                ProfileInfo PI = new ProfileInfo();

                String[] data = profileController.profile("Profile", ServerController.AuthToken, username);

                if(data != null) {

                    StudentProfileTable = PI.teacherProfile(data);
                    changingEmail = PI.CHANGE_EMAIL();
                    changingPhone = PI.CHANGE_PHONE();
                    click.setBounds(180,130,70,40);
                    if(username.equals("ostadtwo") || username.equals("ostadsix")) {
                        AX = new JLabel(new ImageIcon("C:\\Users\\Global Village\\IdeaProjects\\FAZE_2\\src\\client\\resources\\Images\\female.jpg"));
                        AX.setBounds(320,60,120,150);
                        newPanel.add(AX);
                    } else {
                        AX = new JLabel(new ImageIcon("C:\\Users\\Global Village\\IdeaProjects\\FAZE_2\\src\\client\\resources\\Images\\male.jpg"));
                        AX.setBounds(320,60,120,150);
                        newPanel.add(AX);
                    }
                    newPanel.add(click);
                    newPanel.add(changingPhone);
                    newPanel.add(changingEmail);
                    newPanel.add(StudentProfileTable);
                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                }
            }
        });


        // دکمه تایید ویرایش ایمیل و موبایل
        click.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(changingEmail.isSelected() && !changingPhone.isSelected()) {
                    Changing a = new Changing();
                    a.ChangingEmail(username);
                } else if(changingPhone.isSelected() && !changingEmail.isSelected()) {
                    Changing b = new Changing();
                    b.ChangingNumber(username);
                }
            }
        });


        edit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

    }

    // ثبت ساعات ورود به سامانه
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

    // پیدا کردن آخرین ساعت ورود
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

