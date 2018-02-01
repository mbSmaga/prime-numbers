package com.smaga.input;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class InputValidator {

    private final String EXIT_CODE;

    public boolean isExitCode(String code) {
        return EXIT_CODE.equals(code);
    }

    public boolean isPositiveInt(String input) {
        try {
            int number = Integer.parseInt(input);
            if (number > 0) {
                return true;
            }
        } catch (NumberFormatException e) {
            log.error("{} Failed to parse. {}",e.getClass().getName(), e.getMessage());
        }
        return false;
    }
}
