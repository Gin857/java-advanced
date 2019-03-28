package com.soft1841.test;

import java.util.*;

/**
 * List的综合练习
 * Goods的实现类
 * @auther xupeng
 * 2019.3.20
 */
public class GoodsList {
    public static void main(String[] args) {
        //List
        List<Goods> ballList = new ArrayList<>();
        Set<String> fruitList = new HashSet<>();
        ballList.add(new Goods("篮球",120, 13));
        ballList.add(new Goods("排球",50,53));
        ballList.add(new Goods("足球",70,70));
        fruitList.add("苹果");
        fruitList.add("橘子");
        fruitList.add("香蕉");
        fruitList.add("橘子");
        System.out.println("--------商品分类排序---------");
        System.out.println("商品名称 "+" 价格 "+"    库存");
        System.out.println("----------------------------");
        //Map的运用
        //调用Collections的sort方法，自动调用compareTo方法进行排序
        Collections.sort(ballList);
        Map<String,List<Goods>> map = new HashMap<>();
        map.put("       ***球类***",ballList);
        Iterator<Map.Entry<String, List<Goods>>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()){
            Map.Entry<String, List<Goods>> entry = iterator.next();
            System.out.println(entry.getKey());
            List<Goods> list = entry.getValue();
            for (Goods s :list){
                System.out.print("  "+s.getName()+"    "+s.getPrice()+"$      "+s.getStock());
                System.out.println();
            }
        }
        //set 消除重复
        //用for 循环遍历set集合
        Object[] arr= fruitList.toArray();
        System.out.println("------------set去重---------");
        for (int i = 0 ;i<arr.length;i++){
            System.out.println("  "+arr[i]+"  ");
        }
    }
}
