package util

/**
 * @author moerie
 */
object DivisorUtil {
    /**
     * Gets all the divisors of n.
     *
     * Example: getDivisors(6) = List(1, 2, 3, 6)
     * Use .init if you don't want n itself in the results, for example
     * val divisorsWithout6 = getDivisors(6).init
     * @param n a positive integer
     * @return a list of all divisors for n so that for each x in the divisor list: n%x == 0
     */
    def getDivisors(n: Int): List[Int] = {
        val uniqueDivisors = (1 to math.sqrt(n).toInt).filter(i => n % i == 0).toList
        return (uniqueDivisors ::: uniqueDivisors.map(u => n/u).reverse).distinct
    }

    /**
     * Two numbers a and b are deemed amicable if and only if
     * a != b
     * sum(getDivisors(a)) = b
     * sum(getDivisors(b)) = a
     *
     * where the getDivisors method returns all valid divisors of a number excluding the number itself
     * @param n any positive integer
     * @return Some(number) where sum(getDivisors(number).init) == n or None if no such number was found
     */
    def getAmicableNumber(n: Int): Option[Int] = {
        val sumOfDivisors = getDivisors(n).init.sum
        if (getDivisors(sumOfDivisors).init.sum == n)
            Some(sumOfDivisors)
        else
            None
    }

    /**
     * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
     * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28,
     * which means that 28 is a perfect number.
     * @param n any positive integer
     * @return True if the number was deemed perfect or false otherwise
     */
    def isPerfect(n: Int): Boolean = {
        return n == getDivisors(n).init.sum
    }

    /**
     * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
     * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
     * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
     * @param n any positive integer
     * @return True if the number was deemed deficient or false otherwise
     */
    def isDeficient(n: Int): Boolean = {
        return n > getDivisors(n).init.sum
    }

    /**
     * A perfect number is a number for which the sum of its proper divisors is exactly equal to the number.
     * For example, the sum of the proper divisors of 28 would be 1 + 2 + 4 + 7 + 14 = 28, which means that 28 is a perfect number.
     * A number n is called deficient if the sum of its proper divisors is less than n and it is called abundant if this sum exceeds n.
     * @param n any positive integer
     * @return True if the number was deemed abundant or false otherwise
     */
    def isAbundant(n: Int): Boolean = {
        return n < getDivisors(n).init.sum
    }
}
