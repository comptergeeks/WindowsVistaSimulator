package com.company;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame {
    public JFrame frame = new JFrame("Windows XP");
    public JPanel panel = new JPanel();
    public JLabel background = new JLabel(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/windowsbackground.jpeg"));
    public JButton internetexp = new JButton(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internet.png"));
    public void setFrame() {
        frame.setVisible(true);
        frame.setSize(1600, 900);

    }
    public void setPanel() {
        frame.add(panel);
        panel.setSize(1600, 900);
        panel.setVisible(true);
        panel.add(background);
        panel.add(internetexp);
        internetexp.setVisible(true);
        internetexp.setBackground(null);
        internetexp.setBorder(null);
        System.out.println("successful");
        panel.repaint();
        //frame.add(background);

    }

}

