package com.moneygility

import grails.test.spock.IntegrationSpec
import org.joda.time.DateTime

/**
 *
 */

class SeriesSpec extends IntegrationSpec {

    def frequencyService

    def setup() {
    }

    def cleanup() {
    }

    void "given a series with two operations one month each when i want to find operations of the current month then returns exactly one operation"() {
        given:
        def now = DateTime.now()
        def person = new Person(firstName: "john", lastName: "doe")
        def plan = new Plan(label: "Test plan", isActive: true, start: now, end: now.plusYears(1), person: person)
        def frequency = frequencyService.getMonthly("5", plan.start, plan.end)
        def series = new Series(plan: plan, label: "Test series", frequency: frequency)
        series.addToOperations(new Operation(when: now.plusDays(5), amount: 100.0))
        series.addToOperations(new Operation(when: now.plusDays(5).plusMonths(1), amount: 100.0))
        series.save(failOnError: true)

        when:
        Collection<Operation> results = series.findOperationsInCurrentMonth()

        then:
        results.size() == 1
    }
}
