package socket;

import java.io.IOException;
import java.net.Socket;

/**
 * 客户端
 */
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("127.0.0.1",10086);
        System.out.println(socket.getRemoteSocketAddress()+"客户端连接成功");
    }
}
