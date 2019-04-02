package com.io.study;
/**
 * 三种文本的输入
 */

import java.io.*;

public class OutputEx {
    public static void main(String[] args) throws IOException {
        //定义一个字符串
        String str = "I love Java";
        //指明文件的路径
        File file1 = new File("D:/out1.txt");
        //判断文件是否存在，若不存在则新建一个文件
        if (!file1.exists()){
            file1.createNewFile();
        }
        //字节流
        OutputStream outputStream = new FileOutputStream(file1);
        outputStream.write(str.getBytes());
        outputStream.close();
        //字符流             ,追加方式在流的后面加true
        Writer writer = new FileWriter(file1,true);
        writer.write(str.toCharArray());
        writer.close();
        //打印流
        OutputStream out = new FileOutputStream(file1);
        PrintStream printStream = new PrintStream(out);
        printStream.println(str);
        out.close();
        printStream.close();
    }
}
