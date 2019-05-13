package com.soft1841.gui;

import javax.swing.*;

public class Music {
    private JPanel mainPanel;
    private JPanel leftPanel;
    private JPanel topPanel;
    private JButton 搜索Button;
    private JButton 发现Button;
    private JPanel buttonPanel;
    private JButton MVButton;
    private JButton 朋友Button;
    private JLabel bofang;

    public static void main(String[] args) throws Exception {
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("Music");
        frame.setContentPane(new Music().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
