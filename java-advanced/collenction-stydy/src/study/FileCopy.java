package study;

import java.io.*;
import java.util.UUID;

/**
 * 文件的复制,与更名
 * @author  xupeng
 * 2019.3.26
 */
public class FileCopy {
    public static void main(String[] args) throws IOException {
        //指定源文件
        File srcFile = new File("D:/b4.png");
        String srcFileName = srcFile.getName();
        int position = srcFileName.indexOf(".");
        String suffixName = srcFileName.substring(position+1);
        String newName = UUID.randomUUID().toString();
        //指定目标文件

        File destFile = new File("D:/"+newName+"."+suffixName);
        //创建数组，获取文件
        byte[] bytes = new byte[(int) srcFile.length()];
        //创建字节输入流
        InputStream in = new FileInputStream(srcFile);
        //将文件读入数组
        in.read(bytes);
        //创建文件输出流
        OutputStream out = new FileOutputStream(destFile);
        //将文件显示，写出
        out.write(bytes);
        //关闭流
        in.close();
        out.close();

    }
}
