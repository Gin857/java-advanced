package socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器向客服端发送数据
 */
public class Server4 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(10086);
        System.out.println("服务器端口已启动，端口号10086");
        while (true) {
            Socket socket = serverSocket.accept();
            ServerThread4 serverThread4 = new ServerThread4(socket);
            new Thread(serverThread4).start();
        }
    }
}

class ServerThread4 implements Runnable {

    private Socket socket;

    public ServerThread4(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        System.out.println("客户端" + socket.getInetAddress() + "连接成功！");
        try {
            //首先找文件路径，并且白文件传给流，
            File file = new File("D:/space/2.jpg");
            InputStream inputStream = new FileInputStream(file);
            //文件内容写到数组，并且把获取到数据的数组给写给写好的流，流会把数据写道socket中
            byte[] bytes = new byte[(int) file.length()];
            inputStream.read(bytes);
            //获取socket中的数据然后输出
            OutputStream outputStream = socket.getOutputStream();
            outputStream.write(bytes);
            //关闭各种流
            inputStream.close();
            outputStream.close();
            socket.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
