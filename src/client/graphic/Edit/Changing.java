package client.graphic.Edit;



import client.controller.changingController;
import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.Scanner;

public class Changing {


    JFrame email_frame, number_frame;

    JPanel emailPanel, numberPanel;

    JTextField oldEmail, newEmail, oldNumber, newNumber;

    JLabel OLD_EMAIL, NEW_EMAIL, OLD_NUMBER, NEW_NUMBER;

    JButton CHANGE_EMAIL, CHANGE_NUMBER;


    public void ChangingEmail(String username) {
        // تنظیمات فریم
        email_frame = new JFrame("تغییر ایمیل");
        email_frame.setSize(new Dimension(300,300));
        email_frame.setResizable(false);
        email_frame.setLocationRelativeTo(null);
        email_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // تنظیمات پنل
        emailPanel = new JPanel();
        emailPanel.setSize(new Dimension(300,300));
        emailPanel.setLayout(null);

        OLD_EMAIL = new JLabel("ایمیل قبلی:");
        OLD_EMAIL.setBounds(200,40,100,30);
        NEW_EMAIL = new JLabel("ایمیل جدید:");
        NEW_EMAIL.setBounds(200,90,100,30);

        oldEmail = new JTextField();
        oldEmail.setBounds(60,40,120,30);
        newEmail = new JTextField();
        newEmail.setBounds(60,90,120,30);

        CHANGE_EMAIL = new JButton("تغییر ایمیل");
        CHANGE_EMAIL.setBounds(100,160,80,40);

        emailPanel.add(CHANGE_EMAIL);
        emailPanel.add(oldEmail);
        emailPanel.add(newEmail);
        emailPanel.add(NEW_EMAIL);
        emailPanel.add(OLD_EMAIL);
        email_frame.add(emailPanel);
        email_frame.setLayout(null);
        email_frame.setVisible(true);

        CHANGE_EMAIL.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // خواندن ایمیل قدیم و جدید از لیبل
                String old = oldEmail.getText();
                String NEW = newEmail.getText();

                boolean res = changingController.changing("ChangingEmail", ServerController.AuthToken, username, old, NEW);

                if(res) {
                    JOptionPane.showMessageDialog(email_frame,"it has changed successfully");
                    email_frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(email_frame, "something is wrong!");
                    email_frame.setVisible(false);
                }


            }
        });
    }

    public void ChangingNumber(String username) {
        // تنظیمات فریم
        number_frame = new JFrame("تغییر شماره موبایل");
        number_frame.setSize(new Dimension(300,300));
        number_frame.setResizable(false);
        number_frame.setLocationRelativeTo(null);
        number_frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // تنظیمات پنل
        numberPanel = new JPanel();
        numberPanel.setSize(new Dimension(300,300));
        numberPanel.setLayout(null);

        OLD_NUMBER = new JLabel("شماره قبلی:");
        OLD_NUMBER.setBounds(190,40,100,30);
        NEW_NUMBER = new JLabel("شماره جدید:");
        NEW_NUMBER.setBounds(190,90,100,30);

        oldNumber = new JTextField();
        oldNumber.setBounds(60,40,120,30);
        newNumber = new JTextField();
        newNumber.setBounds(60,90,120,30);

        CHANGE_NUMBER = new JButton("تغییر شماره");
        CHANGE_NUMBER.setBounds(100,160,80,40);

        numberPanel.add(CHANGE_NUMBER);
        numberPanel.add(oldNumber);
        numberPanel.add(newNumber);
        numberPanel.add(NEW_NUMBER);
        numberPanel.add(OLD_NUMBER);
        number_frame.add(numberPanel);
        number_frame.setLayout(null);
        number_frame.setVisible(true);

        CHANGE_NUMBER.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // خواندن شماره تلفن قدیم و جدید از لیبل
                String old = oldNumber.getText();
                String NEW = newNumber.getText();

                boolean res = changingController.changing("ChangingNumber", ServerController.AuthToken, username, old, NEW);

                if(res) {
                    JOptionPane.showMessageDialog(number_frame,"it has changed successfully");
                    number_frame.setVisible(false);
                } else {
                    JOptionPane.showMessageDialog(number_frame, "something is wrong!");
                    number_frame.setVisible(false);
                }


            }
        });
    }


}

