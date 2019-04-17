package timer;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 闹钟界面
 * @author 徐鹏
 * 2019.4.16
 */
public class TimerClock extends JFrame {
    private JPanel jPanel;
    private JLabel jLabel;
    private TimerTask  clockTask;
    private Timer timer;

    public TimerClock(){
        init();
        setTitle("闹钟~~~");
        setSize(611, 392);
        setLocation(1309,660);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void init(){
         jPanel = new JPanel(){
            protected  void  paintComponent(Graphics g){
                try {
                    Image bg = ImageIO.read(new File("D:/space/snow1.jpg"));
                    g.drawImage(bg,0,0,getWidth(),getHeight(),null);
                    System.out.println();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        };
        jPanel.setLayout(new FlowLayout(FlowLayout.CENTER,10,30));
        add(jPanel);

        Font font = new Font("微软雅黑",Font.PLAIN,28);
        jLabel = new JLabel();
        jLabel.setFont(font);
        jLabel.setForeground(new Color(22,2,222));
        clockTask = new TimerTask() {
            @Override
            public void run() {
                Date date = new Date();
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                String timeString = sdf.format(date);
                jLabel.setText(timeString);
                jPanel.add(jLabel);
                System.out.println();
                if(timeString.equals("2019-04-16 09:21:00")){
                    JOptionPane.showMessageDialog(jPanel, "早上好！酒儿.");
                    this.cancel();
                }
            }
        };

        timer = new Timer();
        timer.scheduleAtFixedRate(clockTask, 0, 1000);
    }

    public static void main(String[] args) {
        new TimerClock();
    }
}
