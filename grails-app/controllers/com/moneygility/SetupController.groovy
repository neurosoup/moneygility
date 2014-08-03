package com.moneygility

import com.moneygility.security.User
import org.joda.time.DateTime

class SetupController {

    def springSecurityService
    def seriesService

    def index() {

        def user = springSecurityService.currentUser as User

        //Create default person associated with the current login
        //Have to add a new screen for choosing personal information
        def person = Person.findByUser(user) ?: new Person(user: user, firstName: 'John', lastName: 'Doe')

        //Create first plan associated with the newly created person
        def plan = Plan.findByPersonAndIsActive(person, true)

        if (!plan) {

            def now = DateTime.now()
            def past = new DateTime(now.year, now.monthOfYear, 1, 0, 1)
            def future = new DateTime(now.year + 2, 12, 31, 0, 0)

            plan = new Plan(
                    label: message(code: 'moneygility.setup.expenses.firstplan.label'),
                    isActive: true,
                    start: past,
                    end: future)

            person.addToPlans(plan)
            person.save()
        }

        //Go to the first step of setup
        render view: 'expenses', model: [plan: plan, deleteAction: 'deleteOperation']
    }

    def expenses() {}

    def addOperation() {

        BigDecimal amount = params.int('amount').toBigDecimal()
        String label = params.label
        String day = params.day ? params.day == '30/31' ? 'L' : params.day : grailsApplication.config.moneygility.operations.periodic.startday
        String frequencyCode = params.frequency
        Plan plan = Plan.get(params.int('planId'))

        seriesService.create(plan, amount, label, frequencyCode, day)

        render template: '/components/monthOperations', model: [plan: plan, deleteAction: 'deleteOperation']
    }

    def deleteOperation() {
        int id = params.int('id')
        seriesService.deleteByOperationId(id)
    }
}
