package study;

import javafx.scene.layout.BorderPane;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.lang.String;

/**
 * 图片窗体程序
 * @author 徐鹏
 * 2019.3.26
 */
public class ImageFrame extends JFrame {
    //声名头部面板
    private JPanel topPanel;
    private JButton[] buttons;
    private JLabel imgLabel;
    private Icon icon;
    private JLabel content;
    private JLabel path;
    private JLabel pathspace;

    //构造方法和类名一样
    public ImageFrame(){
        init();
        //this可以省略
        setTitle("标题");
        setSize(600,400);
        //自动居中
        setLocationRelativeTo(null);
        //可见
        setVisible(true);
        //关闭
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    //设置布局，放置组件
    public void  init(){
        topPanel = new JPanel();
        buttons = new JButton[6];
        for (int i =1 ;i<6;i++){
            buttons[i] = new JButton("按钮"+i);
            topPanel.add(buttons[i]);
        }
        add(topPanel, BorderLayout.NORTH);
        imgLabel = new JLabel();//可以为空
        //读入本地的图片到字节数组
        File srcFile = new File("D:/b2.png");
        byte[] bytes = null;
        InputStream inputStream;
        try {
            //图片到bytes
             inputStream = new FileInputStream(srcFile);
             bytes= new byte[(int) srcFile.length()];
            inputStream.read(bytes);
            inputStream.close();
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        icon = new ImageIcon(bytes);
        imgLabel.setIcon(icon);
        add(imgLabel,BorderLayout.WEST);
        //系统的的时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String date = format.format(new Date());
        content = new JLabel(date);
        add(content,BorderLayout.CENTER);

        //绝对路径
        File srcFile1 = new File("D:/b2.png");
        String path1 = srcFile1.getAbsolutePath();
        path = new JLabel(path1);
        add(path,BorderLayout.EAST);
    }

    public static void main(String[] args) {
        new ImageFrame();
    }
}
