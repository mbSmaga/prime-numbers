package com.smaga

import spock.lang.Specification

class AppMainTest extends Specification {

    def "should throw IllegalArgumentException if more then one arguments provided"() {
        given:
        String[] args = ["fileName", "someRedundantArg"]

        when:
        AppMain.main(args)

        then:
        thrown IllegalArgumentException
    }
}
