package com.io.study;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * txt文件阅读器窗体
 */
public class TxtReaderFrame extends JFrame implements ActionListener {
    private JTextField inputField;
    private JButton confirmeButton;
    private JPanel topPanel;
//    private JTextArea contentArea;
    private JLabel imageLabel;
    private Icon icon;

    public TxtReaderFrame(){
        init();
        setTitle("文本阅读窗体");
        setSize(new Dimension(640,480));
        setLocationRelativeTo(null);
        //窗体可见
        setVisible(true);
        //真正的关闭进程
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }
    public void init(){
        Font font = new Font("微软雅黑",Font.PLAIN,26);
        inputField = new JTextField(20);
        inputField.setPreferredSize(new Dimension(150,40));
        inputField.setFont(font);
        confirmeButton =new JButton("确认");
        confirmeButton.setPreferredSize(new Dimension(100,40));
        confirmeButton.setFont(font);
        topPanel= new JPanel();
        topPanel.add(inputField);
        topPanel.add(confirmeButton);
        confirmeButton.addActionListener(this);
        add(topPanel,BorderLayout.NORTH);
        //图片的加入
        imageLabel = new JLabel();
        add(imageLabel,BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        new TxtReaderFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //获取输入框内容
        String filePath = inputField.getText().trim();
        //创建文件
        File file = new File(filePath);
        //使用三种方法将file中的内容读入
        InputStream in;
        byte[] bytes = null;
        try {
            in = new FileInputStream(file);
            bytes = new byte[(int) file.length()];
            in.read(bytes);
            icon = new ImageIcon(bytes);
            imageLabel.setIcon(icon);

        } catch (IOException e1) {
            System.out.println("io异常");
            JOptionPane.showMessageDialog(null,"IO操作异常");
        }

    }
}
