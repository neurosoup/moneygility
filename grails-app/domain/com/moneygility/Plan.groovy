package com.moneygility

class Plan {

    static constraints = {
    }

    static belongsTo = [person: Person]

    //static hasMany = [operations: PlannedOperation]
    static embedded = ['operations']

    String label
    Boolean isActive
    List<PlannedOperation> operations

}
