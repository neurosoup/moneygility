modules = {
    application {
        resource url:'js/application.js'
    }

    mm {
        dependsOn 'bootstrap'
        resource url: [dir: 'css', file: 'mm.css']
    }
}