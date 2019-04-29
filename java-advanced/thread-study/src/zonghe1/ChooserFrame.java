package zonghe1;

import javax.swing.*;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * 线程土图片查看器
 *
 * @author 徐鹏
 * 2019.4.9
 */
public class ChooserFrame extends JFrame implements ActionListener {
    private JButton chooserBtn, musicBtn, timeBtn;
    private JLabel bgLabel, timeLabel;
    private JPanel imgPanel;
    private JPanel btnPanel;
    private JProgressBar progressBar;
    private JFileChooser fileChooser;


    private ChooserFrame() {
        init();
        setTitle("轮播窗体");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        //调用区
        bgLabel = new JLabel();
        timeLabel = new JLabel();
        chooserBtn = new JButton("唯美屏保");
        musicBtn = new JButton("动感音乐");
        timeBtn = new JButton();
        imgPanel = new JPanel();
        btnPanel = new JPanel();
        btnPanel.setLayout(new GridLayout(1, 3));
        //样式设置区
        Dimension dimension = new Dimension(180, 30);
        Font font = new Font("微软雅黑", Font.BOLD, 24);
        //添加区
        chooserBtn.setPreferredSize(dimension);
        musicBtn.setPreferredSize(dimension);
        chooserBtn.setFont(font);
        musicBtn.setFont(font);
        timeLabel.setFont(font);
        chooserBtn.addActionListener(this);
        musicBtn.addActionListener(this);
        timeBtn.addActionListener(this);
        timeBtn.add(timeLabel);
        //面板区
        //创建进度条
        final JProgressBar progressBar = new JProgressBar();
        getContentPane().add(progressBar, BorderLayout.SOUTH);
        progressBar.setBackground(new Color(220, 220, 220));
        progressBar.setForeground(new Color(0, 0, 255));
        progressBar.setStringPainted(true);
        progressBar.setIndeterminate(false);
        Thread thread = new Thread() {
            int count = 0;
            public void run() {
                while (true) {
                    progressBar.setValue(++count);
                    try {
                        if (count == 70) {
                            interrupt();
                        }
                        Thread.sleep(100);
                    } catch (InterruptedException e) {
                        JOptionPane.showMessageDialog(null,
                                "加载出错，请重新加载！！！", "界面提示",
                                JOptionPane.WARNING_MESSAGE);
                        System.out.println("当前线程被中断");
                        break;
                    }
                }
            }
        };
        thread.start();
//        add(imgPanel);
        btnPanel.add(chooserBtn);
        btnPanel.add(musicBtn);
        btnPanel.add(timeBtn);
        add(btnPanel, BorderLayout.NORTH);
        add(bgLabel, BorderLayout.CENTER);

        zonghe1.TimeThread timeThread = new TimeThread();
        timeThread.setTimeLabel(timeLabel);
        timeThread.start();
    }

    public static void main(String[] args) {
        new ChooserFrame();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == chooserBtn) {
            JLabel imgLabel = new JLabel();
            imgPanel.add(imgLabel);
            ChooserThread ct = new ChooserThread();
            ct.setBgLabel(bgLabel);
            new Thread(ct).start();
        }
        if (e.getSource() == musicBtn) {
            music music = new music();
            new Thread(music).start();
        }
        if (e.getSource() == timeBtn) {
            this.dispose();
        }
    }
}

class music implements Runnable {
    @Override
    public void run() {
        URL url;
        File file = new File("D:/yy/2.wav");
        int i = 1;
        while (i >= 1) {
            try {
                url = file.toURL();
                AudioClip audioClip = Applet.newAudioClip(url);
                audioClip.play();
                System.out.println();
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
