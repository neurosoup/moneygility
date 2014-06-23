<html>

<head>
    <title><g:message code='spring.security.ui.forgotPassword.title'/></title>
    <meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
</head>

<body>

<div class="container-fluid">

    <div class="row">
        <h1 class="text-center"><g:message code='spring.security.ui.forgotPassword.title'/></h1>

        <h2 class="text-center"><g:message code='spring.security.ui.forgotPassword.header'/></h2>
    </div>

    <div class="row login-action">
        <div class="col-sm-4 col-sm-offset-4">
            <g:form role="form" action='forgotPassword' name='forgotPasswordForm'>
                <g:if test='${emailSent}'>
                    <div class="col-sm-12">
                        <div class="alert alert-info">
                            <a class="close" href="${createLink(controller: 'login', action: 'index')}"
                               data-dismiss="alert">&times;</a>
                            <g:message code='spring.security.ui.forgotPassword.sent'/></div>
                    </div>
                </g:if>
                <g:else>
                </g:else>
                <div class="form-group">
                    <g:textField id="username" name="username" class="form-control"
                                 placeholder="${message(code: 'spring.security.ui.forgotPassword.username')}"/>
                </div>

                <div class="form-group login-action">
                    <g:submitButton name="${message(code: 'spring.security.ui.forgotPassword.submit')}"
                                    class="btn btn-primary btn-lg btn-block"/>
                </div>
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



%{--<s2ui:form width='400' height='220' elementId='forgotPasswordFormContainer'
           titleCode='spring.security.ui.forgotPassword.header' center='true'>

    <g:form action='forgotPassword' name="forgotPasswordForm" autocomplete='off'>

        <g:if test='${emailSent}'>
            <br/>
            <g:message code='spring.security.ui.forgotPassword.sent'/>
        </g:if>

        <g:else>

            <br/>
            <h4><g:message code='spring.security.ui.forgotPassword.description'/></h4>

            <table>
                <tr>
                    <td><label for="username"><g:message code='spring.security.ui.forgotPassword.username'/></label>
                    </td>
                    <td><g:textField name="username" size="25"/></td>
                </tr>
            </table>

            <s2ui:submitButton elementId='reset' form='forgotPasswordForm'
                               messageCode='spring.security.ui.forgotPassword.submit'/>

        </g:else>

    </g:form>
</s2ui:form>

--}%