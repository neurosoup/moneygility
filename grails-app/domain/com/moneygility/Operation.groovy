package com.moneygility

import org.joda.time.DateTime

class Operation {

    static constraints = {
    }

    DateTime when
    BigDecimal amount

    static belongsTo = [serie: Series]

}
