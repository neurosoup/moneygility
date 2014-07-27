<ul class="list-group" id="expensesList">
    <g:each in="${plan.operations}" var="operation">
        <li class="list-group-item" id="operation-${operation.id}">
            <button type="button" class="close" data-dismiss="alert" onclick="removeOperation(${operation.id})"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <span class="badge">
                ${operation.amount}
            </span>
            ${operation.label}
        </li>
    </g:each>
</ul>
