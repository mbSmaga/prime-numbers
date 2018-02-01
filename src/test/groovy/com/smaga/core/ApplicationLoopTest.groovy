package com.smaga.core

import com.smaga.input.InputReader
import com.smaga.input.InputValidator
import com.smaga.output.PrintService
import spock.lang.Specification

import static com.smaga.core.ApplicationLoopDataFactory.*
import static com.smaga.output.Messages.INVALID_INPUT_ERROR

class ApplicationLoopTest extends Specification {

    private InputReader inputReader
    private PrintService printService
    private InputValidator inputValidator

    private ApplicationLoop applicationLoop

    def setup() {
        inputReader = Mock()
        printService = Mock()
        inputValidator = Mock()
        applicationLoop = ApplicationLoop.builder()
                            .inputReader(inputReader)
                            .printService(printService)
                            .inputValidator(inputValidator)
                            .endlessLoop(false)
                            .build()
    }

    def "should exit if endlessLoop is true and EXIT_CODE provided"() {
        given:
        applicationLoop = ApplicationLoop.builder()
                .inputReader(inputReader)
                .printService(printService)
                .inputValidator(inputValidator)
                .endlessLoop(true)
                .build()

        inputReader.read() >> EXIT_CODE
        inputValidator.isExitCode(EXIT_CODE) >> true

        when:
        applicationLoop.start()

        then:
        notThrown Exception
    }

    def "should call printService.print for a prime number"() {
        given:
        inputReader.read() >> PRIME_NUMBER_STRING
        inputValidator.isPositiveInt(PRIME_NUMBER_STRING) >> true

        when:
        applicationLoop.start()

        then:
        1 * printService.print(_ as String)
    }

    def "should call printService.print for not prime number"() {
        given:
        inputReader.read() >> NOT_PRIME_NUMBER_STRING
        inputValidator.isPositiveInt(NOT_PRIME_NUMBER_STRING) >> true

        when:
        applicationLoop.start()

        then:
        1 * printService.print(_ as String)
    }

    def "should call printService.printToConsole() for invalid input"() {
        given:
        inputReader.read() >> INVALID_INPUT

        when:
        applicationLoop.start()

        then:
        1 * printService.printToConsole(INVALID_INPUT_ERROR)
    }
}
