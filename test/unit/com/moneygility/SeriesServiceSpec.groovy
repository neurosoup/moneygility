package com.moneygility

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SeriesService)
@Mock(Plan)
@Mock(Person)
class SeriesServiceSpec extends Specification {

    def setup() {
        def start = DateTime.now()
        def end = DateTime.now().plusYears(2)
        def person = new Person(firstName: "john", lastName: "doe")
        def plan = new Plan(label: "test plan", isActive: true, start: start, end: end)
        plan.save(failOnError: true)
    }

    def cleanup() {
    }

    void "given a series with one operation in the current month and one operation next month when get operations on current month then return one operation"() {
        given:
        def series = new Series()
        when:
        def result = service.getOperationsOfMonth(series)

        then:
        result.count() == 1
    }
}
