package zonghe2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class Button1Thread extends Thread {
    private JButton jButton1;
    public void setjButton1Thread(JButton buttonThread) {
        this.jButton1 = buttonThread;
    }

    @Override
    public void run() {
        while (true){
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(255);
            int b = random.nextInt(255);
            jButton1.setBackground(new Color(r, g, b));
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
