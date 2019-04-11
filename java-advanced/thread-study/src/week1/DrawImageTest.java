package week1;


import javax.swing.*;
import java.awt.*;

/**
 * 图像
 *
 * @author xupeng
 * 2019.3.10
 */
public class DrawImageTest extends JFrame {
    public DrawImageTest() {
        this.setSize(1000, 625);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        add(new CanvasTest());
        this.setTitle("绘制图像");
    }

    public static void main(String[] args) {
        new DrawImageTest().setVisible(true);
    }

    class CanvasTest extends Canvas {
        public void paint(Graphics g) {
            super.paint(g);
            Graphics2D g2 = (Graphics2D) g;
            Image img = new ImageIcon(this.getClass().getResource("/img/21.jpg")).getImage();
            g2.drawImage(img, 0, 0, this);
        }
    }
}
