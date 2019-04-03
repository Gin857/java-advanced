package zhonghe1;

import org.jb2011.lnf.beautyeye.BeautyEyeLNFHelper;

import javax.swing.*;

import java.awt.event.ActionListener;

 * 综合练习
 * @author xupeng
 * 2019.4.2
 */
public class GoodsClassFrame emplements ActionListener {
    private GridLayout gridLayoutW, gridLayoutC;
    private JScrollPane jScrollPane;
    private JPanel cardPanelW, cardPanelC;
secondBtn, thirdBtn, fourBtn;
    private JLabel imageLable;
    private JFileChooser fileChooser;


    public GoodsClassFrame() {
        init();
        setTitle("暂无名称");
        setSize(1900, 1080);
//        setUndecorated(true);
eTo(null);
//        setResizable(false);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        cardPanelW = new JPanel();
     );
        gridLayoutW = new GridLayout(4, 1);
        gridLayoutC = new GridLayout(3, 3);
        //字体
        Font font = new Font("微软雅黑",Font.BOLD,18);
        //面板改用grid
        cardPanelW.setLayout(gridLayoutW);
 utC);
        gridLayoutW.setColumns(30);
        gridLayoutC.setColumns(30);
        //间距
 ;
        gridLayoutC.setVgap(10);
        //单个大小
        gridLayoutW.setRows(5);
        cardPanelC.;
        jScrollPane.setBackground(new Color(250, 235, 215));
        //实现按钮，并设置名称
        firstB
        fourBtn = new JButton("退    出");
        firstBtn.setFont(font);
        secondBtn.setFont(font);
        thirdBtn.setFont(font);
        fourBtn.setFont(font);
        //监听

        secondBtn.addActionListener(this);
        thirdBtn.addActionListener(this);
        fourBtn.addActionListener();
        //按钮加入面板
        cardPanelW.add(firstBtn);
        cardPanelW.add(secondBtn);
        cardPanelW.add(thirdBtn);
;
        add(cardPanelC, BorderLayout.CENTER);
    }

    public static void main(String[] args) {
        try {
            BeautyEyeLNFHelper.frameBorderStyle = BeautyEyeLNFHelper.frameBorderStyle.osLookAndFeelDecorated;

    }

    //各类事件的监听与处理
    @Override
    public void actionPerformed(ActionEvent e) {
        //后台监听测试
//        System.out.println("1");
        if (e"D:\\simulation\\animal");
            File[] fs = file.listFiles();
            //按钮点击提示
            System.out.println("按钮点击成功！");
            imageLable = new JLabel();
            for (
                if (suffixName.equals(".jpg") | suffixName.equals(".png")) {
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream in = new FileInputStream(f);

                            @Override
                            public void mouseClicked(MouseEvent e) {

                            }
                        });
                        imageLable.setIcon(icon);
                        cardPanelC.add(imageLable);
  (null, "IO操作异常");
                    }

                }
            }
        }


        if (e.getSource() == secondBtn ) {
            fileChooser = new JFileChooser();
            fileChooser.setCurrentDirectory(new File("D:\\simulation\\car"));
            fileChooser.setMultiSelectionEnabled(true);
;
                for (File f : files) {
                    System.out.println(f.getAbsoluteFile());
                    //对每个子文件，创建字节输入流读入字节数组，构建icon，并设置给JLabel
                    try {
                        byte[] bytes = new byte[(int) f.length()];
                        InputStream in = new FileInputStream(f);
                        in.read(bytes);
                        Icon  icon = new ImageIcon(bytes);

                            @Override
                            public void mouseClicked(MouseEvent e) {
//                                for (int i= 0;i<f.length();i++){
//                                     imageIcon = new ImageIcon("D:\\simulation\\car\\"+i+".jpg");
//                                    JOptionPane.showMessageDialog(null,
//
//                                }
                                for (int k = 0 ;k<f.length();k++){
                                  ImageIcon  imageIcon = new ImageIcon("D:\\simulation\\car\\"+k+".jpg");
                                    JOptionPane.(null,

                            }
                        });

                    } catch (IOException e1) {
                        JOptionPane.showMessageDialog(null, "IO操作异常");
                    }
                }
            }
        }


        }
    }
}
