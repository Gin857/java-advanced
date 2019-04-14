package week1;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;
import java.awt.FlowLayout;

public class TraficLights extends JFrame {
    private JPanel contentPane;
    private JLabel lblImage;

    public TraficLights() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(250,200);
        setTitle("交通信号灯");
        contentPane = new JPanel();
        contentPane.setBackground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
        setContentPane(contentPane);
        JPanel imagePane = new JPanel();
        imagePane.setBackground(Color.WHITE);
        imagePane.setBorder(new TitledBorder(null, "", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        contentPane.add(imagePane);
        imagePane.setLayout(new BorderLayout(0, 0));
        lblImage = new JLabel("");
        lblImage.setBackground(Color.WHITE);
        lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/2.jpg")));
        imagePane.add(lblImage, BorderLayout.CENTER);

        Thread thread = new TurnColor(lblImage);
        thread.start();
    }


    public static void main(String[] args) {
        TraficLights frame = new TraficLights();
        frame.setVisible(true);
    }
}

class TurnColor extends Thread {
    private JLabel lblImage;

    public TurnColor(JLabel lblImage) {
        this.lblImage = lblImage;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/1.jpg")));
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/2.jpg")));
            try {
                Thread.sleep(8000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lblImage.setIcon(new ImageIcon(TraficLights.class.getResource("/img/3.jpg")));
        }
    }
}