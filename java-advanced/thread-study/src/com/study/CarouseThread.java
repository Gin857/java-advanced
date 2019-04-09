package com.study;

import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class CarouseThread implements Runnable {
    private  String[] imgs= {"D:/space/1.jpg","D:/space/2.jpg","D:/space/3.jpg","D:/space/4.jpg","D:/space/5.jpg"};
    private JLabel bgLabel;

    public void setBjLabel (JLabel bgLabel){
        this.bgLabel =bgLabel;
    }
    @Override
    public void run() {
        int i = 0;
        int len =imgs.length -1;
        while (true){
            try {
                File file = new File(imgs[i]);
                InputStream inputStream = new FileInputStream(file);
                byte[] bytes = new byte[(int) file.length()];
                inputStream.read(bytes);
                Icon icon = new ImageIcon(bytes);
                bgLabel.setIcon(icon);
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                i++;
                if (i==len){
                    i=0;
                }
            }catch (IOException e ){
                System.out.println("io异常");
            }
        }
    }
}
