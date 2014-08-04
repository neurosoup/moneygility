package com.moneygility

import org.joda.time.DateTime

class Frequency {

    static transients = ['day, cronTrigger, calendar']

    static constraints = {
    }

    String code
    String cronExpression //http://www.cronmaker.com
    DateTime start
    DateTime end

}
