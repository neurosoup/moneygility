package com.moneygility

import com.moneygility.security.User

class Person {

    static constraints = {
    }

    static hasMany = [operations: PersonalOperation, plans: Plan]
    static belongsTo = [user: User]

    String firstName
    String lastName
    Plan activePlan


}
