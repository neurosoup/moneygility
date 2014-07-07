package com.moneygility

import grails.plugins.quartz.TriggerUtils
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger

class Frequency {

    public static final String MONTHLY_CODE = "moneygility.frequency.monthly"

    static constraints = {
    }

    String code
    String cronExpression //http://www.cronmaker.com

    def List<Date> getNextDates() {
        def t = TriggerUtils.buildCronTrigger(code, this.class.name, cronExpression)

        def timeZone = TimeZone.getTimeZone("Europe/Paris")
        def past = GregorianCalendar.getInstance(timeZone).add(Calendar.YEAR, -2)
        def future = GregorianCalendar.getInstance(timeZone).add(Calendar.YEAR, 5)

        org.quartz.TriggerUtils.computeFireTimesBetween(t as OperableTrigger, new BaseCalendar(timeZone), past.getTime(), future.getTime())
    }
}
