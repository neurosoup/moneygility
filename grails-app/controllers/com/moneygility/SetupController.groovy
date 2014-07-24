package com.moneygility

import com.moneygility.security.User

class SetupController {

    def springSecurityService

    def index() {

        def user = springSecurityService.currentUser

        //Create default person associated with the current login
        //Have to add a new screen for choosing personal information
        def person = Person.findByUser(user) ?: new Person(user: user, firstName: 'John', lastName: 'Doe')

        //Create first plan associated with the newly created person
        def plan = person.plans.find { it.isActive }.first()

        if (!plan) {
            plan = new Plan(label: message(code: 'moneygility.setup.expenses.firstplan.label'), isActive: true)
            person.plans.add(plan)
            person.save()
        }

        //Go to the first step of setup
        render view: 'expenses', model: [operations: plan.operations]
    }

    def expenses() {}

    def validate() {
        def p = params
        def isvalid = false

        if (p.label)
            isvalid = true

        render(contentType: 'text/json') {
            [
                    'valid': isvalid
            ]
        }
    }

    def addoperation() {
        def amount = params.amount
        def label = params.label
        def day = params.day ? params.day == '30/31' ? 'L' : params.day : 5
        def frequency = new Frequency(code: Frequency.MONTHLY_CODE, cronExpression: "0 1 0 ${day} 1/1 ? *")
        def person = Person.findByUser(springSecurityService.currentUser)
        def plan = person.plans.find { it.isActive }.first()
        def operation = new PlannedOperation(amount: amount, label: label, frequency: frequency)
        plan.operations.add(operation)
        person.save()

        render template: 'expenseList', model: [operations: plan.operations]
    }
}
