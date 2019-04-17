package join;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class TimeDao extends JFrame {
    private JLabel timeJLabel;
    private JPanel  timeJPanel;

    public TimeDao() {
        init();
        setTitle("倒计时");
        setSize(414, 213);
        setLocation(750, 200);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    public void init() {

        ImgPanel1 imgPanel1 = new ImgPanel1();
        imgPanel1.setImgPath("jd1.jpg");
        timeJLabel = new JLabel();
        timeJPanel = new JPanel();
        Font font = new Font("宋体", Font.BOLD, 28);
        timeJLabel.setFont(font);

        Time1 time1 = new Time1();
        time1.setTime(timeJLabel);
        time1.start();

        timeJPanel.add(timeJLabel);
        imgPanel1.add(timeJPanel);
        add(imgPanel1);

    }

    public static void main(String[] args) {
        new TimeDao();
    }
}

class Time1 extends Thread implements Runnable {
    private JLabel timeJlabel;

    public void setTime(JLabel timeJlabel) {
        this.timeJlabel = timeJlabel;
    }

    @Override
    public void run() {
        while (true) {

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            long timenow = date.getTime();
            timenow = 60 * 60 * 1000 - timenow;
            date = new Date(timenow);
            timeJlabel.setText(sdf.format(date));
            if (sdf.format(date).equals("20:15:25")) {
                JOptionPane.showMessageDialog(timeJlabel, "本场活动现在开始！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("1");
                }
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("1");
            }
        }
    }
}

class ImgPanel1 extends JPanel{
    private String imgPath;

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    @Override
    protected void paintComponent(Graphics g) {
        String basePath = System.getProperty("user.dir");
        Image bg = null;
        try {
            bg = ImageIO.read(new File(basePath + "/thread-study/src/img/" + imgPath));
        } catch (IOException e) {
            e.printStackTrace();
        }
        g.drawImage(bg, 0, 0, getWidth(), getHeight(), this);
    }
}


