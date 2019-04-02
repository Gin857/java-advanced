package week1;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

/**
 * 多选图片卡片布局
 */
public class ImageFrame extends JFrame implements ActionListener {
    private JButton chooserBtn, preBtn, nextBtn;
    private JFileChooser fileChooser;
    private JPanel centerPanel, bottomPanel;
    private CardLayout cardLayout;
    private Icon icon;
    private JLabel imageLabel;

    public ImageFrame() {
        init();
        setTitle("使用卡片布局实现多图功能");
        setSize(1024, 768);
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }


    public void init() {
        bottomPanel = new JPanel();
        chooserBtn = new JButton("图片选择");
        add(chooserBtn, BorderLayout.NORTH);
        chooserBtn.addActionListener(this);
        preBtn = new JButton("上一张");
        nextBtn = new JButton("下一张");
        nextBtn.addActionListener(this);
        preBtn.addActionListener(this);
        bottomPanel.add(chooserBtn);
        bottomPanel.add(preBtn);
        bottomPanel.add(nextBtn);
        add(bottomPanel, BorderLayout.SOUTH);

        centerPanel = new JPanel();
        cardLayout = new CardLayout();
        centerPanel.setLayout(cardLayout);
        centerPanel.setBackground(new Color(173, 255, 146));
        add(centerPanel);

        imageLabel = new JLabel();
        add(imageLabel, BorderLayout.CENTER);
    }


    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new ImageFrame();
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooserBtn) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:\\test"));
            //多选
            fileChooser.setMultiSelectionEnabled(true);
            int result = fileChooser.showOpenDialog(null);

            if (result == JFileChooser.APPROVE_OPTION) {
                File[] files = fileChooser.getSelectedFiles();
                System.out.println(files.length);
                //遍历数组
                for (File f : files) {
                    System.out.println(f.getAbsoluteFile());
                    //对每个子文件，创建字节输入流读入字节数组，构建icon，并设置给JLabel
                    try {
                        InputStream in = new FileInputStream(f);
                        byte[] bytes = null;
                        bytes = new byte[(int) f.length()];
                        in.read(bytes);
                        icon = new ImageIcon(bytes);
                        imageLabel.setIcon(icon);
                        add(imageLabel,BorderLayout.CENTER);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO操作异常");
                    }
                }
            }
        }
        if (e.getSource() == preBtn) {
            System.out.println("2");
        }
        if (e.getSource() == nextBtn) {
            System.out.println("3");
        }
    }
}
