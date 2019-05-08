package group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class ClientFrame extends JFrame {
    JButton LinkBtn;
    public ClientFrame() {
        init();
        setTitle("客户端端口");
        setBounds(1000, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init(){
        LinkBtn = new JButton("连接服务器");
        JTextArea jTextArea = new JTextArea("wen");
        JPanel jp =new JPanel();
        jp.setLayout(new FlowLayout());
        JTextField field = new JTextField("输入");
        JButton EnterBtn = new JButton("发送");
        jp.add(field);
        jp.add(EnterBtn);
        LinkBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Socket socket = new Socket("127.0.0.1",2323);

                    OutputStream out = socket.getOutputStream();
                    Scanner scanner = new Scanner(System.in);
                    while (true){
                        System.out.println("请输入要发给服务器的内容:");
                        String info  = scanner.nextLine();
                        out.write(info.getBytes());
                        InputStream in = socket.getInputStream();
                        byte[] b = new byte[1024];
                        in.read(b);
                        System.out.println("服务端发送的数据是："+new String(b));
                        JOptionPane.showMessageDialog(LinkBtn, "已成功连接服务器！");
                    }
                }catch (IOException e1){
                    System.out.println("IO异常");
                }
            }
        });

        add(LinkBtn, BorderLayout.NORTH);
        add(jTextArea,BorderLayout.CENTER);
        add(jp,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ClientFrame();
    }
}
