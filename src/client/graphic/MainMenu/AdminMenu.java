package client.graphic.MainMenu;

import shared.util.Config;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AdminMenu {

    private JFrame mainFrame;
    private JPanel mainPanel;

    private JButton message, exit;

    public AdminMenu() {

        mainFrame = new JFrame("ادمین");
        mainPanel = new JPanel();

        Integer w = Config.getConfig().getProperty(Integer.class, "ADMIN_MAIN_MENU");
        mainFrame.setSize(new Dimension(w,w));
        mainFrame.setResizable(false);
        mainFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        mainFrame.setLocationRelativeTo(null);
        mainFrame.setLayout(null);
        mainPanel.setSize(new Dimension(w,w));
        mainPanel.setLayout(null);

        message = new JButton("پیغام ها");
        message.setBounds(150,130,100,100);

        exit = new JButton("خروج");
        exit.setBounds(10,10,60,60);

        mainPanel.add(message);
        mainPanel.add(exit);

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
