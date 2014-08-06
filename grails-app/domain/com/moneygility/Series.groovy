package com.moneygility

import org.joda.time.DateTime

class Series {

    static constraints = {
    }

    static belongsTo = [plan: Plan]

    static hasMany = [operations: Operation]

    static embedded = ['frequency']

    String label
    Frequency frequency

    def findOperationsInCurrentMonth() {
        def monthOfYear = DateTime.now().monthOfYear
        operations.findAll { it.when.monthOfYear == monthOfYear }
    }

}
