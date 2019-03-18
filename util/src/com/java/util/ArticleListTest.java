package com.java.util;


import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;

import java.util.Date;
import java.util.Iterator;
import java.util.List;

class ArtcleListTest {
    public static void main(String[] args) throws ParseException {
        Date date = new Date();
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        System.out.println("ID       标题               作者          时间");
        List<Article> artclelist = new ArrayList<>();
        artclelist.add(new Article(1,"以青春之我成就青春中国，奋斗的一带青年","温煜珺",sdf.parse("2019-03-16 00:30:00")));
        artclelist.add(new Article(2,"再一次出发，寻找最美的风景","屈 塬",sdf.parse("2019-03-17 12:12:12 ")));
        artclelist.add(new Article(3,"梦和初心的队伍从脚下开拔","聂 政",sdf.parse("2019-03-18 6:5:9 ")));
        //
        Iterator<Article>  iterator = artclelist.iterator();
        while (iterator.hasNext()){
            Article article = iterator.next();
            String result;
            result = timeCal(sdf.format(article.getWriteTime()));
            System.out.println(article.getId()+"  "+article.getTitle().substring(0,10)+"...  "+
                    article.getAuthor()+"        "+ result );
        }
    }
    private static String timeCal(String time) {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d1;
        long diff = 0;
        try {
            d1 = format.parse(time);
            Date now = new Date();
            diff = now.getTime() - d1.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long seconds = diff / 1000;
        long minutes = seconds / 60;
        long hours = minutes / 60;
        long days = hours / 24;
        if (seconds < 60) {
            return "刚刚";
        } else if (minutes < 60) {
            return minutes + "分钟前";
        } else if (hours < 24) {
            return hours + "小时前";
        } else {
            return days + "天前";
        }
    }
}
