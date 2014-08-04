package com.moneygility

class Series {

    static constraints = {
    }

    static belongsTo = [plan: Plan]

    static hasMany = [operations: Operation]

    static embedded = ['frequency']

    String label
    Frequency frequency

}
