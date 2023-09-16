package client.graphic.Edit;


import javax.swing.*;
import java.awt.*;

public class Virayesh {
    JFrame virayeshFrame;
    JPanel virayeshPanel;

    private JButton virayesh, ezafe, hazf;

    public void mainframe() {
        virayeshFrame = new JFrame("ویرایش");
        virayeshFrame.setSize(new Dimension(400,400));
        virayeshFrame.setResizable(false);
        virayeshFrame.setLocationRelativeTo(null);
        virayeshFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        virayeshPanel = new JPanel();
        virayeshPanel.setSize(400,400);
        virayeshPanel.setLayout(null);

        virayesh = new JButton("ویرایش");
        virayesh.setBounds(140,50,100,40);
        ezafe = new JButton("افزودن کاربر");
        ezafe.setBounds(130,130,120,40);
        hazf = new JButton("حذف کاربر");
        hazf.setBounds(130,210,140,40);

        virayeshPanel.add(virayesh);
        virayeshPanel.add(ezafe);
        virayeshPanel.add(hazf);

        virayeshFrame.add(virayeshPanel);
        virayeshFrame.setLayout(null);
        virayeshFrame.setVisible(true);

    }

}

