<html>

<head>
    <link rel="stylesheet" type="text/css" href="web-app/css/intro.css"/><meta name='layout' content='intro'/>
    <r:require module="bootstrapValidator"/>
    <title><g:message code='moneygility.setup.expenses.title'/></title>
</head>

<body>
<div class="container-fluid">

    <div class="row">
        <h1 class="text-center">
            <g:message code='moneygility.setup.expenses.title'/>
            <span><g:message code='moneygility.setup.step1'/></span>
        </h1>

        <h2 class="text-center">
            <span class="glyphicon glyphicon-ok-sign"></span>
            <g:message code='moneygility.setup.expenses.description'/>
        </h2>

        <div class="spacer-big"/>

    </div>

    <div class="row login-action">
        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <p class=""><g:message code='moneygility.setup.expenses.intro'/></p>

                <div class="spacer-medium"/>

            </div>
        </div>

        <div class="row">
            <div class="col-sm-4 col-sm-offset-2">
                <g:form role="form" action='register' name='registerForm'>

                    <div class="form-group">
                        <g:textField name="operation" class="form-control"
                                     placeholder="${message(code: 'moneygility.setup.expenses.addoperation.label')}"/>
                    </div>

                    <div class="form-group">
                        <input type="number" class="form-control" name="operationvalue"
                               placeholder="${message(code: 'moneygility.setup.expenses.addoperation.amount.label')}"/>
                    </div>

                    <div class="form-group login-action">
                        <g:submitButton
                                name="${message(code: 'moneygility.setup.expenses.addoperation.submit')}"
                                class="btn btn-primary btn-lg btn-block"/>
                    </div>

                </g:form>
            </div>

            <div class="col-sm-4">

                <div class="row">
                    <p>La liste...</p>
                </div>

                <div class="row">
                    <div class="form-group login-action">
                        <g:submitButton
                                name="${message(code: 'moneygility.setup.next.label')}"
                                class="btn btn-primary btn-lg btn-block"/>
                    </div>
                </div>

            </div>

        </div>
    </div>

    <script>
        $(document).ready(function () {
            $('#username').focus();
        });

        $('#registerForm').bootstrapValidator({
            message: '',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                operationvalue: {
                    message: '${message(code: "moneygility.setup.expenses.addoperation.amount.invalid")}',
                    validators: {
                        notEmpty: {
                            message: '${message(code: "moneygility.setup.expenses.addoperation.amount.mandatory")}'
                        },
                        regexp: {
                            regexp: /^\d$/,
                            message: '${message(code: "moneygility.setup.expenses.addoperation.amount.mustbeanumber")}'
                        }
                    }
                }
            }
        });

    </script>

</body>
</html>
