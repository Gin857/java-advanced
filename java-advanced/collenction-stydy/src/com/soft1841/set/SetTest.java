package com.soft1841.set;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Objects;
import java.util.Set;

/**
 * set接口基础程序
 */
public class SetTest {
    public static void main(String[] args) {
        Set<String> set = new HashSet<>();
        set.add("a");
        set.add("a");
        set.add("a");
        set.add("a");
        System.out.println("直接输出");
        System.out.println(set);

        //用for 循环遍历set集合
        System.out.println("用for 循环遍历set集合");
        Object[] arr= set.toArray();
        for (int i = 0 ;i<arr.length;i++){
            System.out.println(arr[i]+"  ");
        }
        //用iterator迭代器遍历set集合
        System.out.println("用iterator迭代器遍历set集合");
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        //用lanbda表达式输出结果
        System.out.println("用lanbda表达式输出结果");
        set.forEach(s -> System.out.println(set));
    }
}
