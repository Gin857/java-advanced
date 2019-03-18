package com.java.util;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * List类型的练习
 * @auther xupeng
 * 2019.3.18
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("java");
        list.add("HTML");
        list.add("HTML");
        //随机产生整数
        int length =list.size();
        System.out.println(length);
        Random random = new Random();
        int index =random.nextInt(length);
        //取出list中索引为index的元素
        System.out.println(list.get(index));
        //输出所有元素
        for (int i =0;i<length;i++){
            System.out.print("  "+list.get(i));
        }
    }
}
