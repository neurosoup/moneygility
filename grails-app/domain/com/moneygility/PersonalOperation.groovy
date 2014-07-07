package com.moneygility

class PersonalOperation {

    static constraints = {
    }

    String label
    BigDecimal amount
    Frequency frequency

    static embedded = ['frequency']

}
