package group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 服务器端
 */
public class ServerFrame1 extends JFrame implements ActionListener {
    private JButton startBtn, overBtn;
    private static JTextArea jTextArea;
    private JPanel flowLayout;

    public ServerFrame1() {
        init();
        setTitle("服务器端口");
        setBounds(200, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {
        flowLayout = new JPanel(new FlowLayout());
        Dimension dimension = new Dimension(140, 40);
        Font font = new Font(null, Font.BOLD, 18);
        Color wcolor = new Color(255, 255, 255);
        startBtn = new JButton("启动服务器");
        overBtn = new JButton("关闭服务器");
        startBtn.setPreferredSize(dimension);
        overBtn.setPreferredSize(dimension);
        startBtn.setBackground(new Color(67, 160, 71));
        overBtn.setBackground(new Color(245, 124, 0));
        startBtn.setFont(font);
        overBtn.setFont(font);
        startBtn.setForeground(wcolor);
        overBtn.setForeground(wcolor);
        flowLayout.add(startBtn);
        flowLayout.add(overBtn);
        startBtn.addActionListener(this);
        jTextArea = new JTextArea();
        jTextArea.setFont(font);

        add(flowLayout, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);

    }

    public static void main(String[] args) {
        new ServerFrame1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == startBtn) {
            MainThread mainThread = new MainThread();
            new Thread(mainThread).start();
            JOptionPane.showMessageDialog(overBtn, "服务器已启动！");
        }
    }

    //主线程
    static class MainThread implements Runnable {
        private ServerSocket serverSocket;

        @Override
        public void run() {
            try {
                serverSocket = new ServerSocket(10086);
            } catch (IOException e) {
                e.printStackTrace();
            }
            Socket socket = null;

            while (true) {
                try {
                    socket = serverSocket.accept();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                InputThread server = new InputThread(socket);
                new Thread(server).start();

                AddThread t3 = new AddThread(socket);
                new Thread(t3).start();
            }
        }

    }


    //获取客户端消息
    static class InputThread implements Runnable {
        private Socket socket;

        public InputThread(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            jTextArea.setText( "\n客户端" + socket.getInetAddress() + "连接成功！"+"\n");
        }
    }

    public static JTextArea getjTextArea() {
        return jTextArea;
    }
}


//获取客户端消息
class AddThread implements Runnable {

    private Socket socket;

    public AddThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        InputStream in;
        while (true) {
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                in = socket.getInputStream();
                byte[] b = new byte[1024];
                in.read(b);
                System.out.println(new String(b));
                ServerFrame1.getjTextArea().setText(ServerFrame1.getjTextArea().getText()
                        +  "\n客户端" + socket.getInetAddress()+"在"+String.valueOf(simpleDateFormat.format(date))
                        +" 发来消息："+"\n"+ "        "+new String(b) + "\n");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}