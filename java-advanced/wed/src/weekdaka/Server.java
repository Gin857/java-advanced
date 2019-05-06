package weekdaka;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException{
        //创建服务器对象
        ServerSocket ss =new ServerSocket(10086);
        System.out.println("服务器启动，端口号："+ss.getLocalPort());
        //服务器咋端口监听
        while (true){
            //获得和客服端对象的连接
            Socket socket = ss.accept();
            //获得客服端的官网的地址
            System.out.println("客服端："+socket.getInetAddress()+"上线了");
            socket.close();
        }
    }
}
