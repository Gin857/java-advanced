package socket;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;
import java.util.UUID;

/**
 * 客户端接收服务器发送的数据
 */
public class Client4 {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("192.168.43.140", 10086);
        System.out.println("成功连接上服务器......");
        InputStream inputStream = client.getInputStream();
        //获取服务器发送的消息
        BufferedInputStream bis = new BufferedInputStream(inputStream);
        System.out.println("请输入你要保存的路径");
        Scanner scanner = new Scanner(System.in);
        String path = scanner.nextLine();
        File file = new File(path + "/" + UUID.randomUUID().toString() + ".jpg");
        //获取后再给发送给本地
        OutputStream outputStream = new FileOutputStream(file);
        BufferedOutputStream bos = new BufferedOutputStream(outputStream);
        byte[] data = new byte[1024];
        int tmp;
        while ((tmp = bis.read(data)) != -1) {
            bos.write(data, 0, tmp);
        }
        //有好的提示
        System.out.println("以保存到:  "+path+" , 路径名："+path+ UUID.randomUUID().toString() + ".jpg");
        //关闭
        bis.close();
        bos.close();
        client.close();
    }
}
