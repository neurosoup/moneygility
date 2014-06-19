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
        <h2 class="text-center"><g:message code='springSecurity.login.header'/></h2>
    </div>

    <div class="row login-action">
        %{--<div class="col-sm-4 col-sm-offset-1">

        </div>--}%
        <div class="col-sm-4 col-sm-offset-1">
            <g:if test="${params.login_error == '1'}">
                <div class="alert alert-danger">
                    <button type="button" class="close" data-dismiss="alert">&times;</button>
                    <g:message code="springSecurity.errors.login.fail"/></div>
            </g:if>
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
                    <label>
                        <g:checkBox name="${rememberMeParameter}" id="remember_me" checked="checked"/>
                        <g:message code="springSecurity.login.remember.me.label"/>
                    </label>
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
            <div class="vertical-divider hidden-xs">
                <span>Ou</span>
            </div>
            <div class="horizontal-divider visible-xs">
                <span>Ou</span>
            </div>
        </div>

        <div class="col-sm-5 text-center-xs">
            <sec:ifNotGranted roles="ROLE_USER">
                <facebookAuth:connect />
            </sec:ifNotGranted>
            <sec:ifAllGranted roles="ROLE_USER">
                Welcome <sec:username/>! (<g:link uri="/j_spring_security_logout">Logout</g:link>)
            </sec:ifAllGranted>
        </div>

    </div>
</div>


<script>
    $(document).ready(function () {
        $('#username').focus();
    });
</script>

</body>
</html>
