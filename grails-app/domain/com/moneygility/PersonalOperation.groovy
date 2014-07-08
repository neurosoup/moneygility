package com.moneygility

class PersonalOperation extends Operation {

    static constraints = {
    }

    static belongsTo = [person: Person]

}
