package com.moneygility

class PlannedOperation {

    static constraints = {
    }

    String label
    BigDecimal amount
    Frequency frequency

    static embedded = ['frequency']
}
