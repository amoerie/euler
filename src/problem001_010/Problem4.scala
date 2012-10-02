package problem001_010

import scala.MathCommon
import common.Problem

/**
 * A palindromic number reads the same both ways.
 * The largest palindrome made from the product of two 2-digit numbers is 9009 = 91 99.
 * Find the largest palindrome made from the product of two 3-digit numbers.
 * @author moerie
 */

object Problem4  extends Problem {
  val DIGITS = 3

  val MIN_VALUE = math.pow(10, DIGITS - 1).toInt
  val MAX_VALUE = (math.pow(10, DIGITS) - 1).toInt
  val MIN_PALINDROME = math.pow(10, DIGITS * 2 - 1).toInt

  var palindrome = (math.pow(10, DIGITS * 2) - 1).toInt

  def solve() {
    var found = false
    while (palindrome > MIN_PALINDROME && !found) {
      if (isPalindrome(palindrome)) {
        val (factor1, factor2) = getFactors(palindrome)
        if (factor1 != Int.MinValue && factor2 != Int.MinValue) {
          println(palindrome + " = " + factor1 + " * " + factor2)
          found = true
        }
      }
      palindrome -= 1
    }
  }

  def getFactors(number: Int): (Int, Int) = {
    var factor = MAX_VALUE

    while (factor >= MIN_VALUE) {
      val factor2 = number / factor
      if (number % factor == 0 && factor2 >= MIN_VALUE && factor2 <= MAX_VALUE) {
        return (factor, factor2)
      }
      factor -= 1
    }

    return (Int.MinValue, Int.MinValue)
  }

  def isPalindrome(number: Int): Boolean = {
    val numberAsString = number.toString
    val reversed = new StringBuilder(numberAsString).reverseContents.toString
    return numberAsString == reversed
  }
}