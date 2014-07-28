package com.moneygility

import grails.transaction.Transactional

@Transactional
class PlannedOperationService {

    def add(Plan plan, BigDecimal amount, String label, String frequencyCode, String day) {

        def frequency = Frequency.getByCodeAndDay(frequencyCode, day)
        def operation = new PlannedOperation(amount: amount, label: label, frequency: frequency)
        plan.addToOperations(operation)
        plan.save()
    }

    def delete(int id) {
        def operation = PlannedOperation.get(id)
        operation.delete()
    }
}
