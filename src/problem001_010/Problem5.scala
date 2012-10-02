package problem001_010

import collection.mutable.{ListBuffer, ArrayBuffer}
import collection.mutable
import util.PrimeUtil
import common.Problem

/**
 * 2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
 * What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
 * @author moerie
 */
object Problem5  extends Problem {
  val range = (2 to 40).toList
  val primesList = PrimeUtil.getPrimesList(range.max)

  def solve() {
    /*
    Build map where
      - key = number
      - value = list of prime factors
     */
    val numbersWithPrimeFactors = mutable.Map[Int,List[Int]]()
    for (i <- range)
      numbersWithPrimeFactors(i) = PrimeUtil.getPrimeFactors(i)
    println("Numbers with prime factors = " + numbersWithPrimeFactors)

    /*
    Build map where
      - key = prime factor (see primesList)
      - value = max count of prime factor occurences in numbersWithPrimeFactors map
     */
    val primeFactorWithCount = mutable.Map[Int, Int]()
    for (prime <- primesList) {
      primeFactorWithCount(prime) = 0
    }

    for ((number, primeFactors) <- numbersWithPrimeFactors) {
      for (prime <- primesList) {
        val count = primeFactors.count(p => p == prime)
        if(count > primeFactorWithCount(prime))
          primeFactorWithCount(prime) = count
      }
    }

    println("Prime factors with count = " + primeFactorWithCount)

    var sum = 1
    for ((prime, count) <- primeFactorWithCount) {
      sum *= math.pow(prime,count).toInt
    }
    println(sum)

  }
}