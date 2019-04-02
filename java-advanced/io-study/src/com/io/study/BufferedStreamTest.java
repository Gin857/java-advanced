package com.io.study;

import java.io.*;

/**
 * @author xupeng
 * 2019.4.3
 */
public class BufferedStreamTest {
    public static void main(String args[]) {
        // 定义字符串数组
        String content[] = {"你不喜欢我，", "我一点都不介意。", "因为我活下来，", "不是为了取悦你！"};
        File file = new File("D:\\test\\word.txt");
        // 创建FileOutputStream对象
        FileOutputStream fos = null;
        BufferedOutputStream bos = null;
        FileInputStream fis = null;
        BufferedInputStream bis = null;
        try {
            fos = new FileOutputStream(file);
            bos = new BufferedOutputStream(fos);
            byte[] bContent = new byte[1024];
            // 循环遍历数组
            for (int k = 0; k < content.length; k++) {
                bContent = content[k].getBytes();
                // 将字节数组内容写入文件
                bos.write(bContent);
            }
            System.out.println("写入成功！\n");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bos.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        try {
            fis = new FileInputStream(file);
            bis = new BufferedInputStream(fis);
            byte[] bContent = new byte[1024];
            int len = bis.read(bContent);
            System.out.println("文件中的信息是：" + new String(bContent, 0, len));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                bis.close();
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
