package com.smaga.primenumber

import spock.lang.Specification
import spock.lang.Unroll

class PrimeDetectorTest extends Specification {

    @Unroll
    def "should return #expectedResult for prime number #number"() {
        when:
        def result = PrimeDetector.isPrime(number)

        then:
        result == expectedResult

        where:
        number | expectedResult
        1      | true
        2      | true
        3      | true
        4      | false
        5      | true
        6      | false
        7      | true
        8      | false
        9      | false
        10     | false
    }

    def "should return firstDivider of a positive integer"() {
        when:
        def result = PrimeDetector.getFirstDivider(number)

        then:
        result == expectedResult

        where:
        number | expectedResult
        1      | 1
        2      | 2
        4      | 2
        6      | 2
        7      | 7
        9      | 3
        10     | 2
    }

    def "should throw IllegalArgumentException when calling isPrime with negativeNumber"() {
        when:
        PrimeDetector.isPrime(-1)

        then:
        thrown IllegalArgumentException
    }

    def "should throw IllegalArgumentException when looking for firstDivider of negative number"() {
        when:
        PrimeDetector.getFirstDivider(-1)

        then:
        thrown IllegalArgumentException
    }
}
