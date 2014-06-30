<html>

<head>
    <meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
    <title><g:message code='moneygility.setup.expenses.title'/></title>
</head>

<body>
<div class="container-fluid">

    <div class="row">
        <h1 class="text-center"><g:message code='moneygility.setup.expenses.title'/></h1>

        <h2 class="text-center"><g:message code='moneygility.setup.expenses.description'/></h2>
    </div>

    <div class="row login-action">
        <div class="col-sm-4 col-sm-offset-4">
            <g:form role="form" action='register' name='registerForm'>
                <g:if test='${emailSent}'>
                    <div class="col-sm-12">
                        <div class="alert alert-info">
                            <a class="close" href="${createLink(controller: 'login', action: 'index')}"
                               data-dismiss="alert">&times;</a>
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
    });
</script>

</body>
</html>
