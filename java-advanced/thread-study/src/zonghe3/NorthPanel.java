package zonghe3;


import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class NorthPanel extends JPanel{

    public NorthPanel(){
        Timer timer = new Timer();
        timer.schedule(timerTask,0,3000);
    }
    TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            repaint();
        }
    };
    @Override
    protected void paintComponent(Graphics g2) {
        Graphics2D g = (Graphics2D) g2;
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        Color[] color = {Color.GREEN,Color.ORANGE};
        Random r = new Random();
        int i = r.nextInt(1);
        int j = r.nextInt(2);
        GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
        g.setPaint(paint);
        g.fillRect(i, j, width, height);
    }
}
