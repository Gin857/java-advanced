package study;

import java.io.File;
import java.io.IOException;

public class FileDemo1 {
    public static void main(String[] args) throws IOException {
        //创建路径
        File path =  new File("D:/Java");
        if(!path.exists()){
            path.mkdirs();
        }
        //通过循环创建文件
        for(int i= 1 ;i<=10;i++){
            File file = new File(path+"/"+"chap"+i);
            if (!file.exists()) {
                file.mkdirs();
            }
        }
    }
}
