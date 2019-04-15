package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

public class TxtTest {
    public static void main(String[] args) throws IOException {
        File file = new File("D:\\yy\\wen.txt");
        FileInputStream fileInputStream = new FileInputStream(file);
        byte[] bytes = new byte[(int) file.length()];
        fileInputStream.read(bytes);
        String s = new String(bytes);
        for(int i = 0, len = bytes.length; i < len; i++){
            try {
                Thread.sleep(500);
                System.out.print(s.charAt(i));
            }catch (Exception e){
                System.out.print("输出异常");
            }
        }

    }
}
