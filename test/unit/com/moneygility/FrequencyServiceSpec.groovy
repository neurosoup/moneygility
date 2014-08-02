package com.moneygility

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import org.springframework.transaction.PlatformTransactionManager
import org.springframework.transaction.TransactionStatus
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.services.ServiceUnitTestMixin} for usage instructions
 */
@TestFor(FrequencyService)
class FrequencyServiceSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "given the fifth of the current month when we ask service to get a monthly frequency then it returns a proper monthly frequency"() {
        given:
        def day = "5"
        def startTime = new Date()
        def endTime = new Date() + 5

        when:
        def frequency = service.getMonthly(day, startTime, endTime)

        then:
        frequency.code == service.grailsApplication.config.moneygility.frequency.monthly.code
        frequency.cronExpression == "0 0 1 ${day} 1/1 ? *"
    }

    void "given a monthly frequency that starts the first day and last one month when service computes fire times then return at least one time"() {
        given:
        CalendarService calendarService = new CalendarService()
        calendarService.transactionManager = Mock(PlatformTransactionManager) { getTransaction(_) >> Mock(TransactionStatus) }
        def code = service.grailsApplication.config.moneygility.frequency.monthly.code
        def day = 1
        def startTime = calendarService.getWhen(2000, 12, 1)
        def endTime = calendarService.getWhen(2000, 12, 31)
        def frequency = new Frequency(code: code, cronExpression: "0 0 1 ${day} 1/1 ? *", startTime: startTime, endTime: endTime)

        when:
        def times = service.computeFireTimes(frequency)

        then:
        times.size() == 1
    }
}
