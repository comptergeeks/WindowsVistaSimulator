package com.company;
import org.w3c.dom.css.RGBColor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Random;

public class MyFrame extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    public JFrame frame = new JFrame("Windows XP");
    public JPanel panel = new JPanel();
    private int x, y;
    public JLabel background = new JLabel(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/windowsbackground.jpeg"));
    ImageIcon scaledInternet = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internet.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    ImageIcon scaledFileExp = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/fileexplorer.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    public JButton internetExp = new JButton(scaledInternet);
    public JButton fileExp = new JButton(scaledFileExp);
    ArrayList<JPanel> arrPan = new ArrayList<>();

    public void setFrame() {
        frame.setLayout(new BorderLayout());
        frame.add(background);
        frame.setSize(1600, 900);
        frame.setResizable(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
        //button array forloop?
    }

    public void createNewWindow(String name) {
        Random rand = new Random();
        JPanel panel2 = new JPanel();
        panel2.setName(name);
        panel2.setSize(500, 500);
        panel2.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        panel2.setLocation(rand.nextInt(800), rand.nextInt(400));
        panel2.addMouseListener(this);
        panel2.addMouseMotionListener(this);
        arrPan.add(panel2);
        drawerFromArray();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == internetExp) {
            String name = "internet explorer " + arrPan.size();
            createNewWindow(name);
            //make if pressed, and then reorder array based on that
        }
    }
    public void drawerFromArray() {
            for (int i = 0; i < arrPan.size(); i++) {
                frame.add(arrPan.get(i));
                frame.pack();
                repaint();
                //tab counter
                //blue screen of death
            }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        for (int i = 0; i < arrPan.size(); i++) {
            if (e.getSource().toString().contains(arrPan.get(i).getName())) {
                arrPan.remove(i);
                arrPan.add(0, (JPanel) e.getSource());
                //System.out.println(Arrays.toString(arrPan.toArray()));
                drawerFromArray();
            }
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {
        for (int i = 0; i < arrPan.size(); i++) {
            if (e.getSource().toString().contains(arrPan.get(i).getName())) {
                arrPan.remove(i);
                arrPan.add(0, (JPanel) e.getSource());
                //System.out.println(Arrays.toString(arrPan.toArray()));
                drawerFromArray();
            }
        }
        drawerFromArray();
        x = e.getX();
        y = e.getY();
        //System.out.println("pressed" + currentLocation);
    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void mouseDragged(MouseEvent e) {
        e.getComponent().setLocation((e.getX()
                + e.getComponent().getX()) - x, (e.getY() + e.getComponent().getY()) - y);
        drawerFromArray();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }

}

