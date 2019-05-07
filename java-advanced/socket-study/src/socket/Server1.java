package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server1 {
    public static void main(String[] args) throws IOException {
        //创建服务器对象，映射端口10086
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器启动");
        //服务器10086端口侦听 1个服务器对多个客户端
        while (true) {
            //获得和客户端对象的连接
            Socket socket = ss.accept();
            ServerThread1 serverThread1 = new ServerThread1(socket);
            new Thread(serverThread1).start();
        }
    }
}
