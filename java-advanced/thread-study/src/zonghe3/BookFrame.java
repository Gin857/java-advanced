package zonghe3;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.*;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 晨曦读书--期中大作业
 * @author 徐鹏
 * 2019.4.22日开始---2019.4.27结束
 */

public class BookFrame extends JFrame implements ActionListener {
    private JLabel timeLabel, bgLabel1, titleLabel;
    private JPanel centerFristJpanelTop, fristJpanel, fristJpanel2, secondJpanel, secondJpanel2;
    private JPanel thridJpanel, thridJpanel2, fourJpanel, fourJpanel2;
    private JButton pictureBtn, musicBtn, southBtn;
    private JButton seeBtn, downBtn;
    private JPanel imgPanel;
    private JButton upJButton, saveJButton, shareJButton;
    private JLabel jLabel00;

    public BookFrame() {
        init();
        setTitle("晨曦读书");
        setSize(900, 627);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void init() {
        //样式代码块
        //标题与时间代码
        Font timeFont = new Font("宋体", Font.BOLD, 32);
        Font bookFont = new Font("微软雅黑", Font.BOLD, 28);


        //第一个区域的按钮的大小与颜色
        Dimension friDimension = new Dimension(180, 30);
        Color friColor = new Color(200, 200, 0);
        Color sedColor = new Color(200, 20, 220);
        //第二个区域的按钮的大小与颜色
        Dimension sedDimension = new Dimension(180, 30);
        Font btnFont = new Font("楷体", Font.BOLD, 24);
        Color seeColor = new Color(200, 200, 20);
        Color dowmColor = new Color(245, 123, 12);
        //第四个区域按钮的大小与颜色
        Font titleFont = new Font("微软雅黑", Font.BOLD, 22);
        Font title2Font = new Font("微软雅黑", Font.BOLD, 22);
        Font title3Font = new Font("微软雅黑", Font.BOLD, 13);
        Color upColor = new Color(175, 238, 238);
        Color saveColor = new Color(0, 255, 255);
        Color shareColor = new Color(0, 206, 209);
        Font textAreaFont = new Font("微软雅黑", Font.BOLD, 26);
        //面板块
        //North块面板与布局
        NorthPanel northPanel = new NorthPanel();
        northPanel.setLayout(new GridLayout(1, 2, 10, 10));
        //Center块面板与布局
        Container c = new Container();
        c.setLayout(new GridLayout(2, 2, 20, 10));
        //Center块面板与布局第一块面板
        JPanel jPanel1 = new JPanel();
        jPanel1.setLayout(new BorderLayout());
        //第一个按钮
        pictureBtn = new JButton("选择图片");
        pictureBtn.setPreferredSize(friDimension);
        pictureBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        pictureBtn.setForeground(friColor);
        //第二个按钮
        musicBtn = new JButton("播放音乐");
        musicBtn.setPreferredSize(friDimension);
        musicBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        musicBtn.setForeground(sedColor);
        //按钮事件
        pictureBtn.addActionListener(this);
        musicBtn.addActionListener(this);
        //块内面板
        centerFristJpanelTop = new JPanel(new FlowLayout());
        centerFristJpanelTop.add(pictureBtn);
        centerFristJpanelTop.add(musicBtn);
        imgPanel = new JPanel();
        bgLabel1 = new JLabel();
        jPanel1.add(bgLabel1, BorderLayout.CENTER);
        jPanel1.add(centerFristJpanelTop, BorderLayout.NORTH);

        //Center块面板与布局第二块面板
        // 活动倒计时的时间代码块
        //ActionTime actionTime = new ActionTime();
        //actionTime.setTime(timeLabel);
        //actionTime.start();
        JPanel jPanel2 = new JPanel();
        jPanel2.setLayout(new GridLayout(2, 1, 10, 10));
        //2-1-1面板
        fristJpanel = new JPanel(new GridLayout());
        JLabel pictureJLabel = new JLabel();
        URL url = BookFrame.class.getResource("/img/book.jpg");
        Icon icon = new ImageIcon(url);
        pictureJLabel.setIcon(icon);
        pictureJLabel.setToolTipText("鸟类的天赋");
        pictureJLabel.setBackground(new Color(102, 200, 100));
        pictureJLabel.setHorizontalAlignment(SwingConstants.CENTER);
        pictureJLabel.setOpaque(true);
        pictureJLabel.setBounds(0, 0, 1000, 100);
        //2-1-2面板
        JPanel jPanel = new JPanel(new BorderLayout());
        jPanel.setBackground(new Color(12, 12, 12));
        JLabel jLabel = new JLabel("  最新图书");
        jLabel.setForeground(new Color(245, 127, 23));
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 22));
        fristJpanel2 = new JPanel(new FlowLayout());
        jPanel.add(jLabel, BorderLayout.NORTH);
        jPanel.add(jPanel2, BorderLayout.CENTER);
        titleLabel = new JLabel("         鸟类的天赋            ");
        titleLabel.setFont(bookFont);
        seeBtn = new JButton("阅读");
        downBtn = new JButton("下载");
        seeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        downBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeBtn.setPreferredSize(sedDimension);
        downBtn.setPreferredSize(sedDimension);
        seeBtn.setFont(btnFont);
        downBtn.setFont(btnFont);
        seeBtn.setForeground(seeColor);
        downBtn.setForeground(dowmColor);
        seeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                MyJDialog dialog = new MyJDialog(BookFrame.this);
                dialog.setVisible(true);
                jLabel00 = new JLabel("查看了《鸟类的天赋》");


            }
        });
        downBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取时间
                SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                String date = format.format(new Date());
                System.out.println(date);
                //创建文件呢
                File file1 = new File("D:\\" + date);
                if (!file1.exists()) {
                    try {
                        file1.createNewFile();
                    } catch (IOException e1) {
                        System.out.println("文件创建异常");
                    }
                }
                try {
                    FileOutputStream fileOutputStream = new FileOutputStream(file1);
                    String url = "https://book.douban.com/review/9565721/";
                    Connection connection = Jsoup.connect(url);
                    Document document = null;
                    try {
                        document = connection.get();
                    } catch (IOException e1) {
                        System.out.println("文件异常");
                    }
                    Elements elements = document.getElementsByClass("main-bd");
                    for (Element element : elements) {
                        Element link = element;
                        String titleString = link.text();
                        try {
                            byte[] bytes = titleString.getBytes();
                            fileOutputStream.write(bytes);
                            fileOutputStream.close();
                            System.out.println("下载成功!");
                            JOptionPane.showMessageDialog(null, "下载成功!");
                        } catch (IOException e1) {
                            System.out.println("IO异常");

                        }
                    }
                } catch (FileNotFoundException e1) {
                    System.out.println("文件输入输出异常");
                }

            }
        });
        fristJpanel2.add(titleLabel);
        fristJpanel2.add(seeBtn);
        fristJpanel2.add(downBtn);
        fristJpanel.add(pictureJLabel);
        fristJpanel.add(fristJpanel2);
        jPanel2.add(fristJpanel);

        //2-2-1
        secondJpanel = new JPanel(new GridLayout());
        JLabel pictureJLabel2 = new JLabel();
        URL url2 = BookFrame.class.getResource("/img/book1.jpg");
        Icon icon2 = new ImageIcon(url2);
        pictureJLabel2.setIcon(icon2);
        pictureJLabel2.setToolTipText("奥丽芙·基特里奇");
        pictureJLabel2.setBackground(new Color(102, 200, 100));
        pictureJLabel2.setHorizontalAlignment(SwingConstants.CENTER);
        pictureJLabel2.setOpaque(true);
        pictureJLabel2.setBounds(0, 0, 1000, 100);
        secondJpanel2 = new JPanel(new FlowLayout());
        titleLabel = new JLabel("       奥丽芙·基特里奇      ");
        titleLabel.setFont(bookFont);
        seeBtn = new JButton("阅读(付费)");
        seeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                monJD monJD1 = new monJD(BookFrame.this);
                monJD1.setVisible(true);
            }
        });
        downBtn = new JButton("下载");
        downBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(jPanel2, "抱歉！你还没有权限下载！");
            }
        });
        downBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeBtn.setPreferredSize(sedDimension);
        downBtn.setPreferredSize(sedDimension);
        seeBtn.setFont(btnFont);
        downBtn.setFont(btnFont);
        seeBtn.setForeground(seeColor);
        downBtn.setForeground(dowmColor);
        secondJpanel2.add(titleLabel);
        secondJpanel2.add(seeBtn);
        secondJpanel2.add(downBtn);
        secondJpanel.add(pictureJLabel2);
        secondJpanel.add(secondJpanel2);
        jPanel2.add(secondJpanel);
        //2-3-1
        thridJpanel = new JPanel(new GridLayout());
        JLabel pictureJLabel3 = new JLabel();
        URL url3 = BookFrame.class.getResource("/img/book2.jpg");
        Icon icon3 = new ImageIcon(url3);
        pictureJLabel3.setIcon(icon3);
        pictureJLabel3.setToolTipText("情书");
        pictureJLabel3.setBackground(new Color(102, 200, 100));
        pictureJLabel3.setHorizontalAlignment(SwingConstants.CENTER);
        pictureJLabel3.setOpaque(true);
        pictureJLabel3.setBounds(0, 0, 1000, 100);
        thridJpanel2 = new JPanel(new FlowLayout());
        titleLabel = new JLabel("         情书           ");
        titleLabel.setFont(bookFont);
        seeBtn = new JButton("阅读");
        downBtn = new JButton("下载");
        seeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        downBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        seeBtn.setPreferredSize(sedDimension);
        downBtn.setPreferredSize(sedDimension);
        seeBtn.setFont(btnFont);
        downBtn.setFont(btnFont);
        seeBtn.setForeground(seeColor);
        downBtn.setForeground(dowmColor);
        thridJpanel2.add(titleLabel);
        thridJpanel2.add(seeBtn);
        thridJpanel2.add(downBtn);
        thridJpanel.add(pictureJLabel3);
        thridJpanel.add(thridJpanel2);
        jPanel2.add(thridJpanel);

        //2-4-1
        fourJpanel = new JPanel(new GridLayout());
        JLabel pictureJLabel4 = new JLabel();
        URL url4 = BookFrame.class.getResource("/img/book3.jpg");
        Icon icon4 = new ImageIcon(url4);
        pictureJLabel4.setIcon(icon4);
        pictureJLabel4.setToolTipText("雨季不再来");
        pictureJLabel4.setBackground(new Color(102, 200, 100));
        pictureJLabel4.setHorizontalAlignment(SwingConstants.CENTER);
        pictureJLabel4.setOpaque(true);
        pictureJLabel4.setBounds(0, 0, 1000, 100);
        fourJpanel2 = new JPanel(new FlowLayout());
        titleLabel = new JLabel("          雨季不再来           ");
        titleLabel.setFont(bookFont);
        seeBtn = new JButton("阅读");
        seeBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        downBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        downBtn = new JButton("下载");
        seeBtn.setPreferredSize(sedDimension);
        downBtn.setPreferredSize(sedDimension);
        seeBtn.setFont(btnFont);
        downBtn.setFont(btnFont);
        seeBtn.setForeground(seeColor);
        downBtn.setForeground(dowmColor);
        fourJpanel2.add(titleLabel);
        fourJpanel2.add(seeBtn);
        fourJpanel2.add(downBtn);
        fourJpanel.add(pictureJLabel4);
        fourJpanel.add(fourJpanel2);
        jPanel2.add(fourJpanel);

        //Center块面板与布局第三块面板
        JPanel jPanel3 = new JPanel();
        jPanel3.setLayout(new BorderLayout());
        //topTitle
        JPanel topJpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel titlejpanel1 = new JLabel("  最受欢迎的书评");
        titlejpanel1.setForeground(new Color(245, 127, 23));
        titlejpanel1.setFont(title2Font);
        Color color1 = new Color(26, 35, 126);
        Font font1 = new Font("微软雅黑", Font.BOLD, 16);
        Color color2 = new Color(238, 238, 238);
        JButton titleBtn1 = new JButton("豆瓣更多热门书评");
        titleBtn1.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        URL url5 = BookFrame.class.getResource("/img/gengduo.png");
        Icon icon5 = new ImageIcon(url5);
        titleBtn1.setIcon(icon5);
        titleBtn1.setBorderPainted(false);
        titleBtn1.setBackground(color2);
        titleBtn1.setForeground(color1);
        titleBtn1.setFont(font1);
        titleBtn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URI uri;
                {
                    try {
                        uri = new URI("https://book.douban.com/review/best/");
                        desktop.browse(uri);
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });

        JButton titleBtn2 = new JButton("最新书评");
        titleBtn2.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        URL url6 = BookFrame.class.getResource("/img/gengduo.png");
        Icon icon6 = new ImageIcon(url6);
        titleBtn2.setIcon(icon6);
        titleBtn2.setBackground(color2);
        titleBtn2.setForeground(color1);
        titleBtn2.setFont(font1);
        titleBtn2.setBorderPainted(false);
        titleBtn2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URI uri;
                {
                    try {
                        uri = new URI("https://book.douban.com/review/latest/");
                        desktop.browse(uri);
                        System.out.println();
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        topJpanel.add(titlejpanel1);
        topJpanel.add(titleBtn1);
        topJpanel.add(titleBtn2);
        //center
        JPanel cenJpanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
//        cenJpanel.setBackground(new Color(12,12,12));
//        JScrollPane cenJpanel = new JScrollPane();
        JPanel useJpanel = new JPanel(new FlowLayout());
        JPanel erjiJpanel = new JPanel(new GridLayout(2, 1, 0, 0));
        URL url7 = BookFrame.class.getResource("/img/first.jpg");
        Icon icon7 = new ImageIcon(url7);
        JLabel jLabel1 = new JLabel(icon7);
        jLabel1.setToolTipText("记忆尝试");
        JLabel jLabel2 = new JLabel("  记 忆 尝 试");
        jLabel2.setFont(titleFont);
        JTextArea jTextArea = new JTextArea("人类对脑科学一直在探索，医学发展至今，虽然攻克了许许多多的问题，但对大脑的研究依然属于雾里看花，一知半解。大脑是生活中我们每个人都随时使用的，比如辨别方向、学习、工作等等，这些都必然要使用到大脑的");
        jTextArea.setLineWrap(true);
        jTextArea.setFont(title3Font);
        jTextArea.setBackground(new Color(238, 238, 238));
        jTextArea.setSize(600, 200);
        erjiJpanel.add(jLabel2);
        erjiJpanel.add(jTextArea);
        useJpanel.add(jLabel1);
        useJpanel.add(erjiJpanel);
        cenJpanel.add(useJpanel);

        JPanel useJpanel1 = new JPanel(new FlowLayout());
        JPanel erjiJpanel1 = new JPanel(new GridLayout(2, 1, 0, 0));
        URL url8 = BookFrame.class.getResource("/img/second.jpg");
        Icon icon8 = new ImageIcon(url8);
        JLabel jLabel3 = new JLabel(icon8);
        jLabel3.setToolTipText("简爱");
        JLabel jLabel5 = new JLabel("   简  爱 ");
        jLabel5.setFont(titleFont);
        JTextArea jTextArea3 = new JTextArea("在前一段时间，我看到好多友邻都在探讨国内外名著的“三观”问题，当我看到这一话题时，第一个反应就是《简·爱》这部小说肯定会中枪，点开相关的帖子和话题一看，《简·爱》的“三观”讨论果然名列前茅。");
        jTextArea3.setLineWrap(true);
        jTextArea3.setBackground(new Color(238, 238, 238));
        jTextArea3.setSize(600, 200);
        jTextArea3.setFont(title3Font);
        useJpanel1.add(jLabel3);
        erjiJpanel1.add(jLabel5);
        erjiJpanel1.add(jTextArea3);
        useJpanel1.add(erjiJpanel1);
        cenJpanel.add(useJpanel1);

        JPanel eastJpanel = new JPanel(new BorderLayout());
        JPanel east1Jpanel = new JPanel(new FlowLayout());
        JLabel jLabel0 = new JLabel("历史纪录                           ");
        jLabel0.setFont(new Font("微软雅黑", Font.BOLD, 14));
        JLabel IconJlabel = new JLabel();
        URL url9 = BookFrame.class.getResource("/img/lishi.png");
        Icon icon9 = new ImageIcon(url9);
        IconJlabel.setIcon(icon9);
        east1Jpanel.add(jLabel0);
        east1Jpanel.setBackground(new Color(189, 189, 189));
        east1Jpanel.add(IconJlabel);
        eastJpanel.add(east1Jpanel, BorderLayout.NORTH);


        eastJpanel.setBackground(new Color(224, 224, 224));
        jPanel3.add(topJpanel, BorderLayout.NORTH);
        jPanel3.add(cenJpanel, BorderLayout.CENTER);
        jPanel3.add(eastJpanel, BorderLayout.EAST);

        //Center块面板与布局第四块面板
        JPanel jPanel4 = new JPanel(new BorderLayout());
        JTextArea textArea4 = new JTextArea("  请君留下精彩书评!");
//        textArea4.setToolTipText("记录你这一刻精彩书评");
        textArea4.setFont(textAreaFont);
        textArea4.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getButton() == MouseEvent.BUTTON1) {
                    textArea4.setText("");
                }
            }

        });
        textArea4.setLineWrap(true);
        textArea4.setForeground(new Color(25, 118, 210));
        JLabel jLabel4 = new JLabel("   读书笔记");
        jPanel4.setBackground(new Color(12, 12, 12));
        jLabel4.setForeground(new Color(245, 127, 23));
        jLabel4.setFont(title2Font);
        JPanel btnjPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JLabel jLabelblok1 = new JLabel("            ");
        JLabel jLabelblok2 = new JLabel("            ");
        upJButton = new JButton(" 上 传 ");
        saveJButton = new JButton(" 保 存 ");
        shareJButton = new JButton(" 分 享 ");
        upJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        saveJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        shareJButton.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        upJButton.setFont(titleFont);
        saveJButton.setFont(titleFont);
        shareJButton.setFont(titleFont);
        upJButton.setBackground(upColor);
        saveJButton.setBackground(saveColor);
        shareJButton.setBackground(shareColor);
        upJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UpJpanel upJpanel = new UpJpanel(BookFrame.this);
                upJpanel.setVisible(true);
            }
        });
        saveJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "该区块正在开发,敬请期待！");
            }
        });
        shareJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shareJDialog shareJDialog = new shareJDialog(BookFrame.this);
                shareJDialog.setVisible(true);
            }
        });

        jPanel4.add(jLabel4, BorderLayout.NORTH);
        jPanel4.add(textArea4, BorderLayout.CENTER);
        btnjPanel.add(upJButton);
        btnjPanel.add(jLabelblok1);
        btnjPanel.add(saveJButton);
        btnjPanel.add(jLabelblok2);
        btnjPanel.add(shareJButton);
        jPanel4.add(btnjPanel, BorderLayout.SOUTH);
        //中间主面板的加载
        c.add(jPanel1);
        c.add(jPanel);
        c.add(jPanel3);
        c.add(jPanel4);

        //South部分的设计
        southBtn = new JButton("退出");
        southBtn.setBorderPainted(false);
        southBtn.setBackground(new Color(0,145,234));
        southBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        southBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int n = JOptionPane.showConfirmDialog(null, "确认退出吗?", "确认对话框", JOptionPane.YES_NO_OPTION);
                if (n == JOptionPane.YES_OPTION) {
                    System.exit(0);
                } else if (n == JOptionPane.NO_OPTION) {
                }
            }
        });

        //系统时间代码块
        timeLabel = new JLabel();
        timeLabel.setFont(timeFont);
        TimeThread3 timeThread = new TimeThread3();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
        northPanel.add(timeLabel);

        //主面板设置
        add(northPanel, BorderLayout.NORTH);
        add(c, BorderLayout.CENTER);
        add(southBtn, BorderLayout.SOUTH);
    }

    public static void main(String[] args) {
        new BookFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        //图片选择按钮
        if (e.getSource() == pictureBtn) {
            System.out.println("1");
            JLabel imgLabel = new JLabel();
            imgPanel.add(imgLabel);
            PictureThread ct = new PictureThread();
            ct.setBgLabel(bgLabel1);
            new Thread(ct).start();
        }
        //音乐按钮
        if (e.getSource() == musicBtn) {
            bjmusic bjmusic = new bjmusic();
            new Thread(bjmusic).start();
        }
    }
}

