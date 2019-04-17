package week3;



import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


public class JSoupDemo1 {

    public static void main(String[] args)throws  Exception{
        //1,指定目标页面链接
        String url = "https://book.douban.com/";
        //2,建立目标页面链接
        Connection connection = Jsoup.connect(url);
        //3,解析目标页面
        Document document = connection.get();
        //4,获取页面中所有的class为content的元素，本例在页面中可以检查元素，是div
        Elements elements = document.getElementsByClass("content");
        System.out.println(elements.size());
        for (Element element : elements){
            //取出div的子元素div-h4-a
            Element link = element.child(0);
            //得到a标记的文字内容
            String titleString=  link.text();
            System.out.println(titleString);
        }
    }
}