<ul class="list-group">
    <g:each in="${operations}" var="operation">
        <li class="list-group-item">
            <button type="button" class="close" data-dismiss="alert"><span aria-hidden="true">×</span><span class="sr-only">Close</span></button>
            <span class="badge">
                ${operation.amount}
            </span>
            ${operation.label}
        </li>
    </g:each>
</ul>