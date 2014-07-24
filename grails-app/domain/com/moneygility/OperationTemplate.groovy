package com.moneygility

class OperationTemplate {

    static constraints = {
    }

    String label
    String kind
    Frequency frequency

    static embedded = ['frequency']

}
