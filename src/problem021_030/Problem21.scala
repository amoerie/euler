package problem021_030

import util.DivisorUtil
import common.Problem

/**
 * Let d(n) be defined as the sum of proper divisors of n (numbers less than n which divide evenly into n).
 * If d(a) = b and d(b) = a, where a  b, then a and b are an amicable pair and each of a and b are called amicable numbers.
 * For example, the proper divisors of 220 are 1, 2, 4, 5, 10, 11, 20, 22, 44, 55 and 110; therefore d(220) = 284.
 * The proper divisors of 284 are 1, 2, 4, 71 and 142; so d(284) = 220.
 * Evaluate the sum of all the amicable numbers under 10000.
 * @author moerie
 */
object Problem21 extends Problem {
    def solve() {
        def getAmicableNumber(n: Int): Option[Int] = {
            return DivisorUtil.getAmicableNumber(n)
        }

        var amicableNumbers = List[Int]()

        for(i <- 1 to 10000) {
            val amicableNumber = getAmicableNumber(i)
            if (amicableNumber.isDefined && amicableNumber.get != i && !amicableNumbers.contains(i)) {
                println("i = " + i + ", amicable = " + amicableNumber.get)
                amicableNumbers = i :: amicableNumbers
                amicableNumbers = amicableNumber.get :: amicableNumbers
            }
        }

        println(amicableNumbers.sum)
    }
}
