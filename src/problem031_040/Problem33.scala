package problem031_040

import common.Problem
import scala.collection.mutable
import collection.mutable.ListBuffer
import common.util.FractionUtil

/**
 * The fraction 49/98 is a curious fraction,
 * as an inexperienced mathematician in attempting to simplify it may incorrectly believe that 49/98 = 4/8,
 * which is correct, is obtained by cancelling the 9s.
 *
 * We shall consider fractions like, 30/50 = 3/5, to be trivial examples.
 * There are exactly four non-trivial examples of this type of fraction,
 * less than one in value, and containing two digits in the numerator and denominator.
 *
 * If the product of these four fractions is given in its lowest common terms, find the value of the denominator.
 * @author moerie
 */
object Problem33 extends Problem {
    def solve() {

        def isTrivial(i: String, j: String): Boolean = {
            return i.contains("0") || j.contains("0")
        }

        def without(s: String, c:Char): Int = {
            val filter = s.filter(d => d != c)
            if (filter.length != 0) filter.toInt else 0
        }

        def removeCommonDigit(i: String, j: String): (Int, Int) = {
            val first =     i.charAt(0)
            val second =    i.charAt(1)
            if (j.contains(first))          (without(i, first),     without(j, first))
            else if (j.contains(second))    (without(i, second),    without(j, second))
            else (i.toInt,j.toInt)
        }

        def isCuriousFraction(numerator:Int, denominator: Int): Boolean = {
            val numAsString = numerator.toString
            val denomAsString = denominator.toString
            if (isTrivial(numAsString, denomAsString))  return false
            else {
                val (newNum, newDenum) = removeCommonDigit(numAsString, denomAsString)
                val notSame = newNum != numerator && newDenum != denominator
                val sameResult = newNum.toDouble / newDenum == numerator.toDouble / denominator
                val lowerThan1 = (numerator.toDouble / denominator) < 1
                notSame & sameResult & lowerThan1
            }
        }

        var nominatorProduct = 1
        var denominatorProduct = 1
        for (i <- 10 to 99; j <- 10 to 99; if (isCuriousFraction(i,j))) {
            nominatorProduct *= i
            denominatorProduct *= j
        }

        println(denominatorProduct / FractionUtil.getGreatestCommonDivisor(nominatorProduct, denominatorProduct))




    }
}
