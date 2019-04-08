package zonghe2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class LThread extends Thread {
    private JPanel lJPanel;
    public void setlJPanel(JPanel lJPanel) {
        this.lJPanel = lJPanel;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(255);
            lJPanel.setBackground(new Color(r, g, b));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
