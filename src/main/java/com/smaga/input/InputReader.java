package com.smaga.input;

import lombok.RequiredArgsConstructor;

import java.util.Scanner;

@RequiredArgsConstructor
public class InputReader {

    private final Scanner scanner;

    public String read() {
        return scanner.hasNext() ? scanner.next() : "";
    }
}
