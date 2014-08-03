package com.moneygility

import org.joda.time.DateTime

class Series {

    static constraints = {
    }

    static transients = ['operationsOfMonth']

    static belongsTo = [plan: Plan]

    static hasMany = [operations: Operation]

    static embedded = ['frequency']

    String label
    Frequency frequency

    def getOperationsOfMonth() {
        def monthOfYear = DateTime.now().monthOfYear
        operations.find { it.when.monthOfYear == monthOfYear }
    }
}
