package week1;

import javafx.scene.paint.Color;

import javax.swing.*;

public class TrafficLifte extends JFrame{
//    private static Color[] colors =
    public TrafficLifte(){
        init();
        setTitle("交通信号灯");
        setSize(900, 600);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void  init(){


    }

    public static void main(String[] args) {
        new TrafficLifte();
    }
}
