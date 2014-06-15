<html>

<head>
    <meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
    <title><g:message code='spring.security.ui.register.title'/></title>
</head>

<body>

<div class="container">

    <div class="row">
        <h1 class="text-center"><g:message code='spring.security.ui.register.title'/></h1>

        <h2 class="text-center"></h2>
    </div>

    <div class="row">
        <div class="col-sm-4 col-sm-offset-4">
            <g:form role="form" action='register' name='registerForm'>
                <g:if test='${emailSent}'>
                    <div class="col-sm-4 col-sm-offset-4">
                        <div class="alert alert-info">
                            <button type="button" class="close" data-dismiss="alert">&times;</button>
                            <g:message code='spring.security.ui.register.sent'/></div>
                    </div>
                </g:if>
                <g:else>
                    <div class="form-group">
                        <label for="username"><g:message code='user.username.label'/></label>
                        <g:textField name="username" class="form-control" value="${command.username}"/>
                    </div>

                    <div class="form-group">
                        <label for="email"><g:message code='user.email.label'/></label>
                        <input type="email" class="form-control" name="email" value="${command.email}"/>
                    </div>

                    <div class=" form-group">
                        <label for="password"><g:message code='user.password.label'/></label>
                        <g:passwordField name="password" class="form-control" value="${command.password}"/>
                    </div>

                    <div class="form-group">
                        <label for="password2"><g:message code='user.password2.label'/></label>
                        <g:passwordField name="password2" class="form-control" value="${command.password2}"/>
                    </div>

                    <div class="form-group login-action">
                        <g:submitButton name="${message(code: 'spring.security.ui.register.submit')}"
                                        class="btn btn-primary btn-lg"/>
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
                j_username: {
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
                j_email: {
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
                j_password: {
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
                            regexp: /^.*(?=.*\d)(?=.*[a-zA-Z])(?=.*[!@#$%^&]).*$/,
                            message: 'Le mot de passe doit avoir au moins une lettre, un chiffre et un caractère spécial : !@#$%^&'
                        }
                    }
                }
            }
        });
    });

</script>


<p></p>

%{--<s2ui:form width='650' height='300' elementId='loginFormContainer'
           titleCode='spring.security.ui.register.description' center='true'>--}%
%{--
<g:form action='register' name='registerForm'>

    <g:if test='${emailSent}'>
        <br/>
        <g:message code='spring.security.ui.register.sent'/>
    </g:if>
    <g:else>

        <br/>

        <table>
            <tbody>

            <s2ui:textFieldRow name='username' labelCode='user.username.label' bean="${command}"
                               size='40' labelCodeDefault='Username' value="${command.username}"/>

            <s2ui:textFieldRow name='email' bean="${command}" value="${command.email}"
                               size='40' labelCode='user.email.label' labelCodeDefault='E-mail'/>

            <s2ui:passwordFieldRow name='password' labelCode='user.password.label' bean="${command}"
                                   size='40' labelCodeDefault='Password' value="${command.password}"/>

            <s2ui:passwordFieldRow name='password2' labelCode='user.password2.label' bean="${command}"
                                   size='40' labelCodeDefault='Password (again)' value="${command.password2}"/>

            </tbody>
        </table>

        <s2ui:submitButton elementId='create' form='registerForm' messageCode='spring.security.ui.register.submit'/>

    </g:else>

</g:form>

</s2ui:form>--}%

<script>
    $(document).ready(function () {
        $('#username').focus();
    });
</script>

</body>
</html>
