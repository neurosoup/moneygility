package com.moneygility

class PlannedOperation extends Operation {

    static constraints = {
    }

    static belongsTo = [plan: Plan]

}
