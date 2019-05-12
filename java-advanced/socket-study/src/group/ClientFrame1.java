package group;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 客户端
 */
public class ClientFrame1 extends JFrame implements ActionListener {
    private JButton contactBtn, overBtn;
    private JButton sendBtn;
    private JTextArea jTextArea;
    private JTextField jTextField;
    private JPanel flowLayoutTop, flowLayoutBottom;
    private Socket socket;

    public ClientFrame1() {
        init();
        setTitle("客户端端口");
        setBounds(1000, 100, 500, 670);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {
        flowLayoutTop = new JPanel(new FlowLayout());
        Dimension dimension = new Dimension(140, 40);
        Color color = new Color(255, 255, 255);
        Font font = new Font("微软雅黑", Font.BOLD, 18);
        contactBtn = new JButton("连接服务器");
        overBtn = new JButton("断开连接");
        contactBtn.setBackground(new Color(67, 160, 71));
        overBtn.setBackground(new Color(245, 124, 0));
        contactBtn.setForeground(color);
        overBtn.setForeground(color);
        contactBtn.setFont(font);
        overBtn.setFont(font);
        contactBtn.setPreferredSize(dimension);
        overBtn.setPreferredSize(dimension);
        flowLayoutTop.add(contactBtn);
        flowLayoutTop.add(overBtn);
        contactBtn.addActionListener(this);
        jTextArea = new JTextArea();
        jTextField = new JTextField();
        jTextField.setPreferredSize(new Dimension(260, 40));
        jTextField.setFont(new Font("微软雅黑", Font.BOLD, 24));
        sendBtn = new JButton("发送");
        sendBtn.setPreferredSize(dimension);
        sendBtn.setBackground(new Color(1, 207, 254));
        sendBtn.setForeground(new Color(255, 255, 255));
        sendBtn.setFont(font);

        jTextArea.setFont(font);
        flowLayoutBottom = new JPanel(new FlowLayout());
        flowLayoutBottom.add(jTextField);
        flowLayoutBottom.add(sendBtn);

        contactBtn.addActionListener(this);
        sendBtn.addActionListener(this);

        add(flowLayoutTop, BorderLayout.NORTH);
        add(jTextArea, BorderLayout.CENTER);
        add(flowLayoutBottom, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new ClientFrame1();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == contactBtn) {
            try {
                socket = new Socket("127.0.0.1", 10086);
                JOptionPane.showMessageDialog(overBtn, "连接服务器成功!");
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(overBtn, "连接失败!");
            }
        }

        if (e.getSource() == sendBtn) {
            OutputStream out = null;
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
            try {
                out = socket.getOutputStream();
                String text = jTextField.getText();
                out.write(text.getBytes());
                jTextArea.append("时间：" + String.valueOf(simpleDateFormat.format(date)) + " ,内容：" + text + "\n");
                jTextField.setText("");
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
}
