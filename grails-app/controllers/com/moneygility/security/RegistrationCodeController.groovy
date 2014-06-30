package com.moneygility.security

import grails.plugin.springsecurity.ui.RegistrationCode

class RegistrationCodeController extends grails.plugin.springsecurity.ui.RegistrationCodeController {

    def registrationCodeSearch() {

        //boolean useOffset = params.containsKey('offset')
        setIfMissing 'max', 10, 100
        setIfMissing 'offset', 0

        int totalCount = RegistrationCode.createCriteria().count() {
            if(params.token) {
                ilike('token', params.token + '%')
            }
            if(params.username) {
                ilike('username', params.username + '%')
            }
        }

        Integer max = params.int('max')
        Integer offset = params.int('offset')

        def results = RegistrationCode.createCriteria().list(max: max, offset: offset) {
            if(params.token) {
                ilike('token', params.token + '%')
            }
            if(params.username) {
                ilike('username', params.username + '%')
            }
            if(params.sort) {
                // TODO: Check to see if case matters here, old code used ASC, view may need updating
                order(params.sort, params.order ?: 'asc')
            }
        }

        def model = [results: results, totalCount: totalCount, searched: true]

        // add query params to model for paging
        for (name in ['username', 'token']) {
            model[name] = params[name]
        }

        render view: 'search', model: model
    }

}
