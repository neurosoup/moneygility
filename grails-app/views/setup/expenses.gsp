<%@ page import="com.moneygility.Operation" %>

<html>

<head>
    <meta name='layout' content='intro'/>
    <r:require module="intro"/>
    <r:require module="forms"/>
    <title><g:message code='moneygility.setup.expenses.title'/></title>
</head>

<body>
<div class="container-fluid">

    <div class="row">
        <h1 class="text-center"><g:message code='moneygility.setup.expenses.title'/><span><g:message
                code='moneygility.setup.expenses.step'/></span></h1>

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

                <g:form role="form" name='addOperationForm' action="addoperation">

                    <div class="form-group">
                        <input type="text" class="form-control" name="label"
                               placeholder="${message(code: 'moneygility.setup.expenses.addoperation.label')}"/>
                    </div>


                    <div class="form-group">
                        <input type="text" class="form-control" name="amount"
                               placeholder="${message(code: 'moneygility.setup.expenses.addoperation.amount.label')}"/>
                    </div>

                    <div class="form-group">

                        <div class="row">
                            <div class="col-sm-6">
                                <g:select
                                        class="selectpicker" data-title="Fréquence"
                                        name="frequency"
                                        from="${Operation.list().frequency}"
                                        optionKey="code"
                                        valueMessagePrefix="moneygility.frequency"/>
                            </div>

                            <div class="col-sm-4">
                                <div class="input-group">
                                    <input id="day" name="day" type="text" class="form-control" placeholder="${message(code: 'moneygility.setup.expenses.addoperation.day')}">

                                    <div class="input-group-btn">
                                        <button id="dayselect" type="button" class="btn btn-default popover-dismiss"
                                                data-toggle="popover" data-placement="right"><span
                                                class="glyphicon glyphicon-th"></span></span>
                                        </button>
                                        <g:render template="/components/daySelector"
                                                  model="[triggerId: 'dayselect', inputId: 'day']"/>
                                    </div><!-- /btn-group -->
                                </div><!-- /input-group -->

                            </div>
                        </div>

                    </div>

                    <div class="form-group">

                        <g:submitToRemote
                                id="btnaddoperation"
                                url="[action: 'addoperation']"
                                class="btn btn-primary btn-lg btn-block"
                                update="operations"
                                value="${message(code: 'moneygility.setup.expenses.addoperation.submit')}"/>

                        %{--<div class="spacer-small"></div>--}%

                        %{--<g:actionSubmit action="income"
                                        name="${message(code: 'moneygility.setup.expenses.nomoreoperation')}"
                                        class="btn btn-primary btn-lg btn-block" value="45"/>--}%

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
                            <p>Will be updated</p>
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

        $('.selectpicker').selectpicker({
            style: 'btn-default'
        });

        $("#dayselect").popover({
            html : true,
            content: function() {
                return $('.day-selector-content').html();
            }
        });

        $('#btnaddoperation').prop('disabled', true);
        $('#addOperationForm').bootstrapValidator({
            trigger: 'keyup',
            live: 'enabled',
            submitButtons: '#btnaddoperation',
            message: '',
            feedbackIcons: {
                valid: 'glyphicon glyphicon-ok',
                invalid: 'glyphicon glyphicon-remove',
                validating: 'glyphicon glyphicon-refresh'
            },
            fields: {
                label : {
                    validators: {
                        notEmpty: {
                            message: "${message(code: 'moneygility.setup.expenses.label.mandatory')}"
                        }/*,
                        remote: {
                            message: "${message(code: 'moneygility.setup.expenses.label.mandatory')}",
                              url: '${createLink(action: 'validate')}',
                            data: {
                                field: 'label'
                            }
                        }*/
                    }
                },
                amount: {
                    message: "${message(code: 'moneygility.setup.expenses.addoperation.amount.invalid')}",
                    validators: {
                        notEmpty: {
                            message: "${message(code: 'moneygility.setup.expenses.addoperation.amount.mandatory')}"
                        },
                        regexp: {
                            regexp: /^\d+$/,
                            message: "${message(code: 'moneygility.setup.expenses.addoperation.amount.mustbeanumber')}"
                        }
                    }
                }
            }
        });

    });

</g:javascript>

</body>
</html>
