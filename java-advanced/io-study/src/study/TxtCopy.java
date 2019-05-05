package study;

import java.io.*;

/**
 *文本复制操作
 * @author xupeng
 * 2019.3.26
 */
public class TxtCopy {
    public static void main(String[] args) throws IOException {
        //源文件
        File srcFile = new File("D:/hello.txt");
        if (srcFile.exists()){
//            //指定路径
//            File destFile = new File("D:/hello副本.txt");
//            ReaderDemo in  =new FileReader(srcFile);
//            char[] chars = new char[(int) srcFile.length()];
//            in.read(chars);
//            Writer out = new FileWriter(destFile);
//            out.write(chars);
//            in.close();
//            out.close();
        }else {
            System.out.println("系统找不到文件");
        }
    }
}
