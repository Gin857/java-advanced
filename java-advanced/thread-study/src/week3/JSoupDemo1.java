package week3;


import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.*;


public class JSoupDemo1 {

    public static void main(String[] args) throws Exception {
        //1,指定目标页面链接
        String url = "https://read.douban.com/ebook/111488030/?icn=index-topic";
        //2,建立目标页面链接
        Connection connection = Jsoup.connect(url);
        //3,解析目标页面
        Document document = connection.get();
        //4,获取页面中所有的class为content的元素，本例在页面中可以检查元素，是div
        Elements elements = document.getElementsByClass("info");
//        System.out.println(elements.size());
        File file = new File("D:/test/1.txt");
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        for (Element element : elements) {
            //取出div的子元素div-h4-a
            Element link = element;
            //得到a标记的文字内容
            String titleString = link.text();
            try {
                byte[] bytes = titleString.getBytes();
                fileOutputStream.write(bytes);
                fileOutputStream.close();
            } catch (IOException e) {
                System.out.println("IO异常");
            }
            System.out.println(titleString);
        }
        try {
            FileInputStream fileInputStream = new FileInputStream(file);
            byte[] bytes = new byte[1024];
            int len = fileInputStream.read(bytes);
            System.out.println(new String(bytes, 0, len));
        } catch (IOException e) {
            System.out.println("输出异常");
        }

    }
}