<html>

<head>
    <meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
    <title><g:message code='spring.security.ui.register.title'/></title>
</head>

<body>
<div class="container-fluid">

    <div class="row">
        <h1 class="text-center"><g:message code='spring.security.ui.register.title'/></h1>

        <h2 class="text-center"><g:message code='spring.security.ui.register.description'/></h2>
    </div>

    <div class="row login-action">
        <div class="col-sm-4 col-sm-offset-4">
            <g:form role="form" action='register' name='registerForm'>
                <g:if test='${emailSent}'>
                    <div class="col-sm-12">
                        <div class="alert alert-info">
                            <a class="close" href="${createLink(controller: 'login', action: 'index')}" data-dismiss="alert">&times;</a>
                            <g:message code='spring.security.ui.register.sent'/></div>
                    </div>
                </g:if>
                <g:else>
                    <div class="form-group">
                        <g:textField name="username" class="form-control" value="${command.username}"
                                     placeholder="${message(code: 'spring.security.ui.register.username.label')}"/>
                    </div>

                    <div class="form-group">
                        <input type="email" class="form-control" name="email" value="${command.email}"
                               placeholder="${message(code: 'spring.security.ui.register.email.label')}"/>
                    </div>

                    <div class=" form-group">
                        <g:passwordField name="password" class="form-control" value="${command.password}"
                                         placeholder="${message(code: 'spring.security.ui.register.password.label')}"/>
                    </div>

                    <div class="form-group">
                        <g:passwordField name="password2" class="form-control" value="${command.password2}"
                                         placeholder="${message(code: 'spring.security.ui.register.password2.label')}"/>
                    </div>

                    <div class="form-group login-action">
                        <g:submitButton name="${message(code: 'spring.security.ui.register.submit')}"
                                        class="btn btn-primary btn-lg btn-block"/>
                    </div>
                </g:else>

            </g:form>
        </div>
    </div>
</div>


<script>
    $(document).ready(function () {
        $('#username').focus();

        $('#registerForm').bootstrapValidator({
            message: '',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                username: {
                    message: 'Nom d\'utilisateur incorrect',
                    validators: {
                        notEmpty: {
                            message: 'La saisie du nom d\'utilisateur est obligatoire'
                        },
                        stringLength: {
                            min: 3,
                            max: 30,
                            message: 'La longueur du nom d\'utilisateur doit être comprise entre 3 et 30 caractères'
                        },
                        regexp: {
                            regexp: /^[a-zA-Z0-9_]+$/,
                            message: 'Le nom d\'utilisateur ne peut pas contenir de symboles'
                        }
                    }
                },
                email: {
                    message: 'Email incorrect',
                    validators: {
                        notEmpty: {
                            message: 'La saisie de l\'email est obligatoire'
                        },
                        regexp: {
                            regexp: /^[_a-z0-9-]+(\.[_a-z0-9-]+)*@[a-z0-9-]+(\.[a-z0-9-]+)*(\.[a-z]{2,4})$/,
                            message: 'Ceci ne ressemble pas à une adresse email valide !'
                        }
                    }
                },
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
                            regexp: /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[+!@#$%^&]).*$/,
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
                            regexp: /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[+!@#$%^&]).*$/,
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
