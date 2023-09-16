package client.graphic.Filter;


import client.controller.filterDarsController;
import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FilterDars {

    JFrame DaneshkadeFrame, VahedFrame, OstadFrame;
    JPanel DaneshkadePanel, VahedPanel, OstadPanel;
    private JLabel DLabel, VLabel, OLabel, warn;
    private JButton riazi, cs, omran, bargh, physics;
    private JButton one, two, three, four, ok;
    private JTextField OstadName;
    private JTable riaziTable, physicsTable, csTable, barghTable, omranTable,
            oneTable, twoTable, threeTable, fourTable, ostadTable;
    String[][] data = new String[3][3];
    String[] title = new String[3];
    String[] title2 = new String[4];
    String[][] oneVahed = new String[3][3];
    String[][] twoVahed = new String[1][3];
    String[][] threeVahed = new String[4][3];
    String[][] fourVahed = new String[2][3];
    String[][] ostad = new String[1][4];

    public void DaneshkadeFilter() {
        // تنظیمات فریم
        DaneshkadeFrame = new JFrame("دانشکده");
        DaneshkadeFrame.setSize(new Dimension(300,300));
        DaneshkadeFrame.setResizable(false);
        DaneshkadeFrame.setLocationRelativeTo(null);
        DaneshkadeFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // تنظیمات پنل
        DaneshkadePanel = new JPanel();
        DaneshkadePanel.setSize(new Dimension(300,300));
        DaneshkadePanel.setLayout(null);

        DLabel = new JLabel("دانشکده مدنظر را انتخاب کنید:");
        DLabel.setBounds(100,20,150,40);

        riazi = new JButton("علوم ریاضی");
        cs = new JButton("علوم کامپیوتر");
        omran = new JButton("عمران");
        bargh = new JButton("برق");
        physics = new JButton("فیزیک");

        riazi.setBounds(80,60,100,30);
        cs.setBounds(80,100,120,30);
        omran.setBounds(80,140,100,30);
        bargh.setBounds(80,180,100,30);
        physics.setBounds(80,220,100,30);

        DaneshkadePanel.add(DLabel);
        DaneshkadePanel.add(riazi);
        DaneshkadePanel.add(physics);
        DaneshkadePanel.add(bargh);
        DaneshkadePanel.add(omran);
        DaneshkadePanel.add(cs);

        DaneshkadeFrame.add(DaneshkadePanel);
        DaneshkadeFrame.setLayout(null);
        DaneshkadeFrame.setVisible(true);

        data[0][0] = "واحد";
        data[0][1] = "استاد";
        data[0][2] = "درس";

        title[0] = "واحد";
        title[1] = "استاد";
        title[2] = "درس";

        riazi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] inf = filterDarsController.filterRiazi("FilterDaneshkadeRiazi", ServerController.AuthToken);

                if(inf != null) {

                    riaziTable = new JTable(inf, title);
                    riaziTable.setBounds(20,30,250,220);

                    DaneshkadePanel.removeAll();
                    DaneshkadePanel.add(riaziTable);
                    DaneshkadeFrame.add(DaneshkadePanel);
                    DaneshkadeFrame.setVisible(true);
                }

            }
        });

        cs.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] inf = filterDarsController.filterCs("FilterDaneshkadeCs", ServerController.AuthToken);

                if(inf != null) {

                    csTable = new JTable(inf,title);
                    csTable.setBounds(20,30,250,220);

                    DaneshkadePanel.removeAll();
                    DaneshkadePanel.add(csTable);
                    DaneshkadeFrame.add(DaneshkadePanel);
                    DaneshkadeFrame.setVisible(true);
                }
            }
        });

        bargh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] inf = filterDarsController.filterBargh("FilterDaneshkadeBargh", ServerController.AuthToken);

                if(inf != null) {

                    barghTable = new JTable(inf,title);
                    barghTable.setBounds(20,30,250,220);

                    DaneshkadePanel.removeAll();
                    DaneshkadePanel.add(barghTable);
                    DaneshkadeFrame.add(DaneshkadePanel);
                    DaneshkadeFrame.setVisible(true);
                }
            }
        });

        omran.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] inf = filterDarsController.filterOmran("FilterDaneshkadeOmran", ServerController.AuthToken);

                if(inf != null) {
                    omranTable = new JTable(inf,title);
                    omranTable.setBounds(20,30,250,220);

                    DaneshkadePanel.removeAll();
                    DaneshkadePanel.add(omranTable);
                    DaneshkadeFrame.add(DaneshkadePanel);
                    DaneshkadeFrame.setVisible(true);
                }
            }
        });

        physics.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                String[][] inf = filterDarsController.filterPhysic("FilterDaneshkadePhysic", ServerController.AuthToken);

                if(inf != null) {

                    physicsTable = new JTable(inf,title);
                    physicsTable.setBounds(20,30,250,220);

                    DaneshkadePanel.removeAll();
                    DaneshkadePanel.add(physicsTable);
                    DaneshkadeFrame.add(DaneshkadePanel);
                    DaneshkadeFrame.setVisible(true);
                }
            }
        });

    }

    public void VahedFilter() {
        // تنظیمات فریم
        VahedFrame = new JFrame("واحد");
        VahedFrame.setSize(new Dimension(300,300));
        VahedFrame.setResizable(false);
        VahedFrame.setLocationRelativeTo(null);
        VahedFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // تنظیمات پنل
        VahedPanel = new JPanel();
        VahedPanel.setSize(new Dimension(300,300));
        VahedPanel.setLayout(null);

        VLabel = new JLabel("واحد مدنظر خود را انتخاب کنید:");
        VLabel.setBounds(80,20,150,40);

        one = new JButton("1 واحدی");
        two = new JButton("2 واحدی");
        three = new JButton("3 واحدی");
        four = new JButton("4 واحدی");

        one.setBounds(80,60,100,30);
        two.setBounds(80,100,100,30);
        three.setBounds(80,140,100,30);
        four.setBounds(80,180,100,30);

        VahedPanel.add(VLabel);
        VahedPanel.add(one);
        VahedPanel.add(two);
        VahedPanel.add(three);
        VahedPanel.add(four);

        VahedFrame.add(VahedPanel);
        VahedFrame.setLayout(null);
        VahedFrame.setVisible(true);

        title[0] = "واحد";
        title[1] = "استاد";
        title[2] = "درس";

        one.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                Request request = new Request(RequestType.FilterVahedOne);
                Response response = ServerController.sendAnyRequest(request, ServerController.AuthToken);

                if(response.getStatus() == ResponseStatus.OK) {
                    oneVahed = (String[][]) response.getData("filterOne");

                    oneTable = new JTable(oneVahed,title);
                    oneTable.setBounds(20,30,250,220);

                    VahedPanel.removeAll();
                    VahedPanel.add(oneTable);
                    VahedFrame.add(VahedPanel);
                    VahedFrame.setVisible(true);
                }
            }
        });

        two.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                Request request = new Request(RequestType.FilterVahedTwo);
                Response response = ServerController.sendAnyRequest(request, ServerController.AuthToken);

                if(response.getStatus() == ResponseStatus.OK) {
                    twoVahed = (String[][]) response.getData("filterTwo");

                    twoTable = new JTable(twoVahed, title);
                    twoTable.setBounds(20,30,250,220);

                    VahedPanel.removeAll();
                    VahedPanel.add(twoTable);
                    VahedFrame.add(VahedPanel);
                    VahedFrame.setVisible(true);
                }

            }
        });

        three.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                Request request = new Request(RequestType.FilterVahedThree);
                Response response = ServerController.sendAnyRequest(request, ServerController.AuthToken);

                if(response.getStatus() == ResponseStatus.OK) {
                    threeVahed = (String[][]) response.getData("filterThree");

                    threeTable = new JTable(threeVahed, title);
                    threeTable.setBounds(20,30,250,220);

                    VahedPanel.removeAll();
                    VahedPanel.add(threeTable);
                    VahedFrame.add(VahedPanel);
                    VahedFrame.setVisible(true);
                }
            }
        });

        four.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // send request
                Request request = new Request(RequestType.FilterVahedFour);
                Response response = ServerController.sendAnyRequest(request, ServerController.AuthToken);

                if(response.getStatus() == ResponseStatus.OK) {
                    fourVahed = (String[][]) response.getData("filterFour");

                    fourTable = new JTable(fourVahed, title);
                    fourTable.setBounds(20,30,250,220);

                    VahedPanel.removeAll();
                    VahedPanel.add(fourTable);
                    VahedFrame.add(VahedPanel);
                    VahedFrame.setVisible(true);
                }

            }
        });

    }

    public void OstadFilter() {

        title2[0] = "دانشکده";
        title2[1] = "واحد";
        title2[2] = "درس";
        title2[3] = "استاد";

        // تنظیمات فریم
        OstadFrame = new JFrame("استاد");
        OstadFrame.setSize(new Dimension(300,300));
        OstadFrame.setResizable(false);
        OstadFrame.setLocationRelativeTo(null);
        OstadFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);

        // تنظیمات پنل
        OstadPanel = new JPanel();
        OstadPanel.setSize(new Dimension(300,300));
        OstadPanel.setLayout(null);

        OLabel = new JLabel("نام استاد مدنظر را وارد کنید:");
        OLabel.setBounds(80,40,150,40);

        ok = new JButton("ok");
        ok.setBounds(110,140, 60,50);

        OstadName = new JTextField();
        OstadName.setBounds(60,90,160,30);

        warn = new JLabel("فارسی و بدون فاصله بنویسید");
        warn.setBounds(80,200,150,40);

        OstadPanel.add(ok);
        OstadPanel.add(warn);
        OstadPanel.add(OLabel);
        OstadPanel.add(OstadName);

        OstadFrame.add(OstadPanel);
        OstadFrame.setLayout(null);
        OstadFrame.setVisible(true);

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // دریافت اسم استاد ورودی
                String name = OstadName.getText();

                Request request = new Request(RequestType.FilterOstad);
                request.addData("OstadName", name);

                Response response = ServerController.sendAnyRequest(request, ServerController.AuthToken);

                if(response.getStatus() == ResponseStatus.OK) {
                    ostad = (String[][]) response.getData("filterOstad");

                    ostadTable = new JTable(ostad,title2);

                    ostadTable.setBounds(20,30,250,220);
                    OstadPanel.removeAll();
                    OstadPanel.add(ostadTable);
                    OstadFrame.add(OstadPanel);
                    OstadFrame.setLayout(null);
                    OstadFrame.setVisible(true);

                }

            }
        });


    }



}


