import com.moneygility.Frequency
import com.moneygility.OperationTemplate

class BootStrap {

    def init = { servletContext ->

        //Add the default frequencies
        if (!OperationTemplate.findByLabel(Frequency.MONTHLY_CODE)) {
            def operation = new OperationTemplate(label: Frequency.MONTHLY_CODE, kind: 'frequency', frequency: Frequency.getMonthly(1))
            operation.save()
        }

    }

    def destroy = {
    }
}
