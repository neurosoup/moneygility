package com.moneygility

import grails.plugins.quartz.TriggerUtils
import groovy.time.TimeCategory
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger

class Frequency {

    def frequencyService

    public static final String MONTHLY_CODE = "monthly"

    static transients = ['day, cronTrigger, calendar']

    static constraints = {
    }

    String code
    String cronExpression //http://www.cronmaker.com
    Date startTime
    Date endTime

}
