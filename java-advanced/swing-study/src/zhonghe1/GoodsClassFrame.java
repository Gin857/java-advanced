package zhonghe1;

import com.sun.media.jfxmedia.events.NewFrameEvent;
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
 * io综合布局
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

        //间距
        gridLayoutW.setHgap(2);
        gridLayoutW.setVgap(2);
        gridLayoutC.setHgap(10);
        gridLayoutC.setVgap(10);

        //监听
        firstBtn.addActionListener(this);
        secondBtn.addActionListener(this);
        thirdBtn.addActionListener(this);
        fourBtn.addActionListener(this);


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
