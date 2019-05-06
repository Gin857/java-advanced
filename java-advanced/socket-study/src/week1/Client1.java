package week1;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

public class Client1 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.40.153.18",10086);
        InputStream in = socket.getInputStream();
        byte[] bytes = new byte[1024];
        in.read(bytes);
        System.out.println("服务器发送了："+new String(bytes));
        in.close();
        socket.close();
    }
}
