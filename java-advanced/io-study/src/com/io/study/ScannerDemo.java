package com.io.study;

import java.io.*;
import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) throws IOException {
        //获取本地文件内容
        File file = new File("D:\\1.txt");
        InputStream inputStream = new FileInputStream(file);
        Scanner scanner = new Scanner(inputStream);
        String res = scanner.nextLine();
        System.out.println(res);
    }
}
