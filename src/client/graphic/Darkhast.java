package client.graphic;

import javax.swing.*;
import java.awt.*;

public class Darkhast {

    JFrame DFrame;
    JPanel DPanel;
    private JButton TosieName, Enseraf, Mainor, Eshteghal;

    public void MainFrame() {
        DFrame = new JFrame("درخواست ها");
        DFrame.setSize(new Dimension(400,400));
        DFrame.setResizable(false);
        DFrame.setLocationRelativeTo(null);
        DFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        DPanel = new JPanel();
        DPanel.setSize(400,400);
        DPanel.setLayout(null);

        TosieName = new JButton("درخواست توصیه نامه");
        TosieName.setBounds(110,30,180,40);
        Enseraf = new JButton("درخواست گواهی اشتغال به تحصیل");
        Enseraf.setBounds(100,100,200,40);
        Mainor = new JButton("ماینور");
        Mainor.setBounds(140,170,100,40);
        Eshteghal = new JButton("انصراف از تحصیل");
        Eshteghal.setBounds(110,240,150,40);

        DPanel.add(TosieName);
        DPanel.add(Enseraf);
        DPanel.add(Mainor);
        DPanel.add(Eshteghal);

        DFrame.add(DPanel);
        DFrame.setLayout(null);
        DFrame.setVisible(true);


    }

}

