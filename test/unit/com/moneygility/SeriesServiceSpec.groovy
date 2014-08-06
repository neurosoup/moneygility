package com.moneygility

import grails.buildtestdata.mixin.Build
import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(SeriesService)
//@Mock([Plan, Person, Series, Operation])
@Mock(FrequencyService)
class SeriesServiceSpec extends Specification {

    def setup() {
        //service.frequencyService = new FrequencyService()
        //service.frequencyService.grailsApplication = grailsApplication
        grailsApplication.config.moneygility.frequency.monthly.code = "monthly"

    }

    def cleanup() {
    }

    void "build a series with one operation"() {
        given:
        def person = new Person([firstName: "john", lastName: "doe"])
        //person.save(failOnError: true)

        def start = DateTime.now()
        def end = DateTime.now().plusYears(2)
        def plan = new Plan(person: person, label: "test plan", isActive: true, start: start, end: end)
        //plan.save(failOnError: true)

        def seriesMocker = mockFor(Series)
        seriesMocker.demand.addToOperations() {
            operations.add()
        }


        when:
        service.build(plan, 0.0, "Test series", "monthly", "5")

        then:
        Series.count() > 0
    }
}
