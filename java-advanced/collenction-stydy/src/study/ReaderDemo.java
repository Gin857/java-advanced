package study;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

/**
 * 控制台写入与读出
 * @author xupeng
 * 2109.3.26
 */
public class ReaderDemo {
    public static void main(String[] args) throws IOException {
        //指定要写入的文件
        File file  = new File("D:/hello.txt");
        //输出提示
        System.out.println("输入你要的写入的内容");
        //创建写入流
        FileOutputStream out = new FileOutputStream(file);
        //定义标准的输入流
        Scanner scanner = new Scanner(System.in);
        //定义写入的的字符
        String content =scanner.nextLine();
        //创建byte数组，将写入的的文本转化成字节
        byte[] bytes = content.getBytes();
        //写入
        out.write(bytes);
        //关闭流
        out.close();
    }
}
