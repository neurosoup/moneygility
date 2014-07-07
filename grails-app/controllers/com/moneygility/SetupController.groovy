package com.moneygility

class SetupController {

    def springSecurityService

    def index() {

        def user = springSecurityService.currentUser

        //Create default person associated with the current login
        //Have to add a new screen for choosing personal information
        def person = new Person(user: user)

        //Create first plan associated with the newly created person
        def plan = new Plan(label: message(code: 'moneygility.setup.expenses.firstplan.label'))
        person.plans.add(plan)
        person.activePlan = plan

        //save the whole
        person.save(flush: true)

        //Go to the first step of setup
        render view: 'expenses'
    }

    def expenses() {}

    def addoperation()
    {
        def amount = params.amount
        def label = params.label
        def frequency = new Frequency(code:Frequency.MONTHLY_CODE, cronExpression: '0 1 0 ${params.day} 1/1 ? *')

        def operation = new PlannedOperation(amount: amount, label: label, frequency: frequency)
        operation.save(flush: true)

        render template: 'expenseList', model: [operations : PlannedOperation.list()]
    }
}
