package zonghe2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class RThread extends Thread {
    private JPanel rJPanel;
    public void setrJPanel(JPanel rJPanel) {
        this.rJPanel = rJPanel;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int r = random.nextInt(255);
            int g = random.nextInt(256);
            int b = random.nextInt(255);
            rJPanel.setBackground(new Color(r, g, b));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
