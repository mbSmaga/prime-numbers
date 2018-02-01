package com.smaga.output;

import lombok.RequiredArgsConstructor;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;

@RequiredArgsConstructor
public class FilePrinter implements Printer {
    private final String fileName;

    @Override
    public void println(String message) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fileName, true), "utf-8"))) {
            writer.write(message);
            writer.newLine();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
