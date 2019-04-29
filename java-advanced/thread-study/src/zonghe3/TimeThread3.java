package zonghe3;


import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TimeThread3 extends Thread{
    private JLabel timeLabel;
    public void setTimeLabel(JLabel timeLabel){
        this.timeLabel = timeLabel;
    }
    @Override
    public void run(){
        while (true){
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("       \u2605   爱   \u2605   读   \u2605   书   \u2605"+
                    "                  " +
                    "                                hh:mm  yyyy/MM/dd");
                                                                   //
            timeLabel.setText(String.valueOf(simpleDateFormat.format(date)));
            try {
                Thread.sleep(10000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
