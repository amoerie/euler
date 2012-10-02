package problem021_030

import util.{PrimeUtil}
import common.Problem

/**
 *  A unit fraction contains 1 in the numerator.
 *  The decimal representation of the unit fractions with denominators 2 to 10 are given:
 *  1/2	= 	0.5
 *  1/3	= 	0.(3)
 *  1/4	= 	0.25
 *  1/5	= 	0.2
 *  1/6	= 	0.1(6)
 *  1/7	= 	0.(142857)
 *  1/8	= 	0.125
 *  1/9	= 	0.(1)
 *  1/10	= 	0.1
 *
 *  Where 0.1(6) means 0.166666..., and has a 1-digit recurring cycle.
 *  It can be seen that 1/7 has a 6-digit recurring cycle.
 *  Find the value of d < 1000 for which 1/d contains the longest recurring cycle in its decimal fraction part.
 * @author moerie
 */
object Problem26 extends Problem {
    val limit = 1000

    def solve() {
        def isCyclicNumber(number: Int): Boolean = {
            def constructCyclicNumber(count: Int, remainder: Int, prime: Int) : List[Int] = {
                val x = remainder * 10
                val digit = (x / prime).intValue
                val nextRemainder = x % prime
                if(nextRemainder == 1)
                    List(digit)
                else
                    digit :: constructCyclicNumber(count+1, x % prime,prime )
            }
            number - 1 == constructCyclicNumber(1, 1, number).length
        }


        /**
         * Numbers with recurring fractions are called cyclic numbers (http://en.wikipedia.org/wiki/Cyclic_number)
         * All cyclic prime numbers are prime numbers
         * A number p is cyclic if p - 1 equals the number of digits in 1 / p
         * So if we find the first cyclic number starting from 1000, 999, 998 ... 5
         * we will have the number with largest recurring decimal, cyclic numbers are always prime
         * hence we can restrict the search to prime numbers below 1000 starting with 997. A number
         * is cyclic if the number of digits constructed using the algorithm in wikipedia link is equal
         * to p-1 where p is the prime in question, also the prime should not be a co-prime of the base
         * which we are evaluating i.e. 10, so 2 and 5 are not applicable hence start from 1000 until 7
         */
          println((limit to 7 by -1).find(n => PrimeUtil.isPrime(n) && isCyclicNumber(n)).getOrElse(0))
    }
}
