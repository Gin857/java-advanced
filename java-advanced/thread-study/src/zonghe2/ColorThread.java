package zonghe2;

import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class ColorThread extends Thread {
    private JPanel colorJPanel;

    public void setColorJPanel(JPanel colorJPanel) {
        this.colorJPanel = colorJPanel;
    }

    @Override
    public void run() {
        while (true) {
            Random random = new Random();
            int r = random.nextInt(256);
            int g = random.nextInt(256);
            int b = random.nextInt(256);
            colorJPanel.setBackground(new Color(r, g, b));
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
