package com.moneygility

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SeriesService)
@Mock([Plan, Person, Series, Operation])
class SeriesServiceSpec extends Specification {

    def setup() {


    }

    def cleanup() {
    }

    void "given a series with one operation in the current month and one operation next month when get operations on current month then return one operation"() {
        given:
        def person = new Person(firstName: "john", lastName: "doe")
        person.save(failOnError: true)

        def start = DateTime.now()
        def end = DateTime.now().plusYears(2)
        def plan = new Plan(person: person, label: "test plan", isActive: true, start: start, end: end)
        plan.save(failOnError: true)

        def frequency = new Frequency(code: "monthly", cronExpression: "0 0 1 5 1/1 ? *", start: start, end: end)

        def series = new Series(label: "test series", frequency: frequency, plan: plan)

        series.operations.add(new Operation(series: series, when: DateTime.now(), amount: 0))
        series.operations.add(new Operation(series: series, when: DateTime.now().plusMonths(1), amount: 0))

        series.save(failOnError: true)

        def sq = Series.find { it.label == "test series" }

        when:
        def result = service.getOperationsOfMonth(series)

        then:
        result.count() == 1
    }
}
