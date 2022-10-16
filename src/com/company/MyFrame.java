package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyFrame extends JPanel implements ActionListener {
    public JFrame frame = new JFrame("Windows XP");
    public JPanel panel = new JPanel();
    public JLabel background = new JLabel(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/windowsbackground.jpeg"));
    ImageIcon scaledInternet = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internet.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));

    public JButton internetexp = new JButton(scaledInternet);
    public void setFrame() {
        frame.setLayout(new BorderLayout());
        frame.setSize(1600, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(background);
        frame.setVisible(true);

    }
    public void setPanel() {
        frame.add(panel, BorderLayout.EAST);
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setSize(100, 900);
        panel.add(internetexp);
        panel.setOpaque(false);
        internetexp.addActionListener(this);
        internetexp.setBackground(null);
        internetexp.setBorder(null);
        internetexp.setSize(200, 200);
        internetexp.setVisible(true);
        System.out.println("successful");

    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }
}

