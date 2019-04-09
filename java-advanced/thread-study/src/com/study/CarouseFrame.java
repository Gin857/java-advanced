package com.study;

import javax.swing.*;
import java.awt.*;

public class CarouseFrame extends JFrame {
    private JLabel bgLabel;
    private JPanel jPanel;
    private JButton jButton;
    public CarouseFrame(){
        init();
        setTitle("创意背景轮播");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    private void  init(){
        bgLabel = new JLabel();
        add(bgLabel,BorderLayout.SOUTH);
        jPanel = new JPanel();
        add(jPanel, BorderLayout.CENTER);
        jButton = new JButton("fsdfkhf");
        jPanel.add(jButton);
        CarouseThread carouseThread = new CarouseThread();
        carouseThread.setBjLabel(bgLabel);
        new Thread(carouseThread).start();
    }

    public static void main(String[] args) {
        new CarouseFrame();
    }
}
