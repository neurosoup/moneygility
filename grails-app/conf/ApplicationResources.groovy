modules = {
    application {
        resource url:'js/application.js'
    }

    common {
        dependsOn 'bootstrap'
        resource url: [dir: 'css', file: 'common.css']
    }

    bootstrapValidator {
        dependsOn 'bootstrap, jquery'
        resource url: [dir: 'css', file: 'bootstrapValidator.css']
        resource url: [dir: 'js', file: 'bootstrapValidator.js']
    }

    intro {
        dependsOn 'common'
        resource url: [dir: 'css', file: 'intro.css']
    }
}