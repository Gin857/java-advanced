package test.down;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerFrame2 extends JFrame implements ActionListener {
    private JButton StartButton;
    private static JTextArea jTextArea;

    public static JTextArea getjTextArea() {
        return jTextArea;
    }

    public ServerFrame2(){
        init();
        setTitle("服务端窗体" );
        setLocationRelativeTo(null);
        setBounds(200, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
    public void init(){
        StartButton = new JButton("启动服务器");
//        Font font  = new Font("微软雅黑",Font.BOLD,20);
        StartButton.addActionListener(this);
        jTextArea = new JTextArea();
//        jTextArea.setFont(font);

        add(StartButton, BorderLayout.SOUTH);
        add(jTextArea);

    }


    public static void main(String[] args)  {
        new ServerFrame2();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==StartButton)
        {
            ServerThread2 t2 = new ServerThread2();
            new Thread(t2).start();
        }
    }

    static class ServerThread1 implements Runnable{
        private  Socket socket;
        public ServerThread1(Socket socket){
            this.socket = socket;
        }
        @Override
        public void run() {
            jTextArea.setText(jTextArea.getText()+"\n客户端"+socket.getInetAddress()+"连接成功！");
            InputStream inputStream ;
            try {
                inputStream = socket.getInputStream();
                BufferedReader br  = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println(br.readLine());
//                br.close();
//                socket.close();
                System.out.println(" ");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    static class ServerThread2 implements Runnable{
        private  ServerSocket serverSocket;
        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(10086);
            } catch (IOException e) {
                e.printStackTrace();
            }
            jTextArea.setText(jTextArea.getText()+"\n服务器启动");
            Socket socket = null;
            while (true)
            {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                ServerThread1 server = new ServerThread1(socket);
                new Thread(server).start();

                ReceiveThread3 t3 = new ReceiveThread3(socket);
                new Thread(t3).start();
            }

        }
    }
}


class ReceiveThread3 implements Runnable{
    private Socket socket;

    public ReceiveThread3(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in;
        while (true) {
            try {
                in = socket.getInputStream();
                byte[] b = new byte[1024];
                in.read(b);
                System.out.println(new String(b));
                ServerFrame2.getjTextArea().setText(ServerFrame2.getjTextArea().getText() + "\n" + new String(b)+"\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
