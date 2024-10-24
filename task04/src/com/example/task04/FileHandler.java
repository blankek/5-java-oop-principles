package com.example.task04;

import java.io.FileWriter;
import java.io.IOException;

public class FileHandler implements MessageHandler{

    @Override
    public void log(String message) {
        try {
            FileWriter writer = new FileWriter("log.txt", true);
            writer.write(message);
            writer.append("\n");

            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
