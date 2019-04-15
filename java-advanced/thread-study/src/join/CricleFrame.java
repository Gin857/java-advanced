package join;


import javax.swing.*;
import java.awt.*;

/**
 * Timer 运用
 * author xupeng
 * 2019.4.15
 */
public class CricleFrame extends JFrame {
    private  JLabel txtLabel;
    public CricleFrame() {
        init();
        setTitle("Timer 同心圆与文本");
        setSize(750, 800);
        setVisible(true);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

    }

    public void init() {
            txtLabel = new JLabel();
            Font font = new Font("微软雅黑",Font.BOLD,20);
            txtLabel.setFont(font);
            //文本加载线程
            TxtThread thread = new TxtThread();
            thread.setTxtLabel(txtLabel);
            new Thread(thread).start();
            //同心圆线程
            CircleThread circleThread = new CircleThread();
            circleThread.setFrame(this);
            new Thread(circleThread).start();

            add(txtLabel);

    }

    public static void main(String[] args) {
        new CricleFrame();
    }
}
