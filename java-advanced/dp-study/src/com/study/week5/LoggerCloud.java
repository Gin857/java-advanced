package com.study.week5;

public class LoggerCloud implements Logger{

    @Override
    public void log(String message) {
        System.out.println("日志输出云平台"+message);
    }
}
