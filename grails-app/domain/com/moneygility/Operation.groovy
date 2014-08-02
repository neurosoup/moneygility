package com.moneygility

class Operation {

    def calendarService

    static constraints = {
    }

    static transients = ['day']

    Date time
    BigDecimal amount

    static belongsTo = [serie: Series]

    def getDay() {
        calendarService.getWhen(time).get(Calendar.DAY_OF_MONTH)
    }
}
