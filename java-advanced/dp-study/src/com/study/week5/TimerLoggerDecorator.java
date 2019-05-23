package com.study.week5;

import java.util.Calendar;

public class TimerLoggerDecorator implements Logger {

    private Logger decoratorLogger;

    public TimerLoggerDecorator(Logger decoratorLogger) {
        this.decoratorLogger=decoratorLogger;
    }

    @Override
    public void log(String message) {
        decoratorLogger.log(message);
        logTime();
    }
    public void logTime(){
        System.out.println(Calendar.getInstance().getTime());
    }
}
