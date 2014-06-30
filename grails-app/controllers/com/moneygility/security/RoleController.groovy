package com.moneygility.security

import grails.plugin.springsecurity.SpringSecurityUtils

class RoleController extends grails.plugin.springsecurity.ui.RoleController {

    def roleSearch() {

        String authorityField = SpringSecurityUtils.securityConfig.authority.nameField

        boolean useOffset = params.containsKey('offset')
        setIfMissing 'max', 10, 100
        setIfMissing 'offset', 0

        String name = params.authority ?: 'ROLE_'
        def roles = doSearch(name, false, 10, params.int('offset'))
        if (roles.size() == 1 && !useOffset) {
            forward action: 'edit', params: [name: roles[0][authorityField]]
            return
        }

        int total = lookupRoleClass().createCriteria().count() {
            ilike(authorityField, "%${name}%")
        }

        render view: 'search', model: [results: roles,
                                       totalCount: total,
                                       authority: params.authority,
                                       searched: true]
    }

    protected doSearch(String name, boolean nameOnly, Integer max, Integer offset) {
        String authorityField = SpringSecurityUtils.securityConfig.authority.nameField

        def criteria = lookupRoleClass().createCriteria()
        return criteria.list(max: max, offset: offset, sort:authorityField) {
            if(nameOnly) {
                projections {
                    distinct(authorityField)
                }
            }
            ilike(authorityField, "%${name}%")
        }
    }
}
