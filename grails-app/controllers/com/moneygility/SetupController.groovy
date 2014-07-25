package com.moneygility

import com.moneygility.security.User

class SetupController {

    def springSecurityService

    def index() {

        def user = springSecurityService.currentUser

        //Create default person associated with the current login
        //Have to add a new screen for choosing personal information
        def person = Person.findByUser(user)

        if (!person) {
            person = new Person(user: user, firstName: 'John', lastName: 'Doe')
        }

        //Create first plan associated with the newly created person
        def plan = Plan.findByPersonAndIsActive(person, true)

        if (!plan) {
            plan = new Plan(label: message(code: 'moneygility.setup.expenses.firstplan.label'), isActive: true)
            person.addToPlans(plan)
            person.save()
        }

        //Go to the first step of setup
        render view: 'expenses', model: [plan: plan]
    }

    def expenses() {}

    def addoperation() {
        def amount = params.amount
        def label = params.label
        def day = params.day ? params.day == '30/31' ? 'L' : params.day : grailsApplication.config.moneygility.operations.periodic.startday

        def frequency = new Frequency(code: Frequency.MONTHLY_CODE, cronExpression: "0 1 0 ${day} 1/1 ? *")

        def plan = flash.plan
        def operation = new PlannedOperation(amount: amount, label: label, frequency: frequency)
        plan.operations.add(operation)
        plan.save()

        render template: 'expenseList', model: [plan: plan]
    }
}
