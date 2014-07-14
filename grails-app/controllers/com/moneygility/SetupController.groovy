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
        def plan = Plan.findByPerson(person) ?: new Plan(label: message(code: 'moneygility.setup.expenses.firstplan.label'), isActive: true)
        person.addToPlans(plan)

        //save the whole thing
        if (!person.save()) {
            person.errors.each {
                log.debug(it)
            }
        }

        //Go to the first step of setup
        render view: 'expenses'
    }

    def expenses() {}

    def validate() {
        def p = params
        def isvalid = false
        render(contentType: 'text/json') {[
                'valid': isvalid
        ]}
    }

    def addoperation() {
        def amount = params.amount
        def label = params.label
        def day = params.day == '30/31' ? 'L' : params.day
        def frequency = new Frequency(code: Frequency.MONTHLY_CODE, cronExpression: "0 1 0 ${day} 1/1 ? *")

        def operation = new PlannedOperation(amount: amount, label: label, frequency: frequency)
        operation.save()

        render template: 'expenseList', model: [operations: PlannedOperation.list()]
    }
}
