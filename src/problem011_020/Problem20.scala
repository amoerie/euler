package problem011_020

import common.Problem

/**
 * n! means n  (n  1)  ...  3  2  1
 * For example, 10! = 10  9  ...  3  2  1 = 3628800,
 * and the sum of the digits in the number 10! is 3 + 6 + 2 + 8 + 8 + 0 + 0 = 27.
 * Find the sum of the digits in the number 100!
 * @author moerie
 */
object Problem20 extends Problem {
    def solve() {
        def factorial(n: BigInt): BigInt = if (n == 1) 1 else n * factorial(n - 1)
        println(factorial(100).toString().map(n => Integer.parseInt(n.toString)).sum)
    }
}
