package client.graphic;

import client.controller.entekhabVahedFilterController;
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

public class EntekhabVahed {

    public static String[] title;
    public static String[][] data;

    public static JFrame mainFrame, newFrame;

    public static JPanel mainPanel, newPanel;

    public static JLabel daneshkadeFilterLabel, lessonFilter;

    public static JButton riaziFilter, physicsFilter, omranFilter, csFilter, barghFilter, maarefFilter, pishnahad,
            zamanEmtehanRiazi, TartibAlefbaRiazi, karshenasiRiazi, arshadRiazi,
            zamanEmtehanMaaref, TartibAlefbaMaaref, karshenasiMaaref, arshadMaaref,
            zamanEmtehanPhysics, TartibAlefbaPhysics, karshenasiPhysics, arshadPhysics,
            zamanEmtehanCs, TartibAlefbaCs, karshenasiCs, arshadCs,
            zamanEmtehanBargh, TartibAlefbaBargh, karshenasiBargh, arshadBargh,
            zamanEmtehanOmran, TartibAlefbaOmran, karshenasiOmran, arshadOmran;

    public static JTable table;

    public static void MainMenu(String username, int token) {

        Integer w = Config.getConfig().getProperty(Integer.class, "ENTEKHAB_VAHED_FRAME");

        newFrame = new JFrame();
        newPanel = new JPanel();
        newFrame.setSize(new Dimension(w,w));
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);
        newFrame.setLayout(null);
        newPanel.setSize(new Dimension(w,w));
        newPanel.setLayout(null);


        mainFrame = new JFrame("انتخاب واحد");
        mainPanel = new JPanel();

        mainFrame.setSize(new Dimension(500,500));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainPanel.setSize(new Dimension(500,500));
        mainPanel.setLayout(null);

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

        daneshkadeFilterLabel = new JLabel("لیست دروس دانشکده ها:");
        daneshkadeFilterLabel.setBounds(320,70,100,50);

        riaziFilter = new JButton("ریاضی");
        physicsFilter = new JButton("فیزیک");
        omranFilter = new JButton("عمران");
        csFilter = new JButton("علوم کامپیوتر");
        barghFilter = new JButton("برق");
        maarefFilter = new JButton("معارف");
        pishnahad = new JButton("دروس پیشنهادی");

        riaziFilter.setBounds(190,70,70,50);
        maarefFilter.setBounds(80,70,70,50);
        physicsFilter.setBounds(190,130,70,50);
        omranFilter.setBounds(190,190,70,50);
        csFilter.setBounds(190,250,100,50);
        barghFilter.setBounds(190,310,70,50);

        pishnahad.setBounds(340,370,100,50);
        pishnahad.setBackground(Color.ORANGE);

        mainPanel.add(maarefFilter);
        mainPanel.add(riaziFilter);
        mainPanel.add(physicsFilter);
        mainPanel.add(omranFilter);
        mainPanel.add(barghFilter);
        mainPanel.add(csFilter);
        mainPanel.add(daneshkadeFilterLabel);
        mainPanel.add(pishnahad);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        // برای صفحه ای که دروس فیلترشده نمایش داده شدن
        lessonFilter = new JLabel("فیلتر بر اساس:");
        lessonFilter.setBounds(500,50,70,50);


        TartibAlefbaOmran = new JButton("ترتیب الفبایی دروس");
        TartibAlefbaOmran.setBounds(300,50,180,50);
        zamanEmtehanOmran = new JButton("زمان امتحان");
        zamanEmtehanOmran.setBounds(120,50,150,50);
        karshenasiOmran = new JButton("دروس کارشناسی");
        karshenasiOmran.setBounds(300,120,160,50);
        arshadOmran = new JButton("دروس ارشد");
        arshadOmran.setBounds(120,120,160,50);

        TartibAlefbaBargh = new JButton("ترتیب الفبایی دروس");
        TartibAlefbaBargh.setBounds(300,50,180,50);
        zamanEmtehanBargh = new JButton("زمان امتحان");
        zamanEmtehanBargh.setBounds(120,50,150,50);
        karshenasiBargh = new JButton("دروس کارشناسی");
        karshenasiBargh.setBounds(300,120,160,50);
        arshadBargh = new JButton("دروس ارشد");
        arshadBargh.setBounds(120,120,160,50);

        TartibAlefbaMaaref = new JButton("ترتیب الفبایی دروس");
        TartibAlefbaMaaref.setBounds(300,50,180,50);
        zamanEmtehanMaaref = new JButton("زمان امتحان");
        zamanEmtehanMaaref.setBounds(120,50,150,50);
        karshenasiMaaref = new JButton("دروس کارشناسی");
        karshenasiMaaref.setBounds(300,120,160,50);
        arshadMaaref = new JButton("دروس ارشد");
        arshadMaaref.setBounds(120,120,160,50);

        TartibAlefbaCs = new JButton("ترتیب الفبایی دروس");
        TartibAlefbaCs.setBounds(300,50,180,50);
        zamanEmtehanCs = new JButton("زمان امتحان");
        zamanEmtehanCs.setBounds(120,50,150,50);
        karshenasiCs = new JButton("دروس کارشناسی");
        karshenasiCs.setBounds(300,120,160,50);
        arshadCs = new JButton("دروس ارشد");
        arshadCs.setBounds(120,120,160,50);

        TartibAlefbaRiazi = new JButton("ترتیب الفبایی دروس");
        TartibAlefbaRiazi.setBounds(300,50,180,50);
        zamanEmtehanRiazi = new JButton("زمان امتحان");
        zamanEmtehanRiazi.setBounds(120,50,150,50);
        karshenasiRiazi = new JButton("دروس کارشناسی");
        karshenasiRiazi.setBounds(300,120,160,50);
        arshadRiazi = new JButton("دروس ارشد");
        arshadRiazi.setBounds(120,120,160,50);

