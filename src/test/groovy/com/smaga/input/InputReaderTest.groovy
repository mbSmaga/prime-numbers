package com.smaga.input

import spock.lang.Specification

class InputReaderTest extends Specification {

    InputReader inputReader

    def "should read input"() {
        given:
        InputStream stream = new ByteArrayInputStream(input.getBytes());
        inputReader = new InputReader(new Scanner(stream))

        when:
        def result = inputReader.read()

        then:
        result.equals(expectedResult)

        where:
        input           | expectedResult
        "1"             | "1"
        "My test input" | "My"
        "q"             | "q"
        "12 23"         | "12"
    }

    def "should return empty string if does not have next input"() {
        given:
        inputReader = new InputReader(new Scanner(new ByteArrayInputStream()))

        when:
        def result = inputReader.read()

        then:
        result.equals("")
    }
}
