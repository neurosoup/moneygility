package com.moneygility

class Operation {

    static constraints = {
    }

    String label
    BigDecimal amount
    Frequency frequency

    static embedded = ['frequency']

}
