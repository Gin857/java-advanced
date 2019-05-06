package week1;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class Client2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("10.30.196.105",10086);
        OutputStream out = socket.getOutputStream();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入你将要向服务器发送的消息：");
            String info = scanner.nextLine();
            out.write(info.getBytes());
            Socket socket1 = new Socket("10.30.196.105",10086);
            //循环的内容
            InputStream in = socket1.getInputStream();
            byte[] bytes = new byte[1024];
            in.read(bytes);
            System.out.println("服务器发送了："+new String(bytes));
        }
    }
}
