package client.graphic.Edit;

import client.controller.addLessonController;
import client.network.ServerController;
import shared.request.Request;
import shared.request.RequestType;
import shared.response.Response;
import shared.response.ResponseStatus;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EditLesson {

    public static JFrame newFrame, addingFrame;
    public static JPanel newPanel, addingPanel;

    public static JButton editLesson, addLesson, deletLesson, ok;

    public static JLabel vahed, ostad, dars, daneshkade, code,
            maghta, zarfiat, pishniaz, hamniaz, dastyar, zaman, emtehan;

    public static JTextField vahedText, ostadText, darsText, daneshkadeText, codeText,
            maghtaText, zarfiatText, pishniazText, hamniazText, dastyarText, zamanText, emtehanText;

    public static void mainframe(int token, String username) {

        newFrame = new JFrame("ویرایش");
        newPanel = new JPanel();

        newFrame.setSize(new Dimension(600,600));
        newFrame.setResizable(false);
        newFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        newFrame.setLocationRelativeTo(null);
        newFrame.setLayout(null);
        newPanel.setSize(new Dimension(600,600));
        newPanel.setLayout(null);

        editLesson = new JButton("ویرایش درس");
        deletLesson = new JButton("حذف درس");
        addLesson = new JButton("افزودن درس");

        editLesson.setBounds(100,100,100,70);
        deletLesson.setBounds(100,200,100,70);
        addLesson.setBounds(100,300,100,70);

        ok = new JButton("تایید");
        ok.setBounds(300,480,70,50);

        newPanel.add(editLesson);
        newPanel.add(deletLesson);
        newPanel.add(addLesson);

        newFrame.add(newPanel);
        newFrame.setVisible(true);

        addLesson.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                newFrame.setVisible(false);

                addingFrame = new JFrame("افزودن درس");

                addingFrame.setSize(new Dimension(600,600));
                addingFrame.setResizable(false);
                addingFrame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                addingFrame.setLocationRelativeTo(null);
                addingFrame.setLayout(null);

                addingPanel = new JPanel();
                addingPanel.setSize(new Dimension(600,600));
                addingPanel.setLayout(null);

                vahed = new JLabel("واحد:");
                dars = new JLabel("درس:");
                ostad = new JLabel("استاد:");
                daneshkade = new JLabel("دانشکده:");
                code = new JLabel("کد:");
                pishniaz = new JLabel("پیشنیاز:");
                hamniaz = new JLabel("همنیاز:");
                dastyar = new JLabel("دستیار:");
                zaman = new JLabel("زمان:");
                emtehan = new JLabel("امتحان:");
                maghta = new JLabel("مقطع:");
                zarfiat = new JLabel("ظرفیت:");

                vahed.setBounds(240,50,100,50);
                dars.setBounds(240,120,100,50);
                ostad.setBounds(240,190,100,50);
                daneshkade.setBounds(240,260,100,50);
                maghta.setBounds(240,330,100,50);
                code.setBounds(240,400,100,50);
                dastyar.setBounds(510,50,100,50);
                pishniaz.setBounds(510,120,100,50);
                hamniaz.setBounds(510,190,100,50);
                zaman.setBounds(510,260,100,50);
                emtehan.setBounds(510,330,100,50);
                zarfiat.setBounds(510,400,100,50);

                vahedText = new JTextField();
                dastyarText = new JTextField();
                codeText = new JTextField();
                daneshkadeText = new JTextField();
                maghtaText = new JTextField();
                pishniazText = new JTextField();
                hamniazText = new JTextField();
                zamanText = new JTextField();
                zarfiatText = new JTextField();
                darsText = new JTextField();
                ostadText = new JTextField();
                emtehanText = new JTextField();

                vahedText.setBounds(140,50,100,50);
                darsText.setBounds(140,120,100,50);
                ostadText.setBounds(140,190,100,50);
                daneshkadeText.setBounds(140,260,100,50);
                maghtaText.setBounds(140,330,100,50);
                codeText.setBounds(140,400,100,50);
                dastyarText.setBounds(400,50,100,50);
                pishniazText.setBounds(400,120,100,50);
                hamniazText.setBounds(400,190,100,50);
                zamanText.setBounds(400,260,100,50);
                emtehanText.setBounds(400,330,100,50);
                zarfiatText.setBounds(400,400,100,50);

                addingPanel.add(ok);

                addingPanel.add(vahed);
                addingPanel.add(dars);
                addingPanel.add(daneshkade);
                addingPanel.add(code);
                addingPanel.add(ostad);
                addingPanel.add(maghta);
                addingPanel.add(pishniaz);
                addingPanel.add(hamniaz);
                addingPanel.add(zaman);
                addingPanel.add(emtehan);
                addingPanel.add(zarfiat);
                addingPanel.add(dastyar);
                addingPanel.add(vahedText);
                addingPanel.add(darsText);
                addingPanel.add(daneshkadeText);
                addingPanel.add(codeText);
                addingPanel.add(ostadText);
                addingPanel.add(maghtaText);
                addingPanel.add(pishniazText);
                addingPanel.add(hamniazText);
                addingPanel.add(zamanText);
                addingPanel.add(emtehanText);
                addingPanel.add(zarfiatText);
                addingPanel.add(dastyarText);

                addingFrame.add(addingPanel);
                addingFrame.setVisible(true);
            }
        });

        ok.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                boolean result = addLessonController.addLesson("addLesson", token, username, vahedText.getText(), darsText.getText(),
                        daneshkadeText.getText(), ostadText.getText(), maghtaText.getText(), dastyarText.getText(), codeText.getText(),
                        pishniazText.getText(), hamniazText.getText(), zamanText.getText(), emtehanText.getText(), zarfiatText.getText());

                if(result) {
                    JOptionPane.showMessageDialog(addingFrame,"Done!");
                }

            }
        });

    }



}
