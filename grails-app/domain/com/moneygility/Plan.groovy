package com.moneygility

class Plan {

    static constraints = {
    }

    static belongsTo = [person: Person]

    static hasMany = [series: Series]

    String label
    Boolean isActive
    Date startTime
    Date endTime

}
