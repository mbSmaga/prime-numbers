package com.smaga.output;

import lombok.Builder;

@Builder
public class PrintService {

    private final Printer consolePrinter;
    private final Printer filePrinter;

    public void print(String message) {
        if (filePrinter != null) {
            printToFile(message);
        } else {
            printToConsole(message);
        }
    }

    public void printToConsole(String message) {
        consolePrinter.println(message);
    }

    public void printToFile(String message) {
        filePrinter.println(message);
    }
}
