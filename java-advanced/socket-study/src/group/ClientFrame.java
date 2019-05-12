package group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;

public class ClientFrame extends JFrame implements ActionListener {
    private JButton LinkBtn, EnterBtn;
    private JTextArea jTextArea;
    private JTextField field;
    Socket socket;

    public ClientFrame() {
        init();
        setTitle("客户端端口");
        setBounds(1000, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        LinkBtn = new JButton("连接服务器");
        jTextArea = new JTextArea("wen");
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());
        field = new JTextField("输入");
        EnterBtn = new JButton("发送");
        EnterBtn.addActionListener(this);
        jp.add(field);
        jp.add(EnterBtn);
        LinkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(LinkBtn, "已成功连接服务器！");
                System.out.println("服务器连接成功");
                Client1 client1 = new Client1();
                new Thread(client1).start();
            }
        });

        add(LinkBtn, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(jp, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ClientFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == EnterBtn) {
            jTextArea.setText(field.getText());
            String info = field.getText();
            try {
                Socket socket = new Socket("127.0.0.1", 10086);
                OutputStream outputStream = socket.getOutputStream();
                outputStream.write(info.getBytes());
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
    }
}

class Client1 implements Runnable {

    @Override
    public void run() {
        try {
            Socket socket = new Socket("127.0.0.1", 10086);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}