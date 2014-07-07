package com.moneygility

class Plan {

    static constraints = {
    }

    static belongsTo = [person: Person]

    static hasMany = [operations: PlannedOperation]

    String label

}
