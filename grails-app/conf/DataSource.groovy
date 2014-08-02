// environment specific settings
environments {
    development {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "fullUser"
                password = "Fr@gile+123"
                databaseName = "moneygility-dev"
            }
        }
    }
    test {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "fullUser"
                password = "Fr@gile+123"
                databaseName = "moneygility-test"
            }
        }
    }
    production {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "fullUser"
                password = "Fr@gile+123"
                databaseName = "moneygility"
            }
        }
    }
}