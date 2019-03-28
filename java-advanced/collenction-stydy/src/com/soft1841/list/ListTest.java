package com.soft1841.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * List接口练习
 *
 * @auther xupeng
 * 2019.3.19
 */
public class ListTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("A");
        list.add("B");
        list.add("C");
        //通过for循环
        for (int i= 0,len= list.size();i<len;i++){
            System.out.println(list.get(i));
        }
        //通过Iterator迭送器遍历集合
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //Lambda表达式
        list.forEach(s -> System.out.println(s));
    }
}
