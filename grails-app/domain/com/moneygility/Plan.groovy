package com.moneygility

class Plan {

    static constraints = {
    }

    static belongsTo = [person: Person]

    static hasMany = [series: Serie]

    String label
    Boolean isActive
    Date startDate
    Date endDate

}
