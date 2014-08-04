package com.moneygility

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import grails.test.mixin.TestMixin
import grails.test.mixin.mongodb.MongoDbTestMixin
import org.joda.time.DateTime
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Series)
@Mock(Plan)
class SeriesSpec extends Specification {

    def grailsApplication

    def setup() {


    }

    def cleanup() {
    }

    /*def operation1 = new Operation(serie: domain, when: DateTime.now(), amount: 0)
    def operation2 = new Operation(serie: domain, when: DateTime.now().plusMonths(1), amount: 0)*/

    void "test persistence"() {
        given:
        def start = DateTime.now()
        def end = DateTime.now().plusYears(2)
        /*def plan = new Plan(label: "test plan", isActive: true, start: start, end: end)
        plan.save(failOnError: true)*/


        when:
        domain.label = 'test series'
        domain.frequency = new Frequency(code: "monthly", cronExpression: "0 0 1 5 1/1 ? *", start: start, end: end)
        //domain.plan = plan
        def saved = domain.save(flush: true, validate: false)

        then:
        saved != null
        Series.count() > 0

    }


}
