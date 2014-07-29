package com.moneygility

class Serie {

    static constraints = {
    }

    static belongsTo = [plan: Plan]

    static hasMany = [operations: PlannedOperation]
}
