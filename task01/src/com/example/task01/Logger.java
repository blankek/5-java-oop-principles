package com.example.task01;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Logger {
    private final String name;
    private LoggerLevel loggerLevel;
    private static Logger example;

    public Logger(String name){
        this.name = name;
        this.loggerLevel = LoggerLevel.DEBUG;
    }

    public Logger(LoggerLevel loggerLevel, String name){
        this.loggerLevel = loggerLevel;
        this.name = name;
    }

    public String getName(){
        return name;
    }

    public static Logger getLogger(String name){
        if (example == null){
            example = new Logger(name);
        }
        return example;
    }

    public LoggerLevel getLevel(){
        return loggerLevel;
    }

    public void setLevel(LoggerLevel loggerLevel){
        this.loggerLevel = loggerLevel;
    }

    public void debug(String message){
        log(LoggerLevel.DEBUG, message);
    }

    public void debug(String sample, Object... arguments){
        log(LoggerLevel.DEBUG, sample, arguments);
    }

    public void info(String message){
        log(LoggerLevel.INFO, message);
    }

    public void info(String sample, Object... arguments){
        log(LoggerLevel.INFO, sample, arguments);
    }

    public void warning(String message){
        log(LoggerLevel.WARNING, message);
    }

    public void warning(String sample, Object... arguments){
        log(LoggerLevel.WARNING, sample, arguments);
    }

    public void error(String message){
        log(LoggerLevel.ERROR, message);
    }

    public void error(String sample, Object... arguments){
        log(LoggerLevel.ERROR, sample, arguments);
    }

    public void log(LoggerLevel loggerLevel, String message){
        if(loggerLevel.ordinal() >= this.loggerLevel.ordinal()){
            String date = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy.MM.dd hh:mm:ss"));
            String printMessage = MessageFormat.format("[{0}] {1} {2} - {3}", loggerLevel, date, name, message);
            System.out.printf(printMessage);
        }
    }

    public void log(LoggerLevel loggerLevel, String format, Object... arguments){
        if(loggerLevel.ordinal() >= this.loggerLevel.ordinal()){
            System.out.println(MessageFormat.format(format, arguments));
        }
    }
}
