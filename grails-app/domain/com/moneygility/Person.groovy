package com.moneygility

import com.moneygility.security.User

class Person {

    static constraints = {
    }

    static hasMany = [plans: Plan]
    //static embedded = ['plans']

    String firstName
    String lastName
    User user
    //List<Plan> plans

}
