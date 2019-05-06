package week1;

import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("192.168.43.140", 10086);
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("请输入你将要向服务器端发送的消息：");
            String info = scanner.nextLine();
            out.write(info.getBytes());
        }
    }
}
