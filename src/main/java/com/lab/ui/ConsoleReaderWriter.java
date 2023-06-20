package com.lab.ui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ConsoleReaderWriter {

    private final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    public String read(String message) {
        System.out.print(message);
        String line = null;
        try {
            line = reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }

    public void write(String output) {
        System.out.println(output);
    }
}
