package com.moneygility

import grails.test.spock.IntegrationSpec
import org.joda.time.DateTime

/**
 *
 */
class SeriesSpec extends IntegrationSpec {

    def frequencyService
    def grailsApplication

    def setup() {
    }

    def cleanup() {
    }



    def "grailsApplication is not null"() {
        expect:
        assert grailsApplication != null
    }

    def "applicationContext is not null"() {
        expect:
        assert applicationContext != null
    }

    def "grailsApplication.mainContext is not null"() {
        expect:
        assert grailsApplication.mainContext != null
    }

   /* void "given a series with two operations one month each when i want to find operations of the current month then returns exactly one operation"() {
        given:
        def now = DateTime.now()
        def person = new Person(firstName: "john", lastName: "doe")
        def plan = new Plan(label: "Test plan", isActive: true, start: now, end: now.plusYears(1), person: person)
        def frequency = frequencyService.getMonthly("5", plan.start, plan.end)
        def series = new Series(label: "Test series", frequency: frequency)
        series.addToOperations(new Operation(when: now.plusDays(5), amount: 100.0))
        series.addToOperations(new Operation(when: now.plusDays(5).plusMonths(1), amount: 100.0))
        series.save(failOnError: true)

        when:
        def result = series.findOperationsInCurrentMonth()

        then:
        result.count() == 1
    }*/
}
