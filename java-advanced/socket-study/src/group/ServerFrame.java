package group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerFrame extends JFrame implements AdjustmentListener {
    JButton startBtn;

    public ServerFrame() {
        init();
        setTitle("服务器端口");
        setBounds(200, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {

        startBtn = new JButton("启动服务器");
        JTextArea jTextArea = new JTextArea("wen");
        JPanel jp =new JPanel();
        jp.setLayout(new FlowLayout());
        JTextField field = new JTextField("输入");
        JButton EnterBtn = new JButton("发送");
        jp.add(field);
        jp.add(EnterBtn);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerSocket ss = new ServerSocket(2323);
                    System.out.println("服务器已启动！端口号2323");
                    InputStream in;
                    Socket socket = ss.accept();
                    while (true){
                        in = socket.getInputStream();
                        byte[] b = new byte[1024];
                        in.read(b);
                        System.out.println("客户端"+socket.getInetAddress()+"发送的数据是："+new String(b));
                        OutputStream out = socket.getOutputStream();
                        Scanner scanner = new Scanner(System.in);
                        System.out.println("请输入要发给客户端的内容:");
                        String info  = scanner.nextLine();
                        out.write(info.getBytes());
                        JOptionPane.showMessageDialog(startBtn, "服务器已启动");

                    }


                }catch (IOException e1){
                    System.out.println("IO异常");
                }
            }
        });

        add(startBtn, BorderLayout.NORTH);
        add(jTextArea,BorderLayout.CENTER);
        add(jp,BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ServerFrame();
    }

    @Override
    public void adjustmentValueChanged(AdjustmentEvent e) {

    }
}

class MessJO extends JFrame {
    public MessJO(ServerFrame frame) {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());

    }
}
