package test;

import javax.swing.*;
import java.awt.*;
import java.util.TimerTask;


public class Circles extends JFrame {
    public Circles() {
        init();
        setTitle("图片窗口");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
    }

    private void init() {
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                for (int i = 1; i < Math.PI * 2 * i; i++) {
                    System.out.println();
                }
            }
        };
    }

    public static void main(String[] argv) {
        new Circles();
    }

    public void paint(Graphics g) {
        g.drawString("Circle 9", 20, 20);
        int x0 = getSize().width / 2;
        int y0 = getSize().height / 2;
        for (int r = 0; r < getSize().height / 2; r += 20) {
            g.drawOval(x0 - r, y0 - r, r * 2, r * 2);
        }
    }
}

