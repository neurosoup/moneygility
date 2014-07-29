package com.moneygility

import grails.plugins.quartz.TriggerUtils
import grails.transaction.Transactional
import org.quartz.CronTrigger

@Transactional
class FrequencyService {

    private GregorianCalendar calendar
    private CronTrigger trigger

    def getCalendar() {
        if (!calendar) {
            def timeZone = TimeZone.getTimeZone("Europe/Paris")
            def locale = Locale.FRANCE
            calendar = GregorianCalendar.getInstance(timeZone, locale)
        }

        calendar
    }

    def buildCronTrigger(Frequency frequency) {
        if (!trigger) {
            trigger = TriggerUtils.buildCronTrigger(frequency.code, frequency.class.name, frequency.cronExpression)
        }

        trigger
    }
}
