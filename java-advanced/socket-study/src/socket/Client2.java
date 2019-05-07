package socket;

import java.io.*;
import java.net.Socket;

/**
 * 客户端
 * 2019.5.7
 */
public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket client =new Socket("127.0.0.1",10086);
        System.out.println("连接上服务器.....");
        File file = new File("D:/space/2.jpg");
        byte[] b = new byte[(int) file.length()];
        InputStream inputStream = new FileInputStream(file);
        inputStream.read(b);
        BufferedOutputStream bos = new BufferedOutputStream(client.getOutputStream());
        System.out.println("成功上传了一张图片！");
        bos.close();
        inputStream.close();
        bos.close();
    }
}
