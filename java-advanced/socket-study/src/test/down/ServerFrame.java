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
/**
 * 客户端向服务器端发送信息——GUI版
 */
public class ServerFrame extends JFrame {
    private JTextArea contentTextArea;
    private JButton runButton;
    private JPanel topPanel;

    private ServerFrame() {
        init();
        setTitle("服务器端");
        setSize(new Dimension(800, 600));
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        topPanel = new JPanel();
        runButton = new JButton("启动服务器");
        runButton.setPreferredSize(new Dimension(70, 40));
        topPanel.add(runButton);
        contentTextArea = new JTextArea();
        Font font = new Font("微软雅黑", Font.PLAIN, 20);
        contentTextArea.setFont(font);
        add(topPanel, BorderLayout.NORTH);
        add(contentTextArea, BorderLayout.CENTER);
        //启动监听
        runButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ServerSocket serverSocket = new ServerSocket(10010);
                    System.out.println("服务器启动！");
                    JOptionPane.showMessageDialog(null, "服务器启动！");
                    while (true) {
                        Socket socket = serverSocket.accept();
                        ServerThread4 server = new ServerThread4();
                        server.setSocket(socket);
                        new Thread(server).start();
                    }
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
    }

    public static void main(String[] args) {
        new ServerFrame();
    }

    class ServerThread4 implements Runnable {
        private Socket socket;

        public void setSocket(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {

            System.out.println("客户端" + socket.getInetAddress() + "连接成功！");
            InputStream inputStream = null;
            try {
                inputStream = socket.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
                System.out.println(br.readLine());
                contentTextArea.setText(br.readLine());
                br.close();
                socket.close();
            } catch (IOException e) {
                //弹出窗口
                JOptionPane.showMessageDialog(null, "IO操作异常！");
            }
        }
    }
}
