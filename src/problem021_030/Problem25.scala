package problem021_030

import util.TimeUtil
import common.Problem

/**
 * The Fibonacci sequence is defined by the recurrence relation:
 * Fn = Fn1 + Fn2, where F1 = 1 and F2 = 1.
 *
 * Hence the first 12 terms will be:
 * F1 = 1
 * F2 = 1
 * F3 = 2
 * F4 = 3
 * F5 = 5
 * F6 = 8
 * F7 = 13
 * F8 = 21
 * F9 = 34
 * F10 = 55
 * F11 = 89
 * F12 = 144
 *
 * The 12th term, F12, is the first term to contain three digits.
 * What is the first term in the Fibonacci sequence to contain 1000 digits?
 * @author moerie
 */
object Problem25 extends Problem {

    val desiredDigits = 1000

    def solve() {
        val a = 1
        val b = 1
        val index = 2
        def fibonacci(validate: (BigInt,BigInt) => Boolean, a: BigInt, b: BigInt, index: Int) {
            if (validate(a,b)) {
                fibonacci(validate, b, a+b, index + 1)
            } else {
                println(index + " = " + b)
            }
        }
        fibonacci((x, y) => y.toString().length < desiredDigits, a, b, index)
    }
}
