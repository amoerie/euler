package problem001_010

import common.Problem

/**
 * Each new term in the Fibonacci sequence is generated by adding the previous two terms.
 * By starting with 1 and 2, the first 10 terms will be:
 * 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, ...
 * By considering the terms in the Fibonacci sequence whose values do not exceed four million,
 * find the sum of the even-valued terms.
 * @author moerie
 */

object Problem2  extends Problem {

  def solve() {
    val CAP = 4000000

    var first = 1
    var second = 2
    var sum = 0

    while (second < CAP) {
      if (second % 2 == 0)
        sum += second;

      val temp = second
      second = first + second
      first = temp
    }
    println(sum)
  }

}