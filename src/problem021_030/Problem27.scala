package problem021_030

import _root_.util.PrimeUtil
import common.Problem
import annotation.tailrec

/**
 * Euler published the remarkable quadratic formula:
 *
 * n² + n + 41
 *
 * It turns out that the formula will produce 40 primes for the consecutive values n = 0 to 39.
 * However, when n = 40, 402 + 40 + 41 = 40(40 + 1) + 41 is divisible by 41,
 * and certainly when n = 41, 41² + 41 + 41 is clearly divisible by 41.
 *
 * Using computers, the incredible formula  n²  79n + 1601 was discovered,
 * which produces 80 primes for the consecutive values n = 0 to 79.
 * The product of the coefficients, 79 and 1601, is 126479.
 *
 * Considering quadratics of the form:
 * n² + an + b, where |a|  1000 and |b|  1000
 * where |n| is the modulus/absolute value of n
 * e.g. |11| = 11 and |4| = 4
 * Find the product of the coefficients, a and b,
 * for the quadratic expression that produces the maximum number of primes for consecutive values of n,
 * starting with n = 0.
 * @author moerie
 */
object Problem27 extends Problem {

    val limit = 1000

    def solve() {
        /**
         * Some math theory first:
         * We are looking for values a and b, where both a and be are between -1000 and 1000
         * and where from n = 0 .. x every value n² + a * n + b is a prime until x
         * We are looking for values a and b so to maximize X
         *
         * Important to note is that n starts at 0, which means
         * 0² + a * 0 + b has to be a prime
         * which means b has to be a prime
         * which means b has to be a positive number
          */

        /**
         * This list will be used to find possible values for b (since b has to be a positive prime under the limit
         * but also as a cache to check if certain numbers under 1000 are prime
         */
        val primesUnderLimit = PrimeUtil.getPrimesList(limit - 1)
        val primesSet = primesUnderLimit.toSet

        /**
         * This list is used to iterate over possible values of a
         */
        val listOfPossibleAValues = (-limit + 1 to limit - 1)

        def isPrime(n: Int): Boolean = {
            primesSet.contains(n) || PrimeUtil.isPrime(n)
        }

        def f(a: Int, b: Int, n: Int) = {
            n * n + a * n + b
        }

        def getNumberConsecutivePrimes(a: Int, b:Int, n: Int = 0): Int = {
            if (isPrime(f(a,b,n)))  1 + getNumberConsecutivePrimes(a,b,n+1)
            else                    0
        }

        println(listOfPossibleAValues.map(a => primesUnderLimit.map(b => (a,b)))
            .flatten
            .maxBy { case(a,b) => getNumberConsecutivePrimes(a,b) }
        )
    }
}
