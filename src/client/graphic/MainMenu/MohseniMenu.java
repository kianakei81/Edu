package client.graphic.MainMenu;

import shared.util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MohseniMenu {

    private JFrame mainFrame;
    private JPanel mainPanel;
    private JButton search, message, exit;

    public MohseniMenu() {

        mainFrame = new JFrame("آقای محسنی");
        mainPanel = new JPanel();

        Integer w = Config.getConfig().getProperty(Integer.class, "MOHSENI_MAIN_MENU");
        mainFrame.setSize(new Dimension(w,w));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainPanel.setSize(new Dimension(w,w));
        mainPanel.setLayout(null);

        message = new JButton("ارسال پیام");
        message.setBounds(150,100,100,100);

        search = new JButton("جستجوی دانشجویان");
        search.setBounds(130,210,150,70);

        exit = new JButton("خروج");
        exit.setBounds(10,10,60,60);

        mainPanel.add(message);
        mainPanel.add(exit);
        mainPanel.add(search);

        mainFrame.add(mainPanel);
        mainFrame.setVisible(true);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainFrame.setVisible(false);
                EnteringFrame frame = new EnteringFrame();
            }
        });

    }

}
