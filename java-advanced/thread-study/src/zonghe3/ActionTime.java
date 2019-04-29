package zonghe3;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActionTime extends Thread implements Runnable{
    private JLabel timejLabel;

    public void  setTime (JLabel timejLabel){
        this.timejLabel=timejLabel;
    }

    @Override
    public void run() {
        while (true) {

            Date date = new Date();
            SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
            long timenow = date.getTime();
            timenow = 60 * 60 * 1000 - timenow;
            date = new Date(timenow);
            timejLabel.setText(sdf.format(date));
            if (sdf.format(date).equals("20:15:25")) {
                JOptionPane.showMessageDialog(timejLabel, "本场活动现在开始！");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    System.out.println("线程异常");
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
