package com.smaga;

import com.smaga.core.ApplicationLoop;
import com.smaga.input.InputReader;
import com.smaga.input.InputValidator;
import com.smaga.output.ConsolePrinter;
import com.smaga.output.FilePrinter;
import com.smaga.output.PrintService;
import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

@Slf4j
public class AppMain {

    private static final String EXIT_CODE = "q";

    public static void main(String[] args) {
        log.info("Application initialization...");
        InputValidator inputValidator = new InputValidator(EXIT_CODE);
        PrintService printService = initPrintService(args);
        InputReader inputReader = new InputReader(new Scanner(System.in));
        ApplicationLoop app = ApplicationLoop.builder()
                                .inputReader(inputReader)
                                .printService(printService)
                                .inputValidator(inputValidator)
                                .endlessLoop(true)
                                .build();

        app.start();
    }

    private static PrintService initPrintService(String[] args) {
        PrintService.PrintServiceBuilder builder = PrintService.builder();
        builder.consolePrinter(new ConsolePrinter());
        if (args.length == 1) {
            String fileName = args[0];
            log.debug("File name provided as first argument: {}", fileName);
            builder.filePrinter(new FilePrinter(fileName));
        } else if (args.length > 1) {
            throw new IllegalArgumentException("More then one argument is illegal!");
        }
        return builder.build();
    }
}
