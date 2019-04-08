package zonghe2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ButtonThread extends Thread {
    private JButton jButton;

    public void setButtonThread(JButton buttonThread) {
        this.jButton = buttonThread;
    }

    @Override
    public void run() {
        while (true){
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(255);
            int b = random.nextInt(256);
            jButton.setBackground(new Color(r, g, b));
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
