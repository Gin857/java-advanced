package week1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务器向客服端发送文本数据
 */
public class Server1  {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(10086);
        System.out.println("服务器端口启动，端口：10086");
        OutputStream out ;
        System.out.println("请输入向客服端将要发送的消息：");
        Scanner scanner = new Scanner(System.in);
        String txt = scanner.nextLine();
        while (true){
            Socket socket = ss.accept();
            System.out.println("客服端："+socket.getInetAddress()+"上线了");
            out= socket.getOutputStream();
            out.write(txt.getBytes());
            out.close();
            socket.close();
        }
    }
}
