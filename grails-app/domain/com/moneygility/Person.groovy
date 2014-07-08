package com.moneygility

import com.moneygility.security.User

class Person {

    static constraints = {
    }

    static hasMany = [operations: PersonalOperation, plans: Plan]

    String firstName
    String lastName
    Plan activePlan
    User user

}
