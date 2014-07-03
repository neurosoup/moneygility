<html>

<head>
    <r:require module="intro"/>
    <r:require module="forms"/>
    <title><g:message code='moneygility.setup.expenses.title'/></title>
</head>

<body>
<div class="container-fluid">

    <div class="row">
        <h1 class="text-center"><g:message code='moneygility.setup.expenses.title'/><span><g:message
                code='moneygility.setup.step1'/></span></h1>

        <h2 class="text-center">
            <span class="glyphicon glyphicon-ok-sign"></span>
            <g:message code='moneygility.setup.expenses.description'/>
        </h2>

        <div class="spacer-big"></div>

    </div>

    <div class="row login-action">

        <div class="row">
            <div class="col-sm-8 col-sm-offset-2">
                <p><g:message code='moneygility.setup.expenses.intro'/></p>

                <div class="spacer-medium"></div>
            </div>
        </div>

        <div class="row">
            <div class="col-sm-4 col-sm-offset-2">

                <g:form role="form" name='registerForm' action="addoperation">

                    <div class="form-group">
                        <g:textField name="label" class="form-control"
                                     placeholder="${message(code: 'moneygility.setup.expenses.addoperation.label')}"/>
                    </div>


                    <div class="form-group">
                        <input type="number" class="form-control" name="amount"
                               placeholder="${message(code: 'moneygility.setup.expenses.addoperation.amount.label')}"/>
                    </div>

                    <div class="form-group">

                        <select class="selectpicker" data-title="Fréquence">
                            <option><g:message code="moneygility.operation.frequency.monthly"/></option>
                            <option>Ketchup</option>
                            <option>Relish</option>
                        </select>

                    </div>

                    <div class="form-group">

                        <g:submitToRemote
                                url="[action: 'addoperation']"
                                value="${message(code: 'moneygility.setup.expenses.addoperation.submit')}"
                                class="btn btn-primary btn-lg btn-block"/>

                        <div class="spacer-small"></div>

                        <g:actionSubmit action="income"
                                        name="${message(code: 'moneygility.setup.expenses.nomoreoperation')}"
                                        class="btn btn-primary btn-lg btn-block" value="45"/>

                    </div>

                </g:form>

            </div>

            <div class="col-sm-4">
                <div class="row">
                    <div class="col-sm-1">
                        <div class="vertical-divider hidden-xs"></div>

                        <div class="horizontal-divider visible-xs"></div>
                    </div>

                    <div class="col-sm-10">
                        <div id="operations">
                            <ul class="list-group">
                                <g:each in="${operations}" var="operation">
                                    <li class="list-group-item"><span
                                            class="badge">${operation.value}</span>${operation.label}</li>
                                </g:each>
                            </ul>
                        </div>
                    </div>
                </div>

            </div>

        </div>
    </div>
</div>

<g:javascript>
    $(document).ready(function () {

        $('#username').focus();

        $('.selectpicker').selectpicker();

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

    });

</g:javascript>

</body>
</html>
