package common.util

import _root_.util.PrimeUtil
import collection.mutable.ListBuffer
import annotation.tailrec

/**
 * @author moerie
 */
object FractionUtil {

    def getLowestCommonDenominator(numbers: List[Int]): Int = {
        @tailrec def findPrimeDivisorsAndMultiplyThem(numbers: List[Int], primes: List[Int], primeStack: List[Int]): Int = {
            val nextPrime = primes.head
            if (numbers.forall(i => i == 1))
                primeStack.product
            else if (numbers.exists(i => i%nextPrime == 0))
                findPrimeDivisorsAndMultiplyThem(numbers.map(i => if (i%nextPrime == 0) i/nextPrime else i), primes, nextPrime :: primeStack)
            else
                findPrimeDivisorsAndMultiplyThem(numbers, primes.tail, primeStack)
        }
        findPrimeDivisorsAndMultiplyThem(numbers, PrimeUtil.getPrimesList(numbers.max), List())
    }

    @tailrec def getGreatestCommonDivisor(a:Int, b:Int): Int = {
        if (b == 0)         a
        else if (a == 0)    b
        else getGreatestCommonDivisor(b, a%b)
    }


}
