package zhonghe1;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.util.Scanner;

/**
 * xp
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
        setSize(500, 800);
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
        firstBtn = new JButton("第一类");
        secondBtn = new JButton("第二类");
        thirdBtn = new JButton("第三类");
        fourBtn = new JButton("退出");
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

        add(cardPanelW, BorderLayout.WEST);
//        cardPanelC.add(jScrollPane);
//        jScrollPane.add(cardPanelC);
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
            File file = new File("D:\\test");
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
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream in = new FileInputStream(f);
                        in.read(bytes);
                        Icon icon = new ImageIcon(bytes);
                        JLabel imageLable = new JLabel();
                        //图片的监听事件
                        imageLable.addMouseListener(new MouseAdapter() {
                            @Override
                            public void mouseClicked(MouseEvent e) {
                                JOptionPane.showMessageDialog(null,
                                        "抱歉！此商品已下架", "提示消息!",
                                        JOptionPane.ERROR_MESSAGE);
                                System.out.println("点击了图片");
                            }
                        });
                        imageLable.setIcon(icon);
                        cardPanelC.add(imageLable);
                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO操作异常");
                    }
                    System.out.println(f);
                }
            }
        }


        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("D:\\test"));
        int result = fileChooser.showOpenDialog(null);
        if (e.getSource() == secondBtn & result == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            //将选择的文件的绝对路径显示==测试
//            imageLable.setText(file.getAbsolutePath());
            try {
                InputStream inputStream = new FileInputStream(file);
                Scanner scanner = new Scanner(inputStream);
                imageLable.setText(scanner.nextLine());
                cardPanelC.add(imageLable);
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }


        if (e.getSource() == fourBtn) {
            this.dispose();
        }
    }
}
