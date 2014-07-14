<div class="day-selector-content">
    <div class="row day-selector">
        <g:each var="i" in="${(1..<31)}">
            <div class="col-xs-1">
                <button data-value="${i}" type="button" class="btn btn-default dismissable-btn" onclick="validate($(this));">${i}</button>
            </div>
        </g:each>
        <div class="col-xs-12">
            <button data-value="30/31" type="button" class="btn btn-primary btn-block dismissable-btn" onclick="validate($(this));">Dernier jour du mois</button>
        </div>
    </div>
</div>

<g:javascript>

    var validate = function (e) {
        $("#dayselect").popover('hide');
        $("#day").val(e.data("value"));
    };

</g:javascript>

