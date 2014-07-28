package com.moneygility

class PlannedOperation {

    static constraints = {
    }

    String label
    BigDecimal amount
    Frequency frequency

    static belongsTo = [plan: Plan]

    static embedded = ['frequency']

}
