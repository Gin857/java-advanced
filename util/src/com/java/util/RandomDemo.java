package com.java.util;

import java.util.Random;

/**
 * 随机数类
 * @auther xupeng
 * 2019.3.12
 */
public class RandomDemo {
    public static void main(String[] args) {
        //随机生成5以内的数，包括5
        Random random = new Random();
        //填5了就不会产生5,  0 到5 的输出
        int num = random.nextInt(6);
        System.out.println(num);
    }


}
