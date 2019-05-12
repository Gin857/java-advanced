package group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame extends JFrame implements ActionListener {
    JButton startBtn;
    private JTextArea jTextArea;
    private ServerSocket serverSocket;
    private Socket socket;

    public ServerFrame() {
        try {
            init();
        } catch (IOException e) {
            System.out.println("1");
        }
        setTitle("服务器端口");
        setBounds(200, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() throws IOException {

        startBtn = new JButton("启动服务器");
        JTextArea jTextArea = new JTextArea("wen");
        JPanel jp = new JPanel();
        jp.setLayout(new FlowLayout());
        JTextField field = new JTextField("输入");
        JButton EnterBtn = new JButton("发送");
        jp.add(field);
        jp.add(EnterBtn);
        startBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(startBtn, "服务器已启动");
                Server1 server1 = new Server1();
                new Thread(server1).start();
                System.out.println("服务器启动成功！");
            }
        });
        add(startBtn, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(jp, BorderLayout.SOUTH);
        //接收消息的线程
//        ServerThreada serverThreada = new ServerThreada(socket);
//        serverThreada.setjTextArea(jTextArea);
//        new Thread(serverThreada).start();
        serverSocket = new ServerSocket(10086);
        while (true){
            try {
                socket = serverSocket.accept();
            } catch (IOException e) {
                e.printStackTrace();
            }
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();

            } catch (IOException e) {
                e.printStackTrace();
            }
            byte[] bytes = new byte[1024];
            try {
                inputStream.read(bytes);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("客户端" + socket.getInetAddress() + "给您发来新消息：" + new String(bytes));
            jTextArea.append(new String(bytes));

        }

    }

    public static void main(String[] args) {
        new ServerFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
//
////服务器运行线程
//class ServerThreada implements Runnable {
//
//    private Socket socket;
//    private JTextArea jTextArea;
//
//    public ServerThreada(Socket socket) {
//        this.socket = socket;
//    }
//
//    public void setjTextArea(JTextArea jTextArea) {
//        this.jTextArea = jTextArea;
//    }
//    @Override
//    public void run() {
//        System.out.println("客户端" + socket.getInetAddress() + "连接成功！");
//        try {
//            InputStream inputStream = socket.getInputStream();
//            byte[] bytes = new byte[1024];
//            inputStream.read(bytes);
//            System.out.println("客户端" + socket.getInetAddress() + "给您发来新消息：" + new String(bytes));
//            jTextArea.append(String.valueOf(bytes));
//
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//}

//服务器的启动线程
class Server1 implements Runnable {

    @Override
    public void run() {
        ServerSocket ss = null;
        try {
            ss = new ServerSocket(10086);
//            while (true) {
                Socket socket = ss.accept();
                InputStream inputStream = socket.getInputStream();


//                ServerThreada serverThreada = new ServerThreada(socket);
//                serverThreada.setjTextArea(jTextArea);
//                new Thread(serverThreada).start();
//                System.out.println("服务器已启动！端口号10086");
//            }
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }
}