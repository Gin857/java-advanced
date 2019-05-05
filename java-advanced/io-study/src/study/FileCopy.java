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
        File srcFile = new File("D:/space/4.png");
        //获取源文件的名称，肯定是字符串啊，所以在这里用字符串来获取名称，并且用getName()方法获取
        String srcFileName = srcFile.getName();
        //既然名称已经获取，那么就要分析名称，这里用indexOf()的方法 即索引的方法来指定位置，数据类型int
        int position = srcFileName.indexOf(".");
        String suffixName = srcFileName.substring(position+1);
        System.out.println(suffixName);
        //定义的一个随机的字符串，像微信图片下载到本地就会出现一个随机的字符串
        String newName = UUID.randomUUID().toString();
        System.out.println(newName);
        //指定目标文件
//
//        File destFile = new File("D:/"+newName+"."+suffixName);
//        //创建数组，获取文件
//        byte[] bytes = new byte[(int) srcFile.length()];
//        //创建字节输入流
//        InputStream in = new FileInputStream(srcFile);
//        //将文件读入数组
//        in.read(bytes);
//        //创建文件输出流
//        OutputStream out = new FileOutputStream(destFile);
//        //将文件显示，写出
//        out.write(bytes);
//        //关闭流
//        in.close();
//        out.close();
//
    }
}
