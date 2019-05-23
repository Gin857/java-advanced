package com.study.week5;

public class LoggerTest {
    public static void main(String[] args) {
        Logger logger = new TimerLoggerDecorator(new LoggerFileSystem());
        logger.log("登录系统....");
        Logger logger1 = new TimerLoggerDecorator(new LoggerCloud());
        logger1.log("登录系统....");
    }
}
