package com.smaga.output

import spock.lang.Specification

import static com.smaga.output.PrintServiceTestDataFactory.SAMPLE_MESSAGE

class PrintServiceTest extends Specification {

    private PrintService printService
    private Printer consolePrinter
    private Printer filePrinter

    def setup() {
        consolePrinter = Mock()
        filePrinter = Mock()
        printService = new PrintService(consolePrinter, filePrinter)
    }

    def "printToConsole method should call consolePrinter.println"() {
        when:
        printService.printToConsole(SAMPLE_MESSAGE)
        then:
        1 * consolePrinter.println(SAMPLE_MESSAGE)
    }

    def "printToFile method should call filePrinter.println"() {
        when:
        printService.printToFile(SAMPLE_MESSAGE)
        then:
        1 * filePrinter.println(SAMPLE_MESSAGE)
    }
}
