package com.soft1841.gui;

import javax.swing.*;

public class QQMusic {
    private JPanel mainPanel;
    private JButton 喜欢Button;
    private JButton 音乐馆Button;
    private JButton 视频Button;
    private JButton 个性电台Button;
    private JButton 本地和下载Button;
    private JButton 历史Button;

    public static void main(String[] args) throws Exception{
        String lookAndFeel = UIManager.getSystemLookAndFeelClassName();
        UIManager.setLookAndFeel(lookAndFeel);
        JFrame frame = new JFrame("QQMusic");
        frame.setContentPane(new QQMusic().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }
}
