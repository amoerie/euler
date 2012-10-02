package problem011_020

import util.PrimeUtil
import common.Problem

/**
 * 2 ^ 15 = 32768 and the sum of its digits is 3 + 2 + 7 + 6 + 8 = 26.
 * What is the sum of the digits of the number 2 ^ 1000?
 * @author moerie
 */
object Problem16  extends Problem {
    def solve() {
        def power(n: Int, times: Int): BigInt = if (times == 0) n else n * power(n, times - 1)
        val number = power(2, 1000)
        println(number.toString.map(s => s - '0').sum)

        println(PrimeUtil.getPrimeFactors(500000))
    }
}
