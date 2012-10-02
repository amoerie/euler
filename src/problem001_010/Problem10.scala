package problem001_010

import util.PrimeUtil
import common.Problem

/**
 * The sum of the primes below 10 is 2 + 3 + 5 + 7 = 17.
 * Find the sum of all the primes below two million.
 * @author moerie
 */
object Problem10 extends Problem {

  val LIMIT = 2000000

  def solve() {
    var sum = 0L
    val primesBitArray = PrimeUtil.getPrimesAsBitArray(LIMIT)
    for (i <- 0 to LIMIT) {
      if(primesBitArray(i) == 1)
        sum += i
    }
    println(sum)
  }
}
