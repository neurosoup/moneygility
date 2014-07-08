import com.moneygility.Frequency
import com.moneygility.Operation


class BootStrap {

    def init = { servletContext ->

        //Add the default frequencies
        if (!Operation.findByLabel(Frequency.MONTHLY_CODE)) {
            def operation = new Operation(label: Frequency.MONTHLY_CODE, frequency: Frequency.getMonthly(1), amount: 0)

            if (!operation.save()) {
                operation.errors.each {
                    println it
                }
            }
        }

    }

    def destroy = {
    }
}
