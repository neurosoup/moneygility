<html>

<head>
    <title><g:message code='spring.security.ui.resetPassword.title'/></title>
    <meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
</head>

<body>

<div class="container-fluid">

    <div class="row">
        <h1 class="text-center"><g:message code='spring.security.ui.resetPassword.title'/></h1>

        <h2 class="text-center"><g:message code='spring.security.ui.resetPassword.header'/></h2>
    </div>

    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <p class="text-center"><g:message code='spring.security.ui.resetPassword.description'/></p>
        </div>
    </div>

    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <g:form role="form" action='resetPassword' name='resetPasswordForm'>
                <g:hiddenField name='t' value='${token}'/>
                <g:if test='${emailSent}'>
                    <div class="col-sm-12">
                        <div class="alert alert-info">
                            <a class="close" href="${createLink(controller: 'login', action: 'index')}"
                               data-dismiss="alert">&times;</a>
                            <g:message code='spring.security.ui.forgotPassword.sent'/></div>
                    </div>
                </g:if>
                <g:else>
                    <div class=" form-group">
                        <g:passwordField name="password" class="form-control" value="${command?.password}"
                                         bean="${command}"
                                         placeholder="${message(code: 'spring.security.ui.register.password.label')}"/>
                    </div>

                    <div class="form-group">
                        <g:passwordField name="password2" class="form-control" value="${command?.password2}"
                                         bean="${command}"
                                         placeholder="${message(code: 'spring.security.ui.register.password2.label')}"/>
                    </div>

                    <div class="form-group login-action">
                        <g:submitButton name="${message(code: 'spring.security.ui.resetPassword.submit')}"
                                        class="btn btn-primary btn-lg btn-block"/>
                    </div>
                </g:else>
            </g:form>
        </div>
    </div>
</div>

<script>
    $(document).ready(function () {
        $('#password').focus();

        $('#resetPasswordForm').bootstrapValidator({
            message: '',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                password: {
                    message: 'Mot de passe incorrect',
                    validators: {
                        notEmpty: {
                            message: 'La saisie du mot de passe est obligatoire'
                        },
                        stringLength: {
                            min: 8,
                            max: 64,
                            message: 'La longueur du mot de passe doit être comprise entre 8 et 64 caractères'
                        },
                        regexp: {
                            regexp: /${grailsApplication.config.grails.plugin.springsecurity.ui.password.validationRegex}/,
                            message: 'Le mot de passe doit avoir au moins une lettre, un chiffre et un caractère spécial : !@#$%^&'
                        }
                    }
                },
                password2: {
                    message: 'Mot de passe incorrect',
                    validators: {
                        notEmpty: {
                            message: 'La saisie du mot de passe est obligatoire'
                        },
                        stringLength: {
                            min: 8,
                            max: 64,
                            message: 'La longueur du mot de passe doit être comprise entre 8 et 64 caractères'
                        },
                        regexp: {
                            regexp: /${grailsApplication.config.grails.plugin.springsecurity.ui.password.validationRegex}/,
                            message: 'Le mot de passe doit avoir au moins une lettre, un chiffre et un caractère spécial : !@#$%^&'
                        },
                        identical: {
                            field: 'password',
                            message: 'Les mots de passe ne sont pas identiques'
                        }
                    }
                }
            }
        });
    });
</script>

</body>
</html>


</body>
</html>
