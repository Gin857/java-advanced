package test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class timeTest1 {
    public static void main(String[] args) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date();
//现在时刻：
        System.out.println(format.format(date));
        long nowTime = date.getTime();
        long year = 5;
        nowTime=nowTime-year*365*24*60*60*1000;
        date=new Date(nowTime);
//这就是5年前的现在！！！
        System.out.println(format.format(date));
    }



}
