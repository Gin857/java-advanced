package socket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动！端口号：10086");
        while (true){
            Socket socket = serverSocket.accept();
            ServerThread serverThread = new ServerThread(socket);
            new Thread(serverThread).start();
        }
    }
}

class ServerThread implements Runnable{

    private Socket socket ;
    public ServerThread (Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"上线了");
    }
}