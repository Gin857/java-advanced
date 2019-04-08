package week1;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 爬取网络图片
 * @author 徐鹏
 * 2019.4.9
 */
public class GetImageByNeT {
    public static void main(String[] args) throws IOException {
        URL url = new URL("https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3185348952,2780125580&fm=200&gp=0.jpg");
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn .setRequestMethod("GET");
        conn.setConnectTimeout(5*1000);
        InputStream inStream = conn.getInputStream();
        ByteArrayOutputStream out1 = new ByteArrayOutputStream();
        byte[] buffer = new byte[1024];
        int len = 0;
        while ((len = inStream.read(buffer) ) != -1){
            out1.write(buffer,0,len);
        }
        inStream.close();
        byte[] date = out1.toByteArray();
        File imageFile = new File("D:\\1.jpg");
        OutputStream out2 = new FileOutputStream(imageFile);
        out2.write(date);
        out2.close();
    }
}
