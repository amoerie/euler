package problem011_020

import common.Problem

/**
 * If the numbers 1 to 5 are written out in words: one, two, three, four, five,
 * then there are 3 + 3 + 5 + 4 + 4 = 19 letters used in total.
 * If all the numbers from 1 to 1000 (one thousand) inclusive were written out in words, how many letters would be used?
 *
 * NOTE: Do not count spaces or hyphens.
 * For example, 342 (three hundred and forty-two) contains 23 letters and 115 (one hundred and fifteen) contains 20 letters.
 * The use of "and" when writing out numbers is in compliance with British usage.
 * @author moerie
 */
object Problem17  extends Problem {
    val numbersUnderTwenty = Map(
        1 -> "one", 2 -> "two", 3 -> "three", 4 -> "four", 5 -> "five",
        6 -> "six", 7 -> "seven", 8 -> "eight", 9 -> "nine", 10 -> "ten",
        11 -> "eleven", 12 -> "twelve", 13 -> "thirteen", 14 -> "fourteen", 15 -> "fifteen",
        16 -> "sixteen", 17 -> "seventeen", 18 -> "eighteen", 19 -> "nineteen"
    )

    val tens = Map(
        20 -> "twenty", 30 -> "thirty", 40 -> "forty", 50 -> "fifty", 60 -> "sixty",
        70 -> "seventy", 80 -> "eighty", 90 -> "ninety"
    )

    val powers = Map(
        100 -> "hundred",
        1000 -> "thousand"
    )

    def solve() {

        def getNumberAsString(n: Int): String = {
            if (n < 20)
                numbersUnderTwenty(n)
            else if (n < 100) {
                val multipleOfTen = (math.floor(n / 10) * 10).toInt
                val remaining = n - multipleOfTen
                tens(multipleOfTen) + (if (remaining != 0) "-" + getNumberAsString(n - multipleOfTen) else "")
            } else if (n < 1000) {
                val multipleOfHundred = (math.floor(n / 100) * 100).toInt
                val remaining = n - multipleOfHundred
                numbersUnderTwenty(multipleOfHundred / 100) + " " + powers(100) +
                    (if (remaining != 0)
                        " and " + getNumberAsString(n - multipleOfHundred)
                    else
                        "")
            } else if (n == 1000) {
                return numbersUnderTwenty(1) + " " + powers(1000)
            } else ""
        }

        def count(numberAsString: String): Int = {
            numberAsString.replace(" ", "").replace("-", "").length
        }

        println((1 to 1000).map(i => getNumberAsString(i)).map(s => count(s)).sum)
    }

}
