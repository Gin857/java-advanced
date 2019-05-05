package weekdaka;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws Exception{
        ServerSocket ss =new ServerSocket(10086);
        System.out.println("服务器启动，端口号："+ss.getLocalPort());
        while (true){
            Socket socket = ss.accept();
            System.out.println("客服端："+socket.getInetAddress()+"上线了");
            socket.close();
        }
    }
}
