package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.UUID;

/**
 * 服务器端口
 * 2019.5.7
 */
public class Server2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器启动，端口号：10086");
        Socket socket ;
        while (true){
            socket =serverSocket.accept();
            ServerThread2 serverThread2 = new ServerThread2(socket);
            new Thread(serverThread2).start();
        }
    }
}
class ServerThread2 implements Runnable{
    private Socket socket ;
    public ServerThread2 (Socket socket){
        this.socket=socket;
    }
    @Override
    public void run() {
        System.out.println("客户端"+socket.getInetAddress()+"上线了");
        try {
            InputStream inputStream = socket.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            File file = new File("D:/test/"+ UUID.randomUUID().toString()+".jpg");
            OutputStream os = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(os);
            byte[] data = new byte[1024];
            int tem;
            while ((tem=bis.read(data)) !=-1){
                bos.write(data,0,tem);
            }
            System.out.println("客户端"+socket.getInetAddress()+"上传了一张图片");
        }catch (Exception e){
            System.out.println("异常");
        }
    }
}