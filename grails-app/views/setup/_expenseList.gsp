<ul class="list-group">
    <g:each in="${operations}" var="operation">
        <li class="list-group-item"><span
                class="badge">${operation.amount}</span>${operation.label}</li>
    </g:each>
</ul>