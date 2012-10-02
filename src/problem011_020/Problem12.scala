package problem011_020

import util.PrimeUtil
import common.Problem

/**
 * The sequence of triangle numbers is generated by adding the natural numbers.
 * So the 7th triangle number would be 1 + 2 + 3 + 4 + 5 + 6 + 7 = 28.
 *
 * The first ten terms would be:
 * 1, 3, 6, 10, 15, 21, 28, 36, 45, 55, ...
 *
 * Let us list the factors of the first seven triangle numbers:
 * 1: 1
 * 3: 1,3
 * 6: 1,2,3,6
 * 10: 1,2,5,10
 * 15: 1,3,5,15
 * 21: 1,3,7,21
 * 28: 1,2,4,7,14,28
 *
 * We can see that 28 is the first triangle number to have over five divisors.
 * What is the value of the first triangle number to have over five hundred divisors?
 * @author moerie
 */
object Problem12  extends Problem {

    val STEP = 500

    def solve() {
        def getNumberOfDivisors(n: Long): Int = {
            val root = math.sqrt(n).toInt
            val factors = (1 to root).filter(i => n % i == 0).length * 2
            if (root * root == n) factors - 1
            else factors
        }

        def getTriangleNumber(n: Int): Long = {
            return (n * (n + 1)) / 2
        }

        var count = 1
        var triangle = getTriangleNumber(count)
        var divisors = getNumberOfDivisors(triangle)
        while (divisors < STEP) {
            count += 1
            triangle = getTriangleNumber(count)
            divisors = getNumberOfDivisors(triangle)
            println("Triangle = " + triangle + " , divisors = " + divisors)
        }


    }
}