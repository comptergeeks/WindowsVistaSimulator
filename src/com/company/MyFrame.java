package com.company;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;

public class MyFrame extends JPanel implements ActionListener {
    public JFrame frame = new JFrame("Windows XP");
    public JPanel panel = new JPanel();
    public JLabel background = new JLabel(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/windowsbackground.jpeg"));
    ImageIcon scaledInternet = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internet.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    ImageIcon scaledFileExp = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/fileexplorer.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    public JButton internetExp = new JButton(scaledInternet);
    public JButton fileExp = new JButton(scaledFileExp);
    ArrayList<JInternalFrame> listOfTabs = new ArrayList<JInternalFrame>();

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
        panel.setSize(75, 900);
        panel.add(internetExp);
        panel.add(fileExp);
        panel.setOpaque(false);
        internetExp.addActionListener(this);
        internetExp.setBackground(null);
        internetExp.setBorder(null);
        fileExp.addActionListener(this);
        fileExp.setBackground(null);
        fileExp.setBorder(null);
        JDesktopPane desktopPane = new JDesktopPane();
        //button array forloop?
    }
    public void createNewWindow(String name) {
        JInternalFrame jInternalFrame=new JInternalFrame();
        jInternalFrame.setLocation(450, 300);
        jInternalFrame.setSize(500, 300);
        jInternalFrame.setTitle(name);
        jInternalFrame.setVisible(true);
        jInternalFrame.setClosable(true);
        jInternalFrame.setResizable(true);
        listOfTabs.add(jInternalFrame);
        for (int i = 0; i < listOfTabs.size(); i++) {
            frame.add(jInternalFrame);
        }
        frame.repaint();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == internetExp) {
            String name = "Internet Explorer";
            createNewWindow(name);
            //System.out.println(Arrays.toString(listOfTabs.toArray()));
            //make if pressed, and then reorder array based on that
        }
    }
}

