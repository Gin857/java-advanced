package com.study;

import zonghe2.TimeThread;

/**
 * 多线程售票1
 * 继承Thread类
 * 2019.4.9
 */
public class TickeThreadTest1 {
    public static void main(String[] args) {
        TickeThread tt1 = new TickeThread();
        tt1.start();
        TickeThread tt2 = new TickeThread();
        tt2.start();
        TickeThread tt3 = new TickeThread();
        tt3.start();
    }
}

class TickeThread extends Thread {
    private int tickets = 10;

    @Override
    public void run() {
        while (tickets > 0) {
            System.out.println(Thread.currentThread().getName()+"售票，当前票数："+--tickets+"  ");
        }
    }
}