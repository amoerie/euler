package problem031_040

import common.Problem
import annotation.tailrec

/**
 * 145 is a curious number, as 1! + 4! + 5! = 1 + 24 + 120 = 145.
 * Find the sum of all numbers which are equal to the sum of the factorial of their digits.
 * Note: as 1! = 1 and 2! = 2 are not sums they are not included.
 * @author moerie
 */
object Problem34 extends Problem {

    val factorialMap = (0 to 9).map(i => (i, factorial(i))).toMap

    def factorial(n: Int): Int = {
        @tailrec def factorialAcc(acc: Int, n: Int): Int = {
            if (n <= 1) acc
            else factorialAcc(n * acc, n - 1)
        }
        factorialAcc(1, n)
    }

    def isCuriousNumber(i: Int): Boolean = {
        if (i < 3)  false
        else {
            val digits = i.toString.map(d => d.toString.toInt).sortWith(_>_)
            var sumOfFactorials = 0
            for (d <- digits) {
                if (sumOfFactorials > i)
                    return false
                else
                    sumOfFactorials += factorialMap(d)
            }
            sumOfFactorials == i
        }
    }

    def solve() {
        var sum = 0
        for (i <- (3 to 2540160)) {
            if (isCuriousNumber(i)) {
                sum += i
                println("sum  " + sum)
            }
        }
        println("sum = " + sum)
    }
}
