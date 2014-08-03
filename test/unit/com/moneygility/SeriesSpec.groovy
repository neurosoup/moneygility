package com.moneygility

import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Series)
class SeriesSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "test persistence"() {
        given:
        def operation1 = new Operation(serie: domain, when: DateTime.now(), amount: 0)
        def operation2 = new Operation(serie: domain, when: DateTime.now().plusMonths(1), amount: 0)

        when:
        //domain.addToOperations(operation1)
        //domain.addToOperations(operation2)
        domain.save(flush: true)

        then:
        domain.operations.count() > 0

    }

    void "test get operations of current month"() {
        when:
        def result = domain.operationsOfMonth

        then:
        result.count() == 1
    }
}
