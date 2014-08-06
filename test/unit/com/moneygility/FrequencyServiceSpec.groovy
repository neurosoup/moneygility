package com.moneygility

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.joda.time.DateTime
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FrequencyService)
class FrequencyServiceSpec extends Specification {

    def setup() {
        grailsApplication.config.moneygility.frequency.monthly.code = "monthly"
    }

    def cleanup() {
    }

    void "given the fifth of the current month when we ask service to get a monthly frequency then it returns a proper monthly frequency"() {
        given:
        def day = "5"
        def start = DateTime.now()
        def end = start.plusDays(5)

        when:
        def frequency = service.getMonthly(day, start, end)

        then:
        frequency.code == grailsApplication.config.moneygility.frequency.monthly.code
        frequency.cronExpression == "0 0 1 ${day} 1/1 ? *"
    }

    void "given a monthly frequency that starts the first day of a month and last one month when service computes fire times then return exactly one time"() {
        given:
        def code = grailsApplication.config.moneygility.frequency.monthly.code
        def day = 1
        def start = DateTime.parse("2000-12-1")
        def end = DateTime.parse("2000-12-31")
        def frequency = new Frequency(code: code, cronExpression: "0 0 1 ${day} 1/1 ? *", start: start, end: end)

        when:
        def times = service.computeFireTimes(frequency)

        then:
        times.size() == 1
    }
}
