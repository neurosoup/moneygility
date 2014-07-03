package com.moneygility

class SetupController {

    static defaultAction = "expenses"

    def index() {}

    def expenses() {}

    def addoperation()
    {
        def p = params
        def operation = new Operation(amount: 120.5, label: 'test', frequency: new Frequency(label: 'Monthly', cronExpression: ''))
        [operation]
    }
}
