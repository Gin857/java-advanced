package io.wed;

import java.io.IOException;
import java.util.Scanner;

/**
 * 输入网址，得到网页的大小
 * @author 徐鹏
 * 2019.5.5
 */
public class ReadFileFromURL {
    public static void main(String[] args) {
        System.out.println("Enter a URL:");
        //获取输入的字符串
        String URLString = new Scanner(System.in).next();
        java.net.URL url = null;
        try {
             url = new java.net.URL(URLString);
            int count = 0;
            Scanner input = new Scanner(url.openStream());
            while (input.hasNext()) {
                String line = input.nextLine();
                count += line.length();
            }
            System.out.println("The file size is " + count + " characters");
        } catch (java.net.MalformedURLException e) {
            System.out.println("Invalid URL");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
