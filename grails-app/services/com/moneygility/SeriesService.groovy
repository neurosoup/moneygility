package com.moneygility

import grails.transaction.Transactional
import org.joda.time.DateTime

@Transactional
class SeriesService {

    def frequencyService

    def build(Plan plan, BigDecimal amount, String label, String frequencyCode, String day) {

        def frequency = frequencyService.getByCodeAndDay(frequencyCode, day, plan.start, plan.end)
        def series = new Series(frequency: frequency, label: label, plan: plan)
        def times = frequencyService.computeFireTimes(frequency)

        times.each {
            def operation = new Operation(amount: amount, series: series, when: new DateTime(it))
            series.addToOperations(operation)
        }

        series.save()
    }

}
