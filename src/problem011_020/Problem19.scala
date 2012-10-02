package problem011_020

import org.joda.time.{DateTimeConstants, LocalDate}
import common.Problem

/**
 * You are given the following information, but you may prefer to do some research for yourself.
 * 1 Jan 1900 was a Monday.
 * Thirty days has September,
 * April, June and November.
 * All the rest have thirty-one,
 * Saving February alone,
 * Which has twenty-eight, rain or shine.
 * And on leap years, twenty-nine.
 * A leap year occurs on any year evenly divisible by 4, but not on a century unless it is divisible by 400.
 * How many Sundays fell on the first of the month during the twentieth century (1 Jan 1901 to 31 Dec 2000)?
 * @author moerie
 */
object Problem19 extends Problem {

    def solve() {
        /* Don't reinvent the wheel, use Joda Time 8-) */
        var date = new LocalDate(1901, 1, 1)
        val end = new LocalDate(2000, 12, 31)
        var numberOfSundaysOnTheFirstDayOfTheMonth = 0
        while (date.compareTo(end) <= 0) {
            if (date.getDayOfWeek == DateTimeConstants.SUNDAY) {
                numberOfSundaysOnTheFirstDayOfTheMonth += 1
            }
            date = date.plusMonths(1)
        }
        println(numberOfSundaysOnTheFirstDayOfTheMonth)
    }

}
