package com.moneygility

import com.moneygility.security.User

class Person {

    static constraints = {
    }

    static hasMany = [operations: PersonalOperation]

    static hasOne = [activePlan: Plan]

    static embedded = ['activePlan']

    String firstName
    String lastName
    User user

}
