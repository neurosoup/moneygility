modules = {
    application {
        resource url: 'js/application.js'
    }

    common {
        dependsOn 'bootstrap', 'application'
        resource url: [dir: 'css', file: 'common.css']
    }

    bootstrapValidator {
        dependsOn 'bootstrap, jquery'
        resource url: [dir: 'css', file: 'bootstrapValidator.css']
        resource url: [dir: 'js', file: 'bootstrapValidator.js']
    }

    bootstrapSelect {
        resource url: [dir: 'css', file: 'bootstrap-select.css']
        resource url: [dir: 'js', file: 'bootstrap-select.js']
    }

    forms {
        dependsOn 'bootstrapValidator, bootstrapSelect'
        resource url: [dir: 'css', file: 'forms.css']
    }

    intro {
        dependsOn 'common'
        resource url: [dir: 'css', file: 'intro.css']
    }
}