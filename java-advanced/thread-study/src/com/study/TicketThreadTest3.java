package com.study;

/**
 * 售票3
 * 同步线程（加锁）
 * 2019.4.9
 */
public class TicketThreadTest3 {
    public static void main(String[] args) {
        TicketThread3 tt = new TicketThread3();
        Thread thread1 = new Thread(tt, "南京站");
        thread1.start();
        Thread thread2 = new Thread(tt, "南京南站");
        thread2.start();
        Thread thread3 = new Thread(tt, "南工院");
        thread3.start();
    }
}

class TicketThread3 implements Runnable {
    private int tickets = 10;

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tickets > 1) {
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        System.err.println("中断异常");
                    }
                    System.out.println(Thread.currentThread().getName() + "售票，当前票号:" + --tickets);
                }else {
                    break;
                }
            }
        }
    }
}