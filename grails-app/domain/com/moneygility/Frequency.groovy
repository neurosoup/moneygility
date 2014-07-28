package com.moneygility

import grails.plugins.quartz.TriggerUtils
import groovy.time.TimeCategory
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger

class Frequency {

    public static final String MONTHLY_CODE = "monthly"

    static constraints = {
    }

    String code
    String cronExpression //http://www.cronmaker.com


    static def getMonthly(String day) {
        new Frequency(code: MONTHLY_CODE, cronExpression: "0 0 1 ${day} 1/1 ? *")
    }

    static def getByCodeAndDay(String code, String day) {
        switch (code) {
            case MONTHLY_CODE:
                getMonthly(day)
            break
            default:
                getMonthly(day)
            break
        }
    }

    def List<Date> computeFireTimes() {
        def t = TriggerUtils.buildCronTrigger(code, this.class.name, cronExpression)

        /*def timeZone = TimeZone.getTimeZone("Europe/Paris")
        def locale = Locale.FRANCE
        def past = GregorianCalendar.getInstance(timeZone, locale)
        past.add(Calendar.YEAR, -2)
        def future = GregorianCalendar.getInstance(timeZone, locale)
        future.add(Calendar.YEAR, 5)
        def start = past.getTime()
        def end = future.getTime()*/

        def now = new Date()

        use(TimeCategory) {
            def start = now - 1.month
            def end = now + 1.years
            return org.quartz.TriggerUtils.computeFireTimesBetween(t as OperableTrigger, new BaseCalendar(timeZone), start, end)
        }

    }
}
