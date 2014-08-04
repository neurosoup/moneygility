package com.moneygility

import grails.transaction.Transactional
import org.joda.time.DateTime

@Transactional
class SeriesService {

    def frequencyService

    def create(Plan plan, BigDecimal amount, String label, String frequencyCode, String day) {

        def frequency = frequencyService.getByCodeAndDay(frequencyCode, day, plan.startTime, plan.endTime)
        def series = new Series(frequency: frequency, label: label, plan: plan)
        def times = frequencyService.computeFireTimes(frequency)

        times.each {
            def operation = new Operation(amount: amount, serie: series, time: it)
            series.addToOperations(operation)
        }

        series.save()
    }

    def delete(int seriesId) {
        def series = Series.get(seriesId)
        series.delete()
    }

    def getOperationsOfMonth(Series series) {
        def monthOfYear = DateTime.now().monthOfYear
        series.operations.find { it.when.monthOfYear == monthOfYear }
    }
}
