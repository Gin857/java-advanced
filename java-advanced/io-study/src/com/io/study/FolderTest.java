package com.io.study;

import java.io.File;

/**
 * 文件数输出
 * @author xupeng
 * 2019.4.1
 */
public class FolderTest {
    public static void main(String[] args) {
        //遍历路径
        String path = "D:\\test";
        //获取file对象
        File file = new File(path);
        //遍历path下文件
        File[] fs = file.listFiles();
        for (File f : fs) {
            String srcFileName = f.getName();
            int position = srcFileName.indexOf(".");
            String suffixName = srcFileName.substring(position);
            if (suffixName.equals(".jpg") | suffixName.equals(".png")) {
                System.out.println(f);
            }
        }
    }
}
