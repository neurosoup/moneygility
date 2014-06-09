// environment specific settings
environments {
    development {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "fullUser"
                password = "Fr@gile+123"
                databaseName = "fragiledev"
            }
        }
    }
    test {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "notset"
                password = "notset"
                databaseName = "fragiletest"
            }
        }
    }
    production {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "blah"
                password = "blah"
                databaseName = "fragileprod"
            }
        }
    }
}