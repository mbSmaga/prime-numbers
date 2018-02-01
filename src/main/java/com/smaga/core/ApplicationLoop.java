package com.smaga.core;

import com.smaga.input.InputReader;
import com.smaga.input.InputValidator;
import com.smaga.output.PrintService;
import com.smaga.primenumber.PrimeDetector;
import lombok.Builder;
import lombok.extern.slf4j.Slf4j;

import static com.smaga.output.Messages.*;

@Slf4j
@Builder
public class ApplicationLoop {

    private static final String EXIT_CODE = "q";

    private final InputReader inputReader;
    private final PrintService printService;
    private final InputValidator inputValidator;

    private boolean endlessLoop;

    public void start() {
        log.info("Application started.");
        do {
            printService.printToConsole(REQUEST_INPUT);
            String input = inputReader.read();
            if (inputValidator.isExitCode(input)) {
                stopApplication();
            } else if (inputValidator.isPositiveInt(input)) {
                handleNumber(input);
            } else {
                printService.printToConsole(INVALID_INPUT_ERROR);
            }
        } while (endlessLoop);
    }

    private void handleNumber(String stringNumber) {
        int number = Integer.parseInt(stringNumber);

        if (PrimeDetector.isPrime(number)) {
            log.debug("Number {} is prime", number);
            notifyUser(String.format(PRIME, number));
        } else {
            log.debug("Number {} is not prime", number);
            int firstDivider = PrimeDetector.getFirstDivider(number);
            notifyUser(String.format(NOT_PRIME, number, firstDivider));
        }
    }

    private void notifyUser(String message) {
        printService.print(message);
    }

    private void stopApplication() {
        endlessLoop = false;
    }
}
