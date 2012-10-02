package problem001_010

import util.PrimeUtil
import common.Problem

/**
 * By listing the first six prime numbers: 2, 3, 5, 7, 11, and 13, we can see that the 6th prime is 13.
 * What is the 10 001st prime number?
 * @author moerie
 */
object Problem7  extends Problem {
  val N = 10001

  def solve() {
    println(PrimeUtil.getNthPrime(N))
  }
}
