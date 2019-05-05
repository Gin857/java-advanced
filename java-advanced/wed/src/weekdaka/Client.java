package weekdaka;

import java.net.Socket;

public class Client {
    public static void main(String[] args) throws Exception{
        Socket socket =new Socket("192.168.43.140",10086);
        System.out.println("以和服务器建立连接，远程地址主机："+socket.getRemoteSocketAddress());
    }
}
