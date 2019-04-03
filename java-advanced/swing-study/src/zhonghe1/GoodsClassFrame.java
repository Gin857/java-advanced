package zhonghe1;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import javax.swing.ImageIcon;
/**
 * 综合练习
 * @author xupeng
 * 2019.4.2
 */
public class GoodsClassFrame extends JFrame implements ActionListener {
    private GridLayout gridLayoutW, gridLayoutC;
    private JScrollPane jScrollPane;
    private JPanel cardPanelW, cardPanelC;
    private JButton firstBtn, secondBtn, thirdBtn, fourBtn;
    private JLabel imageLable;
    private JFileChooser fileChooser;


    public GoodsClassFrame() {
        init();
        setTitle("暂无名称");
        setSize(1900, 1080);
//        setUndecorated(true);
        setLocationRelativeTo(null);
//        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        cardPanelW = new JPanel();
        cardPanelC = new JPanel();
        jScrollPane = new JScrollPane();
        gridLayoutW = new GridLayout(4, 1);
        gridLayoutC = new GridLayout(3, 3);
        //字体
        Font font = new Font("微软雅黑",Font.BOLD,18);
        //面板改用grid
        cardPanelW.setLayout(gridLayoutW);
        cardPanelC.setLayout(gridLayoutC);
        gridLayoutW.setColumns(30);
        gridLayoutC.setColumns(30);
        //间距
        gridLayoutW.setHgap(2);
        gridLayoutW.setVgap(2);
        gridLayoutC.setHgap(10);
        gridLayoutC.setVgap(10);
        //单个大小
        gridLayoutW.setRows(5);
        cardPanelC.setBackground(new Color(25, 235, 215));
        cardPanelC.setSize(50, 50);
        cardPanelW.setBackground(new Color(220, 220, 220));
        jScrollPane.setBackground(new Color(250, 235, 215));
        //实现按钮，并设置名称
        firstBtn = new JButton("宠物类");
        secondBtn = new JButton("汽车类");
        thirdBtn = new JButton("第三类");
        fourBtn = new JButton("退    出");
        firstBtn.setFont(font);
        secondBtn.setFont(font);
        thirdBtn.setFont(font);
        fourBtn.setFont(font);
        //监听
        firstBtn.addActionListener(this);
        secondBtn.addActionListener(this);
        thirdBtn.addActionListener(this);
        fourBtn.addActionListener(this);
        //按钮加入面板
        cardPanelW.add(firstBtn);
        cardPanelW.add(secondBtn);
        cardPanelW.add(thirdBtn);
        cardPanelW.add(fourBtn);
        add(fourBtn,BorderLayout.NORTH);
        add(cardPanelW, BorderLayout.WEST);
        add(cardPanelC, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;
            org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper.launchBeautyEyeLNF();
        } catch (Exception e) {
            e.printStackTrace();
        }
        new GoodsClassFrame();
    }

    //各类事件的监听与处理
    @Override
    public void actionPerformed(ActionEvent e) {
        //后台监听测试
//        System.out.println("1");
        if (e.getSource() == firstBtn) {
            File file = new File("D:\\simulation\\animal");
            File[] fs = file.listFiles();
            //按钮点击提示
            System.out.println("按钮点击成功！");
            imageLable = new JLabel();
            for (File f : fs) {
                String srcFileName = f.getName();
                int position = srcFileName.indexOf(".");
                String suffixName = srcFileName.substring(position);
                if (suffixName.equals(".jpg") | suffixName.equals(".png")) {
                    try {
//                        byte[] bytes = new byte[(int) f.length()];
                        InputStream in = new FileInputStream(f);
                        in.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imageLable = new JLabel();
                        //图片的监听事件
                        imageLable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                JOptionPane.showMessageDialog(null,
                                        "暂无详细介绍哦！", "界面提示!",
                                        JOptionPane.INFORMATION_MESSAGE);
                                System.out.println("点击了图片");
//                            }
//                        });
                        imageLable.setIcon(icon);
//                        cardPanelC.add(imageLable);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO操作异常");
                    }
                    System.out.println(f);
                }
            }
        }


//        if (e.getSource() == secondBtn ) {
//            fileChooser = new JFileChooser();
//            fileChooser.setCurrentDirectory(new File("D:\\simulation\\car"));
//            fileChooser.setMultiSelectionEnabled(true);
//            int result = fileChooser.showOpenDialog(null);
//            imageLable=null;
//            if (result == JFileChooser.APPROVE_OPTION){
                File[] files = fileChooser.getSelectedFiles();
                System.out.println(files.length);
                for (File f : files) {
                    System.out.println(f.getAbsoluteFile());
                    //对每个子文件，创建字节输入流读入字节数组，构建icon，并设置给JLabel
                    try {
//                        byte[] bytes = new byte[(int) f.length()];
//                        InputStream in = new FileInputStream(f);
                        in.read(bytes);
                        Icon  icon = new ImageIcon(bytes);
//                        JLabel imageLable = new JLabel();
                        imageLable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                              }
//                                for (int k = 0 ;k<f.length();k++){
                                  ImageIcon  imageIcon = new ImageIcon("D:\\simulation\\car\\"+k+".jpg");
                                    JOptionPane.showMessageDialog(null,
                                            imageIcon,"提示消息!",
                                            JOptionPane.INFORMATION_MESSAGE);
//                                    System.out.println("点击了图片");
                                }
                            }
                        });
                        imageLable.setIcon(icon);
//                        cardPanelC.add(imageLable);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO操作异常");
                    }
                }
            }
        }

        if (e.getSource() == fourBtn) {
//            this.dispose();
        }
    }
}
