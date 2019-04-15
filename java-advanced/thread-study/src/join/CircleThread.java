package join;


import javax.swing.*;
import java.awt.*;
import java.util.Timer;
import java.util.TimerTask;

public class CircleThread implements Runnable {
    int x = 800;
    int y = 800;
    private JFrame frame;

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    @Override
    public void run() {
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i <= 15; i++) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    Graphics graphics = frame.getGraphics();
                    graphics.setColor(new Color(153,50,204));
                    graphics.drawOval(x / 2 - (i + 1) * 10,
                            y / 2 - (i + 1) * 10,
                            10 + 20 * i, 10 + 20 * i);
                }
            }
        };
        try {
            Timer timer = new Timer();
            timer.schedule(timerTask, 5, 1000);
        }catch (Exception e){
            System.out.println("-1");
        }
    }
}

