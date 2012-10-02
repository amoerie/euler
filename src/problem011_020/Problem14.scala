package problem011_020

import collection.parallel.mutable
import common.Problem

/**
 * The following iterative sequence is defined for the set of positive integers:
 * n  n/2 (n is even)
 * n  3n + 1 (n is odd)
 *
 * Using the rule above and starting with 13, we generate the following sequence:
 * 13  40  20  10  5  16  8  4  2  1
 *
 * It can be seen that this sequence (starting at 13 and finishing at 1) contains 10 terms.
 * Although it has not been proved yet (Collatz Problem), it is thought that all starting numbers finish at 1.
 * Which starting number, under one million, produces the longest chain?
 * NOTE: Once the chain starts the terms are allowed to go above one million.
 * @author moerie
 */
object Problem14  extends Problem {

    def solve() {

        println((1000000 to 1 by -1).filter(i => i % 2 != 0).map(i => sequence(i)).maxBy(i => i._2)._1)

        def sequence(n: Int): (Int, Int) = {
            var temp = n.toLong
            var count = 0

            while (temp > 1L) {
                if (temp % 2 == 0)
                    temp = temp / 2
                else
                    temp = 3 * temp + 1
                count += 1
            }
            return (n, count)
        }
    }
}
