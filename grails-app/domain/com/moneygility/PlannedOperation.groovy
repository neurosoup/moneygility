package com.moneygility

class PlannedOperation {

    static constraints = {
    }

    String label
    BigDecimal amount
    Frequency frequency

    static belongsTo = [serie: Serie]

    static embedded = ['frequency']

}
