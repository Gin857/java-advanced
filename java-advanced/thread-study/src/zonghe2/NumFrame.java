package zonghe2;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NumFrame extends JFrame implements ActionListener {
    private JLabel numberLabel;
    private JLabel timeLabel;
    private JPanel colorJPanel;
    private JButton jButton;
    private JButton jButton1;
    private JPanel lJPanel;
    private JPanel rLPanel;
    private JLabel cjl;
    private JPanel cJPanel;


    public NumFrame() {
        init();
        setTitle("澳门抽奖");
        setSize(900,627);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    public void init() {
        numberLabel = new JLabel("随机数");
        timeLabel = new JLabel("系统时间");
        colorJPanel = new JPanel();
        rLPanel = new JPanel();
        lJPanel = new JPanel();
        cJPanel = new JPanel();
        jButton = new JButton("澳门赌场");
        jButton1 = new JButton("皇冠赌场");
        cjl = new JLabel("     抽一抽，幸运大奖就到手   ");
        Dimension dimension = new Dimension(400,100);
        jButton.setPreferredSize(dimension);
        jButton1.setPreferredSize(dimension);
        Font font1 = new Font("微软雅黑",Font.BOLD,70);
        numberLabel.setFont(font1);
        Font font = new Font("微软雅黑",Font.BOLD,20);
        Font font2 = new Font("微软雅黑",Font.BOLD,28);
        Font font3 = new Font("微软雅黑",Font.BOLD,28);
        timeLabel.setFont(font);
        jButton1.setFont(font2);
        jButton.setFont(font2);

        cjl.setFont(font3);
        //监听事件
        jButton.addActionListener(this);

        //网格面板
//        add(numberLabel,BorderLayout.CENTER);
        add(timeLabel,BorderLayout.NORTH);
        colorJPanel.add(jButton);
        colorJPanel.add(jButton1);
        cJPanel.add(cjl);
        cJPanel.add(numberLabel);
        add(cJPanel,BorderLayout.CENTER);
        add(colorJPanel,BorderLayout.SOUTH);
        add(lJPanel,BorderLayout.EAST);
        add(rLPanel,BorderLayout.WEST);
//        add(picLabel,BorderLayout.EAST);
        //随机数的线程
        NumThread numThread =new NumThread();
        numThread.setNumberLabel(numberLabel);
        numThread.start();
        //系统时间的线程
        TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        //颜色随机的线程
        ColorThread colorThread = new ColorThread();
        colorThread.setColorJPanel(colorJPanel);
        colorThread.start();
        //按钮随机色
        ButtonThread buttonThread = new ButtonThread();
        buttonThread.setButtonThread(jButton);
        buttonThread.start();
        //按钮2的随机色
        Button1Thread button1Thread = new Button1Thread();
        button1Thread.setjButton1Thread(jButton1);
        button1Thread.start();
        //r
        RThread rThread = new RThread();
        rThread.setrJPanel(rLPanel);
        rThread.start();
        //l
        LThread lThread = new LThread();
        lThread.setlJPanel(lJPanel);
        lThread.start();

        //图片
//        URL url =NumFrame.class.getResource("zonghe2/niao.png");
//        Icon icon = new ImageIcon(url);
//        picLabel = new JLabel();
//        picLabel.setIcon(icon);
//        picLabel.setBounds(10,10,200,50);
//        PicThread picThread = new PicThread();
//        picThread.setPicLabel(picLabel);
//        picThread.start();


    }
    public static void main(String[] args)  {
        new NumFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == jButton){
            this.dispose();
        }
    }
}

