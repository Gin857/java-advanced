package zonghe3;


import javax.swing.*;
import java.awt.*;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;

public class ShareJD extends JPanel{
    public ShareJD(){
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
        Color color1 = new Color(204,255,144);
        Color color2 = new Color(255,241,118);
        Color color3 = new Color(0,229,255);
        Color[] color = {color1,color2,color3};
        Random r = new Random();
        int i = r.nextInt(2);
        int j = r.nextInt(3);
        //创建填充模式对象
        GradientPaint paint = new GradientPaint(i, j, color[i], 0, height,color[j]);
        g.setPaint(paint);
        g.fillRect(i, j, width, height);
    }
}
