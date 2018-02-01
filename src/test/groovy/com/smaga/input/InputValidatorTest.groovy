package com.smaga.input

import spock.lang.Specification
import spock.lang.Unroll

class InputValidatorTest extends Specification {

    private InputValidator inputValidator
    private String EXIT_CODE = "q"

    def setup() {
        inputValidator = new InputValidator(EXIT_CODE)
    }

    def "isExitCode should return true for correct exit code"() {
        when:
        def result = inputValidator.isExitCode(input)

        then:
        result == expectedResult

        where:
        input  | expectedResult
        "q"    | true
        "Q"    | false
        ""     | false
        null   | false
        "1234" | false
    }

    @Unroll
    def "isPositiveInt should return #expectedResult for input #input"() {
        when:
        def result = inputValidator.isPositiveInt(input)

        then:
        result == expectedResult

        where:
        input        | expectedResult
        "1"          | true
        "2147483647" | true
        "0"          | false
        "-5"         | false
        "2147483648" | false
        "five"       | false
        "q"          | false
    }
}
