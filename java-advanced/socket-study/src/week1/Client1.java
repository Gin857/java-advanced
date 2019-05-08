package week1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10086);
        System.out.println("连接上服务器");
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        in.read(bytes);
        System.out.println("服务器发送了："+new String(bytes));
        in.close();
        socket.close();
    }
}
