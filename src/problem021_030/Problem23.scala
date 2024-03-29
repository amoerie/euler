package problem021_030

import util.{TimeUtil, DivisorUtil}
import common.Problem

/**
 * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
 * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
 *
 * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
 * As 12 is the smallest abundant number, 1 + 2 + 3 + 4 + 6 = 16,
 * the smallest number that can be written as the sum of two abundant numbers is 24.
 * By mathematical analysis, it can be shown that all integers greater than 28123 can be written as the sum of two abundant numbers.
 * However, this upper limit cannot be reduced any further by analysis
 * even though it is known that the greatest number that cannot be expressed as the sum of two abundant numbers is
 * less than this limit.
 *
 * Find the sum of all the positive integers which cannot be written as the sum of two abundant numbers.
 * @author moerie
 */
object Problem23 extends Problem {
    def solve() {
        val UPPER_LIMIT = 28123
        val abundantNumbers = (12 to UPPER_LIMIT).filter(n => DivisorUtil.isAbundant(n))
        val hasAbundantSum = Array.fill(UPPER_LIMIT+1)(false)

        /** slightly similar to the sieve of Eratosthenes */
        for (i <- abundantNumbers; j <- abundantNumbers if((j + i) < hasAbundantSum.length)) {
            hasAbundantSum(i + j) = true
        }
        println(hasAbundantSum.toList.zipWithIndex.filter(a => !a._1).map(a => a._2).sum)
    }
}
