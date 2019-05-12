package test.down;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
public class ClientFrame extends JFrame {
    private JPanel topPanel;
    private JButton sentBtn, linkBtn;
    private JTextField jTextField;
    private Socket client;

    private ClientFrame() {
        init();
        setTitle("文本阅读窗体");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        topPanel = new JPanel();
        linkBtn = new JButton("连接服务器");
        sentBtn = new JButton("发送");
        linkBtn.setPreferredSize(new Dimension(100, 30));
        sentBtn.setPreferredSize(new Dimension(100, 30));
        jTextField = new JTextField(20);
        jTextField.setPreferredSize(new Dimension(150, 40));
        topPanel.add(linkBtn);
        topPanel.add(sentBtn);
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        jTextField.setFont(font);
        add(topPanel, BorderLayout.NORTH);
        add(jTextField, BorderLayout.CENTER);
        //连接服务器
        linkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    client = new Socket("192.168.43.140", 10010);
                    System.out.println("成功连接上服务器");
                    JOptionPane.showMessageDialog(null, "成功连接上服务器！");
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //发送
        sentBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String string = jTextField.getText();
                    BufferedWriter buf;
                    buf = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    buf.write(string);
                    buf.flush();
                    buf.close();
                    System.out.println("已发送信息：" + string);
                    JOptionPane.showMessageDialog(null, "信息已发送！");

                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new ClientFrame();
    }
}
