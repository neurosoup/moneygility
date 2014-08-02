package com.moneygility

import grails.transaction.Transactional

@Transactional
class CalendarService {

    private def getCalendar() {
        def timeZone = TimeZone.getTimeZone("Europe/Paris")
        def locale = Locale.FRANCE
        GregorianCalendar.getInstance(timeZone, locale)
    }

    def getNow() {
        calendar.setTime(new Date())
        calendar
    }

    def getFromNow(int field, int amount) {
        now.add(field, amount)
        now
    }

    def getWhen(Date time) {
        calendar.setTime(time)
        calendar
    }

    def getWhen(int year, int month, int date) {
        calendar.set(year, month, date)
        calendar
    }

}