        TartibAlefbaPhysics = new JButton("ترتیب الفبایی دروس");
        TartibAlefbaPhysics.setBounds(300,50,180,50);
        zamanEmtehanPhysics = new JButton("زمان امتحان");
        zamanEmtehanPhysics.setBounds(120,50,150,50);
        karshenasiPhysics = new JButton("دروس کارشناسی");
        karshenasiPhysics.setBounds(300,120,160,50);
        arshadPhysics = new JButton("دروس ارشد");
        arshadPhysics.setBounds(120,120,160,50);


        maarefFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] inf = entekhabVahedFilterController.filterMaaref("MaarefFilter", token);

                if(inf != null) {
                    table = new JTable(inf, title);
                    table.setBounds(30,220,570,110);

                    newPanel.removeAll();
                    newPanel.add(lessonFilter);
                    newPanel.add(TartibAlefbaMaaref);
                    newPanel.add(zamanEmtehanMaaref);
                    newPanel.add(karshenasiMaaref);
                    newPanel.add(arshadMaaref);
                    newPanel.add(table);

                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                    TartibAlefbaMaaref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    zamanEmtehanMaaref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    karshenasiMaaref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    arshadMaaref.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                }
            }
        });

        riaziFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] inf = entekhabVahedFilterController.filterRiazi("RiaziFilter", token);

                if(inf != null) {

                    table = new JTable(inf, title);
                    table.setBounds(30,220,570,110);

                    newPanel.removeAll();
                    newPanel.add(lessonFilter);
                    newPanel.add(TartibAlefbaRiazi);
                    newPanel.add(zamanEmtehanRiazi);
                    newPanel.add(karshenasiRiazi);
                    newPanel.add(arshadRiazi);
                    newPanel.add(table);

                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                    // دکمه فیلتر براساس حروف الفبا
                    TartibAlefbaRiazi.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس زمان امتحان
                    zamanEmtehanRiazi.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    karshenasiRiazi.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    arshadRiazi.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                }
            }
        });

        physicsFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {


                String[][] inf = entekhabVahedFilterController.filterPhysic("PhysicsFilter", token);

                if(inf != null) {

                    table = new JTable(inf, title);
                    table.setBounds(30,220,550,110);
                    newPanel.removeAll();
                    newPanel.add(lessonFilter);
                    newPanel.add(TartibAlefbaPhysics);
                    newPanel.add(zamanEmtehanPhysics);
                    newPanel.add(karshenasiPhysics);
                    newPanel.add(arshadPhysics);
                    newPanel.add(table);

                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                    // دکمه فیلتر براساس حروف الفبا
                    TartibAlefbaPhysics.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس زمان امتحان
                    zamanEmtehanPhysics.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    karshenasiPhysics.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    arshadPhysics.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                }
            }
        });

        barghFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] inf = entekhabVahedFilterController.filterBargh("BarghFilter", token);

                if(inf != null) {

                    table = new JTable(inf, title);
                    table.setBounds(30,220,550,110);
                    newPanel.removeAll();
                    newPanel.add(lessonFilter);
                    newPanel.add(TartibAlefbaBargh);
                    newPanel.add(zamanEmtehanBargh);
                    newPanel.add(karshenasiBargh);
                    newPanel.add(arshadBargh);
                    newPanel.add(table);

                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                    // دکمه فیلتر براساس حروف الفبا
                    TartibAlefbaBargh.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس زمان امتحان
                    zamanEmtehanBargh.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    karshenasiBargh.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    arshadBargh.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                }
            }
        });

        csFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] inf = entekhabVahedFilterController.filterCs("CsFilter", token);

                if(inf != null) {

                    table = new JTable(inf, title);
                    table.setBounds(30,220,550,110);
                    newPanel.removeAll();
                    newPanel.add(lessonFilter);
                    newPanel.add(TartibAlefbaCs);
                    newPanel.add(zamanEmtehanCs);
                    newPanel.add(karshenasiCs);
                    newPanel.add(arshadCs);
                    newPanel.add(table);

                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                    // دکمه فیلتر براساس حروف الفبا
                    TartibAlefbaCs.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس زمان امتحان
                    zamanEmtehanCs.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    karshenasiCs.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    arshadCs.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                }
            }
        });

        omranFilter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String[][] inf = entekhabVahedFilterController.filterOmran("OmranFilter", token);

                if(inf != null) {

                    table = new JTable(inf, title);
                    table.setBounds(30,220,550,110);
                    newPanel.removeAll();
                    newPanel.add(lessonFilter);
                    newPanel.add(TartibAlefbaOmran);
                    newPanel.add(zamanEmtehanOmran);
                    newPanel.add(karshenasiOmran);
                    newPanel.add(arshadOmran);
                    newPanel.add(table);

                    newFrame.add(newPanel);
                    newFrame.setVisible(true);

                    // دکمه فیلتر براساس حروف الفبا
                    TartibAlefbaOmran.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس زمان امتحان
                    zamanEmtehanOmran.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    karshenasiOmran.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                    // دکمه فیلتر بر اساس مقطع ارشد
                    arshadOmran.addActionListener(new ActionListener() {
                        @Override
                        public void actionPerformed(ActionEvent e) {

                        }
                    });

                }
            }
        });

        pishnahad.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Request request = new Request(RequestType.pishnahad);
                Response response = ServerController.sendAnyRequest(request, token);
                if(response.getStatus() == ResponseStatus.OK) {

                }
            }
        });


    }



}
