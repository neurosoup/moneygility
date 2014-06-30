package com.moneygility.security

import grails.plugin.springsecurity.SpringSecurityUtils

class UserController extends grails.plugin.springsecurity.ui.UserController{

      def userSearch() {
        def criteria = lookupUserClass().createCriteria()

        //boolean useOffset = params.containsKey('offset')
        setIfMissing 'max', 10, 100
        setIfMissing 'offset', 0

        def userLookup = SpringSecurityUtils.securityConfig.userLookup
        String usernameFieldName = userLookup.usernamePropertyName
        String enabledPropertyName = userLookup.enabledPropertyName
        String accountExpiredPropertyName = userLookup.accountExpiredPropertyName
        String accountLockedPropertyName = userLookup.accountLockedPropertyName
        String passwordExpiredPropertyName = userLookup.passwordExpiredPropertyName

        // TODO: Make this less duplicative
        int totalCount = criteria.count() {
            for (name in [username: usernameFieldName]) {
                if (params[name.key]) {
                    ilike(name.value, params[name.key] + '%')
                }
            }

            for (name in [enabled: enabledPropertyName,
                          accountExpired: accountExpiredPropertyName,
                          accountLocked: accountLockedPropertyName,
                          passwordExpired: passwordExpiredPropertyName]) {
                Integer value = params.int(name.key)
                if (value) {
                    eq(name.value, value == 1)
                }
            }
        }

        Integer max = params.int('max')
        Integer offset = params.int('offset')

        criteria = lookupUserClass().createCriteria()
        def results = criteria.list(max: max, offset: offset) {
            for (name in [username: usernameFieldName]) {
                if (params[name.key]) {
                    ilike(name.value, params[name.key] + '%')
                }
            }

            for (name in [enabled: enabledPropertyName,
                          accountExpired: accountExpiredPropertyName,
                          accountLocked: accountLockedPropertyName,
                          passwordExpired: passwordExpiredPropertyName]) {
                Integer value = params.int(name.key)
                if (value) {
                    eq(name.value, value == 1)
                }
            }

            if(params.sort) {
                order(params.sort, 'asc')
            }
        }
        def model = [results: results, totalCount: totalCount, searched: true]

        // add query params to model for paging
        for (name in ['username', 'enabled', 'accountExpired', 'accountLocked',
                      'passwordExpired', 'sort', 'order']) {
            model[name] = params[name]
        }

        render view: 'search', model: model
    }

}
