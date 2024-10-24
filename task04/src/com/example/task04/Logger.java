package com.example.task04;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Logger {
    private final String name;
    private LoggerLevel loggerLevel;
    private static Logger example;
    ArrayList<MessageHandler> handlers = new ArrayList<>();

    public Logger(String name){
        this.name = name;
        this.loggerLevel = LoggerLevel.DEBUG;
        handlers.add(new ConsoleHandler());
    }

    public Logger(String name, ArrayList<MessageHandler> handlers){
        this.loggerLevel = LoggerLevel.DEBUG;
        this.name = name;
        this.handlers = handlers;
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
            String lineToPrint = MessageFormat.format("[{0}] {1} {2} - {3}", loggerLevel, date, name, message);
            for (MessageHandler handler : handlers){
                handler.log(lineToPrint);
            }
        }
    }

    public void log(LoggerLevel loggerLevel, String format, Object... arguments){
        if(loggerLevel.ordinal() >= this.loggerLevel.ordinal()){
            String message = MessageFormat.format(format, arguments);
            for (MessageHandler handler : handlers){
                handler.log(message);
            }
        }
    }
}