//音乐部分
class bjmusic implements Runnable {
    @Override
    public void run() {
        URL url;
        File file = new File("D:/yy/Dream1.wav");
        int i = 1;
        while (i >= 1) {
            try {
                url = file.toURL();
                AudioClip audioClip = Applet.newAudioClip(url);
                audioClip.play();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            i--;
        }
    }
}

//阅读界面部分
class MyJDialog extends JDialog {
    public MyJDialog(BookFrame frame) {
        super(frame, "阅 读 窗 口", true);
        Container container = getContentPane();
        String url = "https://book.douban.com/review/9565721/";
        Connection connection = Jsoup.connect(url);
        Document document = null;
        try {
            document = connection.get();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Elements elements = document.getElementsByClass("main-bd");
        for (Element element : elements) {
            Element link = element;
            String titleString = link.text();
            JTextArea jTextArea = new JTextArea(String.valueOf(titleString));
//            container.add(jTextArea);
            jTextArea.setLineWrap(true);
            jTextArea.setFont(new Font("宋体", Font.BOLD, 24));
            JScrollPane jScrollPane = new JScrollPane(jTextArea);
            jScrollPane.setBounds(0, 0, 1000, 1000);
            container.add(jScrollPane);
//            setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
            System.out.println(titleString);
        }
        setBounds(663, 60, 550, 900);
    }
}

//分享界面
class shareJDialog extends JFrame {
    public shareJDialog(BookFrame frame) {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        setBounds(650, 220, 653, 433);
        ShareJD shareJD = new ShareJD();
        shareJD.setBounds(100, 100, 100, 100);
        JPanel shareJPanel = new JPanel();
        shareJPanel.setLayout(null);
        //标题部分
        JLabel tiJLabel = new JLabel("快和你的小伙伴一起分享吧！");
        tiJLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        tiJLabel.setForeground(new Color(65, 105, 225));
        shareJD.add(tiJLabel);


        //美化用
        JButton testBtn = new JButton("");
        testBtn.setBounds(0, 0, 1, 1);
        shareJPanel.add(testBtn);
        Color btnColor = new Color(238, 238, 238);
        Font txtFont = new Font("微软雅黑", Font.BOLD, 18);
        //第一块
        URL url1 = BookFrame.class.getResource("/img/weixin.png");
        Icon icon1 = new ImageIcon(url1);
        JButton firBtn = new JButton();
        firBtn.setBorderPainted(false);
        firBtn.setBackground(btnColor);
        firBtn.setBounds(130, 100, 60, 60);
        firBtn.setIcon(icon1);
        firBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        firBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URI uri;
                {
                    try {
                        uri = new URI("https://wx.qq.com/");
                        desktop.browse(uri);
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        JLabel firJLabel = new JLabel("朋  友  圈");
        firJLabel.setFont(txtFont);
        firJLabel.setBounds(120, 160, 100, 40);
        shareJPanel.add(firJLabel);
        shareJPanel.add(firBtn);
        //第二块
        URL url2 = BookFrame.class.getResource("/img/qq.png");
        Icon icon2 = new ImageIcon(url2);
        JButton sedBtn = new JButton();
        sedBtn.setBorderPainted(false);
        sedBtn.setBackground(btnColor);
        sedBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        sedBtn.setBounds(280, 100, 60, 60);
        sedBtn.setIcon(icon2);
        sedBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URI uri;
                {
                    try {
                        uri = new URI("http://im.qq.com/pcqq/");
                        desktop.browse(uri);
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        JLabel sedJLabel = new JLabel("QQ 好  友");
        sedJLabel.setFont(txtFont);
        sedJLabel.setBounds(270, 160, 100, 40);
        shareJPanel.add(sedJLabel);
        shareJPanel.add(sedBtn);
        //第三块
        URL url3 = BookFrame.class.getResource("/img/weibo.png");
        Icon icon3 = new ImageIcon(url3);
        JButton thiBtn = new JButton();
        thiBtn.setBorderPainted(false);
        thiBtn.setBackground(btnColor);
        thiBtn.setBounds(430, 100, 60, 60);
        thiBtn.setIcon(icon3);
        thiBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        thiBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Desktop desktop = Desktop.getDesktop();
                URI uri;

                {
                    try {
                        uri = new URI("https://weibo.com/signup/signup.php");
                        desktop.browse(uri);
                    } catch (URISyntaxException e1) {
                        e1.printStackTrace();
                    } catch (IOException e2) {
                        e2.printStackTrace();
                    }
                }
            }
        });
        JLabel thiJLabel = new JLabel("微    博");
        thiJLabel.setFont(txtFont);
        thiJLabel.setBounds(430, 160, 100, 40);
        shareJPanel.add(thiJLabel);
        shareJPanel.add(thiBtn);
        container.add(shareJD, BorderLayout.NORTH);
        container.add(shareJPanel, BorderLayout.CENTER);
    }
}

//收费界面
class monJD extends JFrame {
    public monJD(BookFrame frame) {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        JLabel jLabel1 = new JLabel("本书收费");
        jLabel1.setForeground(new Color(255, 20, 147));
        jLabel1.setFont(new Font("微软雅黑", Font.BOLD, 26));
        JLabel jLabel = new JLabel("价格：￥8.8/本");
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 26));
        JPanel tijpanel = new JPanel(new FlowLayout());
        tijpanel.add(jLabel1);
        tijpanel.add(jLabel);

