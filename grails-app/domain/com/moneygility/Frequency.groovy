package com.moneygility

import grails.plugins.quartz.TriggerUtils
import groovy.time.TimeCategory
import org.joda.time.DateTime
import org.joda.time.LocalDateTime
import org.quartz.impl.calendar.BaseCalendar
import org.quartz.spi.OperableTrigger

class Frequency {

    static transients = ['day, cronTrigger, calendar']

    static constraints = {
    }

    String code
    String cronExpression //http://www.cronmaker.com
    DateTime start
    DateTime end

}
