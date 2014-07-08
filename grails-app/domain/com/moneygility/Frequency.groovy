package com.moneygility

import grails.plugins.quartz.TriggerUtils
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger

class Frequency {

    public static final String MONTHLY_CODE = "monthly"

    static constraints = {
    }

    static belongsTo = [operation: Operation]

    String code
    String cronExpression //http://www.cronmaker.com


    static def getMonthly(int day) {
        new Frequency(code: MONTHLY_CODE, cronExpression: "0 0 1 ${day} 1/1 ? *")
    }

    def List<Date> computeFireTimes() {
        def t = TriggerUtils.buildCronTrigger(code, this.class.name, cronExpression)

        def timeZone = TimeZone.getTimeZone("Europe/Paris")
        def locale = Locale.FRANCE
        def past = GregorianCalendar.getInstance(timeZone, locale)
        past.add(Calendar.YEAR, -2)
        def future = GregorianCalendar.getInstance(timeZone, locale)
        future.add(Calendar.YEAR, 5)

        org.quartz.TriggerUtils.computeFireTimesBetween(t as OperableTrigger, new BaseCalendar(timeZone), past.getTime(), future.getTime())
    }
}
