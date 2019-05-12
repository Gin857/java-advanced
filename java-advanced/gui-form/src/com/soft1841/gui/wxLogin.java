package com.soft1841.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class wxLogin {
    private JPanel mainPanel;
    private JLabel avatarImg;
    private JLabel nameLabel;
    private JButton loginBtn;

    public wxLogin() {
        loginBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"登录成功！");
            }
        });
    }

    public static void main(String[] args) throws Exception{
        UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        JFrame frame = new JFrame("微信");
        frame.setContentPane(new wxLogin().mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(290,410);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }
}
