package week1;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.sound.midi.Soundbank;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Scanner;

/**
 * 文件选择器组件
 */
public class JFileChooserTest extends JFrame implements ActionListener {
    private JButton chooserbtn;
    private JLabel pathLable;
    private JFileChooser fileChooser;
    private JLabel path;

    public JFileChooserTest(){
        init();
        setTitle("CardLayout");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init(){
        chooserbtn = new JButton("选择文件");
        pathLable = new JLabel("咋暂无选择");
        Font font = new Font("微软雅黑",Font.BOLD,26);
        chooserbtn.addActionListener(this);
        pathLable.setFont(font);
        add(pathLable);
        add(chooserbtn, BorderLayout.NORTH);

    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new JFileChooserTest();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //测试
//        System.out.println("click");
        //创建对象
        fileChooser = new JFileChooser();
        //设置默认打开路径
        fileChooser.setCurrentDirectory(new File("D:\\"));
        //从项目的路径下选择
//        fileChooser.setCurrentDirectory(new File("."));
        //用户点击取消
        //用户点击确定
        //打开对话框
        int result = fileChooser.showOpenDialog(null);
        //测试
//        System.out.println(result);
        if (result == JFileChooser.APPROVE_OPTION){
            //获取用户选择的文件
            File file = fileChooser.getSelectedFile();
            //将选择的文件的绝对路径显示==测试
            pathLable.setText(file.getAbsolutePath());
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                pathLable.setText(scanner.nextLine());
            } catch (FileNotFoundException e1) {
                e1.printStackTrace();
            }
        }
    }
}