        JPanel jp = new JPanel(new FlowLayout());
        JLabel jLabel2 = new JLabel("亲！你还没有登录哦！");
        jLabel2.setFont(new Font("微软雅黑", Font.BOLD, 20));
        jp.add(jLabel2);

        JPanel cenJpanel = new JPanel(new FlowLayout());
        Color cenColor = new Color(3, 155, 229);
        Color cen1Color = new Color(255, 255, 255);
        Font font = new Font("微软雅黑", Font.BOLD, 22);
        JButton dengBtn = new JButton("登录");
        JButton zhuceBtn = new JButton("注册");
        dengBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        zhuceBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        dengBtn.setBackground(cenColor);
        zhuceBtn.setBackground(cenColor);
        dengBtn.setForeground(cen1Color);
        zhuceBtn.setForeground(cen1Color);
        dengBtn.setFont(font);
        zhuceBtn.setFont(font);
        dengBtn.setBorderPainted(false);
        zhuceBtn.setBorderPainted(false);
        cenJpanel.add(dengBtn);
        cenJpanel.add(zhuceBtn);

        container.add(tijpanel, BorderLayout.NORTH);
        container.add(jp, BorderLayout.CENTER);
        container.add(cenJpanel, BorderLayout.SOUTH);
        setBounds(700, 300, 468, 220);
    }
}

//上传界面
class UpJpanel extends JFrame {
    public UpJpanel(BookFrame frame) {
        Container container = getContentPane();
        container.setLayout(new BorderLayout());
        Color cenColor = new Color(3, 155, 229);
        Color cen1Color = new Color(255, 255, 255);
        Font font = new Font("微软雅黑", Font.BOLD, 22);
        JLabel jLabel = new JLabel("确认上传吗？");
        JPanel jPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        jPanel1.add(jLabel);
        jLabel.setFont(new Font("微软雅黑", Font.BOLD, 24));
        JButton conjButton = new JButton("确认");
        JButton canjButton = new JButton("取消");
        conjButton.setFont(font);
        canjButton.setFont(font);
        conjButton.setBackground(cenColor);
        canjButton.setBackground(cenColor);
        conjButton.setForeground(cen1Color);
        canjButton.setForeground(cen1Color);
        conjButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(conjButton, "上传成功！");
            }
        });
        canjButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        JPanel jPanel = new JPanel();
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        jPanel.add(conjButton);
        jPanel.add(canjButton);
        container.add(jPanel1, BorderLayout.CENTER);
        container.add(jPanel, BorderLayout.SOUTH);

        setTitle("上传提示！");
        setBounds(700, 300, 468, 170);
    }
}
