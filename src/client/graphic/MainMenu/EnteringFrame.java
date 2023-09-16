package client.graphic.MainMenu;

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


public class EnteringFrame extends JFrame {


    JFrame frame = new JFrame("سیستم آموزش");

    JPanel panel = new JPanel();


    private boolean a;
    private boolean b;

    private JLabel usernameLabel, passwordLabel, CodeLabel;
    private JLabel captcha1, captcha2, captcha3, captcha4, captcha5;

    private JTextField UsernameTextField, CodeField;

    private JPasswordField PasswordField;

    private JButton enter, update;

    private int i;

    public EnteringFrame() {

        Integer w = Config.getConfig().getProperty(Integer.class, "ENTERING_FRAME");

        i = 1;

        panel.setSize(new Dimension(w, w));
        panel.setBackground(Color.lightGray);

        // settings
        frame.setSize(new Dimension(w,w));
        frame.setResizable(false);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        // label
        usernameLabel = new JLabel("شناسه کاربر:");
        usernameLabel.setBounds(300, 60, 60, 30);

        passwordLabel = new JLabel("رمز عبور:");
        passwordLabel.setBounds(300, 120, 60, 30);

        CodeLabel = new JLabel("متن بالا را وارد کنید:");
        CodeLabel.setBounds(310, 280, 100, 40);

        // field
        UsernameTextField = new JTextField();
        UsernameTextField.setBounds(190, 60, 100, 30);

        PasswordField = new JPasswordField();
        PasswordField.setBounds(190, 120, 100, 30);

        CodeField = new JTextField();
        CodeField.setBounds(200, 290, 100, 30);


        // button
        enter = new JButton("ورود به سیستم");
        enter.setBounds(180, 340, 160, 30);


        update = new JButton(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\update.jpg"));
        update.setBounds(150,230, 30, 30);

        // captcha
        captcha1 = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\jcaptcha.jpg"));
        captcha1.setBounds(210, 230, 80, 40);
        captcha2 = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\jcaptcha2.jpg"));
        captcha2.setBounds(225, 180, 80, 40);
        captcha3 = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\jcaptcha3.jpg"));
        captcha3.setBounds(225, 180, 80, 40);
        captcha4 = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\jcaptcha4.jpg"));
        captcha4.setBounds(225, 180, 80, 40);
        captcha5 = new JLabel(new ImageIcon("C:\\Users\\Global Village\\Desktop\\image\\jcaptcha5.jpg"));
        captcha5.setBounds(225, 180, 80, 40);


        // add
        panel.add(usernameLabel);
        panel.add(passwordLabel);
        panel.add(UsernameTextField);
        panel.add(PasswordField);
        panel.add(enter);
        panel.add(CodeLabel);
        panel.add(CodeField);
        panel.add(update);
        panel.add(captcha1);



        panel.setLayout(new BorderLayout());


        frame.add(panel);
        //panel.setLayout(null);
        frame.setLayout(null);
        frame.setVisible(true);

        //repaintFrame();

        update.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UPDATE_CAPTCHA();
            }
        });



        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = UsernameTextField.getText();
                String pass = PasswordField.getText();
                String code = CodeField.getText();

                // چک میکنه که کپچا صحیح باشه
                b = checkingCaptcha(code, i);

                Request request = new Request(RequestType.Login);
                request.addData("username", name);
                request.addData("password", pass);

                // send req to server
                Response response = ServerController.sendLoginRequest(request);

                if(response.getStatus() == ResponseStatus.OK && b) {
                    ServerController.AuthToken = (int) response.getData("authToken");
                    String type = (String) response.getData("type");
                    if(type.equals("student")) {
                        frame.setVisible(false);
                        new DaneshjuMainMenu(name);
                    } else if(type.equals("ostad") ||
                            type.equals("moaven") ||
                            type.equals("raees")) {
                        frame.setVisible(false);
                        new OstadMainMenu(name, type);
                    } else if(response.getData("type").equals("admin")) {
                        frame.setVisible(false);
                        new AdminMenu();
                    } else if(response.getData("type").equals("mohseni")) {
                        frame.setVisible(false);
                        new MohseniMenu();
                    }
                } else if(response.getStatus() == ResponseStatus.ERROR) {
                    JOptionPane.showMessageDialog(frame,"ERROR!");
                }

            }
        });

    }


    public void UPDATE_CAPTCHA() {
        if(i > 5) {
            i = i - 5;
        }

        switch (i) {
            case 1:
                panel.remove(captcha1);
                panel.add(captcha2);
                frame.add(panel);
                frame.setLayout(null);
                frame.setVisible(true);
                break;
            case 2:
                panel.remove(captcha2);
                panel.add(captcha3);
                frame.add(panel);
                frame.setLayout(null);
                frame.setVisible(true);
                break;
            case 3:
                panel.remove(captcha3);
                panel.add(captcha4);
                frame.add(panel);
                frame.setLayout(null);
                frame.setVisible(true);
                break;
            case 4:
                panel.remove(captcha4);
                panel.add(captcha5);
                frame.add(panel);
                frame.setLayout(null);
                frame.setVisible(true);
                break;
            case 5:
                panel.remove(captcha5);
                panel.add(captcha1);
                frame.add(panel);
                frame.setLayout(null);
                frame.setVisible(true);
                break;
        }
        i++;

    }

    public void repaintFrame() {
        revalidate();
        repaint();
    }

    public boolean checkingCaptcha(String code, int n) {
        boolean isCodeValid = false;
        if(n == 1) {
            if(code.equals("5618")) {
                isCodeValid = true;
            }
        } else if(n == 2) {
            if(code.equals("3498")) {
                isCodeValid = true;
            }
        } else if(n == 3) {
            if(code.equals("4345")) {
                isCodeValid = true;
            }
        } else if(n == 4) {
            if(code.equals("8448")) {
                isCodeValid = true;
            }
        } else if(n == 5) {
            if(code.equals("1149")) {
                isCodeValid = true;
            }
        }
        return isCodeValid;
    }
}

