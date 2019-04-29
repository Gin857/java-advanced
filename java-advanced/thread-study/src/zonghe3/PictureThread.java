package zonghe3;


import javax.swing.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class PictureThread implements Runnable {
    private JLabel bgLabel1;
    private JFileChooser fileChooser;

    public void setBgLabel(JLabel bgLabel1) {
        this.bgLabel1 = bgLabel1;
    }

    @Override
    public void run() {
        fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File("D:\\space"));
        fileChooser.setMultiSelectionEnabled(true);
        int result = fileChooser.showOpenDialog(null);
        if (result == JFileChooser.APPROVE_OPTION) {
            //获取选中的所有文件
            File[] files = fileChooser.getSelectedFiles();
            int i = 0;
            int len = files.length;
            while (true) {
                try {
                    //通过路径选择构建File对象
                    File file = new File(String.valueOf(files[i]));
                    InputStream inputStream = new FileInputStream(file);
                    byte[] bytes = new byte[(int) file.length()];
                    inputStream.read(bytes);
                    Icon icon = new ImageIcon(bytes);
                    bgLabel1.setIcon(icon);
//                    System.out.println(icon);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    i++;
                    if (i == len) {
                        i = 0;
                    }
                } catch (IOException e) {
                    System.out.println("IO异常");
                }
            }
        }
    }
}
