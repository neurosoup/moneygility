package com.moneygility

import grails.plugins.quartz.TriggerUtils
import grails.transaction.Transactional
import org.quartz.CronExpression
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger


@Transactional
class FrequencyService {

    def grailsApplication
    def calendarService

    def getMonthly() {
        def day = "${grailsApplication.config.moneygility.frequency.monthly.day}"
        def now = calendarService.now.getTime()
        getMonthly(day, now, now)
    }

    def getMonthly(String day, Date startTime, Date endTime) {
        def code = grailsApplication.config.moneygility.frequency.monthly.code
        new Frequency(code: code, cronExpression: "0 0 1 ${day} 1/1 ? *", startTime: startTime, endTime: endTime)
    }

    def getDay(Frequency frequency) {
        calendarService.getWhen(computeFireTimes(frequency).first()).get(Calendar.DAY_OF_MONTH)

        /*def expr = new CronExpression(frequency.cronExpression)
        def nextTime = expr.getNextValidTimeAfter(new Date())
        calendarService.getWhen(nextTime).get(Calendar.DAY_OF_MONTH)*/
    }

    def List<Date> computeFireTimes(Frequency frequency) {
        def cronTrigger = TriggerUtils.buildCronTrigger(frequency.code, frequency.class.name, frequency.cronExpression) as OperableTrigger
        cronTrigger.startTime = frequency.startTime
        cronTrigger.endTime = frequency.endTime
        org.quartz.TriggerUtils.computeFireTimesBetween(cronTrigger, new BaseCalendar(), cronTrigger.startTime, cronTrigger.endTime)
    }

    def getByCodeAndDay(String code, String day, Date startTime, Date endTime) {
        def frequency
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
