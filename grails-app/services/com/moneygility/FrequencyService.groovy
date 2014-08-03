package com.moneygility

import grails.plugins.quartz.TriggerUtils
import grails.transaction.Transactional
import org.joda.time.DateTime
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger

@Transactional
class FrequencyService {

    def grailsApplication

    def getMonthly() {
        def day = "${grailsApplication.config.moneygility.frequency.monthly.day}"
        def now = new DateTime()
        getMonthly(day, now, now)
    }

    def getMonthly(String day, DateTime start, DateTime end) {
        def code = grailsApplication.config.moneygility.frequency.monthly.code
        new Frequency(code: code, cronExpression: "0 0 1 ${day} 1/1 ? *", start: start, end: end)
    }

    def getDay(Frequency frequency) {
        def nextTime = computeFireTimes(frequency).first()
        new DateTime(nextTime).dayOfMonth

        /*def expr = new CronExpression(frequency.cronExpression)
        def nextTime = expr.getNextValidTimeAfter(new Date())
        CalendarUtils.getWhen(nextTime).get(Calendar.DAY_OF_MONTH)*/
    }

    def List<Date> computeFireTimes(Frequency frequency) {
        def cronTrigger = TriggerUtils.buildCronTrigger(frequency.code, frequency.class.name, frequency.cronExpression) as OperableTrigger
        cronTrigger.startTime = frequency.start.toDate()
        cronTrigger.endTime = frequency.end.toDate()
        org.quartz.TriggerUtils.computeFireTimesBetween(cronTrigger, new BaseCalendar(), cronTrigger.startTime, cronTrigger.endTime)
    }

    def getByCodeAndDay(String code, String day, DateTime startTime, DateTime endTime) {
        switch (code) {
            case grailsApplication.config.moneygility.frequency.monthly.code:
                getMonthly(day, startTime, endTime)
                break
            default:
                getMonthly(day, startTime, endTime)
                break
        }
    }


}
