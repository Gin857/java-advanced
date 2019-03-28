package com.java.util;


import java.util.ArrayList;
import java.util.List;

public class player extends Ball {
    public static void main(String[] args){
        List<Ball> list = new ArrayList<>();
        list.add(new Ball("拉塞尔","指环王",.6,1.0,2.0));
        System.out.println("----------NBA历史十大巨星----------");
        System.out.println("球员   绰号   得分   篮板   助攻");
        int len = list.size();
        for (int i = 0;i<len;i++){
            System.out.print(list.get(i).getName()+"   "+ list.get(i).getChuohao()+ "   "+list.get(i).getDefen() +"   "
                    +list.get(i).getLanban()
            +"   "+list.get(i).getZhugong());
            System.out.println();
        }
    }
}
