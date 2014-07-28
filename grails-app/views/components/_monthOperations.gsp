<ul class="list-group" id="operationList">
    <g:each in="${plan.operations}" var="operation">
        <li class="list-group-item" id="operation-${operation.id}">
            <button type="button" class="close" data-dismiss="alert"
                    onclick="removeOperationClicked(${operation.id})"><span
                    aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <span class="badge">
                ${operation.amount}
            </span>
            ${operation.label}
        </li>
    </g:each>
</ul>

<g:javascript>

    function removeOperationClicked(id) {
        var baseUrl = "${createLink(controller: controllerName, action: deleteAction)}";
        jQuery.ajax({
            type: "POST",
            url: baseUrl + "?id=" + id
        });
    }

    $(document).ready(function () {
        $('#operationList').sortable();
    });

</g:javascript>