import com.moneygility.Frequency


class BootStrap {

    def init = { servletContext ->

        if (!Frequency.findByCode("moneygility.frequency.monthly")) {
            new Frequency(code:"moneygility.frequency.monthly", cronExpression: '0 0 1 1 1/1 ? *')
        }

    }

    def destroy = {
    }
}
