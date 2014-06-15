<html>

<head>
    <title><g:message code='springSecurity.login.title'/></title>
    <meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
</head>

<body>
<div class="container">

    <div class="row">
        <h1 class="text-center"><g:message code='springSecurity.login.title'/></h1>

        <h2 class="text-center"></h2>

        <div class="col-sm-4 col-sm-offset-4">
            <g:if test="${params.login_error == '1'}">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <g:message code="springSecurity.errors.login.fail"/></div>
            </g:if>
        </div>
    </div>


    <div class="row login-action">
        <div class="col-sm-4 col-sm-offset-1">
            <form role="form" action='${postUrl}' method='POST' id="loginForm" name="loginForm" autocomplete='off'>
                <div class="form-group">
                    <g:textField name="j_username" id="username" class="form-control"
                                 placeholder="${message(code: 'springSecurity.login.username.label')}"/>
                </div>

                <div class="form-group">
                    <g:passwordField name="j_password" id="password" class="form-control"
                                     placeholder="${message(code: 'springSecurity.login.password.label')}"/>
                </div>

                <div class="checkbox">
                    <g:checkBox name="${rememberMeParameter}" id="remember_me" checked="checked"
                                placeholder="${message(code: 'springSecurity.login.remember.me.label')}"/>
                </div>


                <div class="form-group login-action">

                    <div class="form-group col-sm-6">
                        <g:submitButton name="${message(code: 'springSecurity.login.button')}"
                                        class="btn btn-primary btn-lg btn-block"/>
                    </div>

                    <div class="form-group col-sm-6">
                        <div class="row">
                            <span class="forgot-link">
                                <g:link controller='register' action='forgotPassword'>
                                    <g:message code='spring.security.ui.login.forgotPassword'/>
                                </g:link>
                            </span>
                        </div>

                        <div class="row">
                            <g:link id="register" controller="register" action="index">
                                <g:message code='spring.security.ui.login.register'/>
                            </g:link>
                            <script>
                                $(document).ready(function () {
                                    $("#register").button();
                                });
                            </script>

                        </div>
                    </div>

                </div>

            </form>
        </div>

        <div class="col-sm-2">
            <p class="divider"><span>Ou</span></p>
        </div>

        <div class="col-sm-5">
            <sec:ifNotGranted roles="ROLE_USER">
                <facebookAuth:connect class="facebook-login btn-primary"/>
            </sec:ifNotGranted>
        </div>

    </div>
</div>


<script>
    $(document).ready(function () {
        $('#username').focus();

        /*$('#loginForm').bootstrapValidator({
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
         });*/
    });

</script>

</body>
</html>
