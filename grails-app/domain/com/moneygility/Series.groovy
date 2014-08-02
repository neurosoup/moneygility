package com.moneygility

class Series {

    def calendarService

    static constraints = {
    }

    static transients = ['operationsOfMonth']

    static belongsTo = [plan: Plan]

    static hasMany = [operations: Operation]

    static embedded = ['frequency']

    String label
    Frequency frequency

    def getOperationsOfMonth() {
        def results = operations.find {
            def now = calendarService.now.get(Calendar.MONTH)
            def month = calendarService.getWhen(it.time).get(Calendar.MONTH)
            month == now
        }
        results
    }
}
