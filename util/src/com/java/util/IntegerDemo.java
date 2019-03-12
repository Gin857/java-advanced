package com.java.util;

/**
 * Integer类的练习
 * @auther xupeng
 * 2019.3.12
 */
public class IntegerDemo {
    public static void main(String[] args) {
        int num = 31;
        //调用integer类的方法，将num进行进制转换】
        String str1 = Integer.toBinaryString(num);
        System.out.println("二进制：" + str1);
        String str2 = Integer.toOctalString(num);
        System.out.println("八进制：" + str2);
        String str3 = Integer.toHexString(num);
        System.out.println("十六进制：" + str3);
        String str4 = Integer.toString(num, 7);
        System.out.println("七进制：" + str4);
        System.out.println("------------分割线-----------");
//        System.out.println("自己的七进制转换"+ myDec(31,7));
        System.out.println("新版七进制转换"+ dec(31,7));

    }

//
//    private static char[] array = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"
//            .toCharArray();
//
//    public static String myDec(int num , int redidx) {
//        // StringBuilder是‘可变的String’ ,
//        StringBuilder result = new StringBuilder();
//        // 模拟计算进制的过程
//        while (num > 0) {
//            result.insert(0, array[num % redidx]);
//            num /= redidx;
//        }
//        return result.toString();
//    }
//    private static String convert (int num ,int radix){
//        return "";
//    }
//
    private static String dec(int unm,int radix){
        //创建一个stringBuffer ,用来存放结果字符串
        StringBuffer stringBuffer = new StringBuffer();
        //被除数不为0 就循环
        while (unm != 0){
            //求余数
            int remainder = unm % radix;
            //将余数转换为字符串，加入stringBuffer
            stringBuffer.append(String.valueOf(remainder));
            //更新被除数为商
            unm =unm/radix;
        }
        //结果取反返回
        return stringBuffer.reverse().toString();
    }

}
