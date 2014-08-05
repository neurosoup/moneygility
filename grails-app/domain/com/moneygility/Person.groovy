package com.moneygility

import com.moneygility.security.User

class Person {

    static constraints = {
        user nullable: true
    }

    static hasMany = [plans: Plan]

    String firstName
    String lastName
    User user

}
