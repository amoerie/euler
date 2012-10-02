package problem021_030

import common.Problem

/**
 * Surprisingly there are only three numbers that can be written as the sum of fourth powers of their digits:
 * 1634 = 1&#94;4 + 6&#94;4 + 3&#94;4 + 4&#94;4
 * 8208 = 8&#94;4 + 2&#94;4 + 0&#94;4 + 8&#94;4
 * 9474 = 9&#94;4 + 4&#94;4 + 7&#94;4 + 4&#94;4
 * As 1 = 1&#94;4 is not a sum it is not included.
 *
 * The sum of these numbers is 1634 + 8208 + 9474 = 19316.
 * Find the sum of all the numbers that can be written as the sum of fifth powers of their digits.
 * @author moerie
 */
object Problem30 extends Problem {

    val limit = 1000000
    val power = 5

    def solve() {
        println((2 to limit).filter(i => i == i.toString.map(s => math.pow(Integer.parseInt(s.toString), power)).sum).sum)
    }
}
