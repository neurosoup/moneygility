import com.moneygility.Frequency

class BootStrap {

    def grailsApplication
    def frequencyService

    def init = { servletContext ->

        //Add the default frequencies
        if (!Frequency.findByCode("${grailsApplication.config.moneygility.frequency.monthly.code}")) {
            def frequency = frequencyService.getMonthly()
            frequency.save()
        }

    }

    def destroy = {
    }
}
