package com.moneygility

import org.joda.time.DateTime

class Plan {

    static constraints = {
    }

    static belongsTo = [person: Person]

    static hasMany = [series: Series]

    String label
    Boolean isActive
    DateTime start
    DateTime end

}
