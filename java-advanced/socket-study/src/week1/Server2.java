package week1;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器端口启动！端口为：10086");
        InputStream in;
        while (true) {
            Socket socket = ss.accept();
            byte[] bytes = new byte[1024];
            System.out.println("客户端" + socket.getInetAddress() + "上线了");
            while (true) {
                in = socket.getInputStream();
                in.read(bytes);
                System.out.println("客户端" + socket.getInetAddress() + "给您发来新消息：" + new String(bytes));
            }
        }
    }
}
