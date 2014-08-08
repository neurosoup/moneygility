// environment specific settings
environments {
    development {
        grails {
            mongo {
                host = "ks313064.kimsufi.com"
                port = 27017
                username = "fullUser"
                password = "Fr@gile+123"
                databaseName = "moneygilitydev"
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
                databaseName = "moneygilitytest"
            }
            /*dataSource {
                dbCreate = "update"
                url = "jdbc:h2:mem:testDb;MVCC=TRUE;LOCK_TIMEOUT=10000;DB_CLOSE_ON_EXIT=FALSE"
            }*/
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