package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class MyFrame extends JPanel implements ActionListener, MouseMotionListener, MouseListener {
    public JFrame frame = new JFrame("Windows XP");
    public JPanel panel = new JPanel();
    public JPanel bottomTaskBar = new JPanel();
    private int x, y;
    public JLabel background = new JLabel(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/windowsbackground.jpeg"));
    ImageIcon scaledInternet = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internet.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    ImageIcon expPage = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/fileexplorerhome.jpeg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
    ImageIcon intPage = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/internetexplorerpage.jpeg").getImage().getScaledInstance(500, 400, Image.SCALE_DEFAULT));
    ImageIcon scaledFileExp = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/fileexplorer.png").getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT));
    ImageIcon closeIcon = new ImageIcon(new ImageIcon("/Users/farhankhan/IdeaProjects/WindowsVista/src/com/company/assets/sfc.jpeg").getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT));
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
        frame.add(panel, BorderLayout.LINE_START);
        frame.add(bottomTaskBar, BorderLayout.PAGE_END);
        //bottomTaskBar.setLayout(new BoxLayout(bottomTaskBar, BoxLayout.X_AXIS));
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
        bottomTaskBar.setSize(1600, 50);
        bottomTaskBar.setBackground(new Color(0,96,228));
        //button array forloop?
    }

    public void createNewWindow(String name) {
        Random rand = new Random();
        final JPanel panel2 = new JPanel();
        JPanel closeButtonBar = new JPanel();
        JLabel image = new JLabel();
        if (name.contains("File Explorer ")) {
            image.setIcon(expPage);
        }
        if (name.contains("Internet Explorer ")) {
            image.setIcon(intPage);
        }
        panel2.setLayout(new BorderLayout());
        closeButtonBar.setLayout(new BoxLayout(closeButtonBar, BoxLayout.Y_AXIS));
        closeButtonBar.setSize(500, 100);
        closeButtonBar.setBackground(new Color(0,98, 252,  255));
        JButton closeButton = new JButton(closeIcon);
        closeButton.setName(name + " button");
        closeButton.addActionListener(this);
        closeButton.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
        closeButtonBar.add(closeButton);
        panel2.add(closeButtonBar, BorderLayout.NORTH);
        panel2.setName(name);
        panel2.setSize(500, 400);
        //panel2.setBackground(new Color(rand.nextInt(255), rand.nextInt(255), rand.nextInt(255)));
        panel2.setLocation(rand.nextInt(800), rand.nextInt(400));
        panel2.addMouseListener(this);
        panel2.addMouseMotionListener(this);
        panel2.add(image);
        arrPan.add(panel2);
        drawerFromArray();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == internetExp) {
            String name = "Internet Explorer " + arrPan.size();
            createNewWindow(name);
            //make if pressed, and then reorder array based on that
        }
        if (e.getSource() == fileExp) {
            String name = "File Explorer " + arrPan.size();
            createNewWindow(name);
            //make if pressed, and then reorder array based on that
        }
        if (e.getSource().toString().contains("button")) {
            String titleToRemove = e.getSource().toString();
            for (int i = 0; i < arrPan.size(); i++) {
                if(titleToRemove.contains(arrPan.get(i).getName())) {
                    panelRemover(i);
                    //arrPan.get(i).setVisible(false);
                }
            }
        }
    }
    public void drawerFromArray() {
        if (arrPan.size() > 0) {
            for (JPanel jPanel : arrPan) {
                frame.add(jPanel);
                frame.revalidate();
                frame.pack();
                repaint();
                //tab counter
                //blue screen of death
            }
        } else{
            frame.revalidate();
            frame.pack();
            repaint();
        }
    }
    public void panelRemover(int index) {
        JPanel panelToDie = arrPan.get(index);
        frame.remove(panelToDie);
        arrPan.remove(index);
        System.out.println(arrPan.size());
        drawerFromArray();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //reordeer(e);


    }

    @Override
    public void mousePressed(MouseEvent e) {
        reorder(e);
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
        //drawerFromArray();
        repaint();

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }
    public void reorder(MouseEvent e) {
        for (int i = 0; i < arrPan.size(); i++) {
            if (e.getSource().toString().contains(arrPan.get(i).getName())) {
                arrPan.remove(i);
                arrPan.add(0, (JPanel) e.getSource());
                //System.out.println(Arrays.toString(arrPan.toArray()));
                drawerFromArray();
            }
        }
    }

}

