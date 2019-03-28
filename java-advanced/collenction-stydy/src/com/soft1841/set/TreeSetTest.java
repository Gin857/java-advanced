package com.soft1841.set;
/**
 * 红黑树tree
 */

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class TreeSetTest {
    public static void main(String[] args) {
        Set<Integer> set = new TreeSet<>();
        set.add(-5);
        set.add(3);
        set.add(-3);
        set.add(7);
        set.add(11);
        Iterator<Integer> it = set.iterator();
        System.out.println("Set集合中的元素 ：");
        while (it.hasNext()){
            System.out.println(it.next()+"   ");
        }

    }
}
