package join;

import javax.swing.*;
import java.io.*;

public class TxtThread extends Thread {
    private JLabel txtLabel;
    public void setTxtLabel(JLabel txtLabel) {
        this.txtLabel = txtLabel;
    }

    @Override
    public void run() {
        File file = new File("D:\\yy\\wen.txt");
        InputStream inputStream = null;
        byte[] bytes = new byte[(int) file.length()];
        String s = new String(bytes);
        try {
            inputStream = new FileInputStream(file);
            inputStream.read(bytes);
        } catch (IOException e) {
            System.out.println("IO异常");
        }
        for (int i = 0, len = bytes.length; i < len; i++) {
            try {
                Thread.sleep(100);
//                txtLabel.setText(s.charAt(i));
            } catch (Exception e) {
                System.out.print("输出异常");
            }

            txtLabel.setText(new String(bytes));
        }
    }
}
