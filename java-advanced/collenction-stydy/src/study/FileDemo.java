package study;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileDemo {
    public static void main(String[] args) throws IOException {
        //获取时间
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String date = format.format(new Date());
        System.out.println(date);
        //创建路径
        File path = new File("D:\\Test_"+date);
        if(!path.exists()){
            path.mkdirs();
        }
        //创建文件呢
        File file = new File( path+"\\" +"Hello_"+ date);
        if (!file.exists()) {
            file.createNewFile();
        }
    }
}
