package util


/**
 * @author moerie
 */
object PrimeUtil {

    /**
     * @param max
     * @return a list of all prime numbers lower than or equal to #max
     */
    def getPrimesList(max: Int): List[Int] = {
        return getPrimesAsBitArray(max).zipWithIndex.filter(p => p._1 == 1).map(p => p._2).toList
    }

    /**
     * Gets the prime factors for a given number so that the
     * product of the primes in the resulting list equals the number
     * getPrimeFactors(number).product == number
     * @param number
     * @return the prime factors of #number
     */
    def getPrimeFactors(number: Int): List[Int] = {
        def getPrimeFactorsWithPrimeList(number: Int, primes: List[Int]): List[Int] = {
            if(primes.isEmpty || number == 1)
                List()
            else if(number%primes.head == 0)
                primes.head :: getPrimeFactorsWithPrimeList(number / primes.head, primes)
            else
                getPrimeFactorsWithPrimeList(number, primes.tail)
        }
        if (isPrime(number))
            List(number)
        else
            getPrimeFactorsWithPrimeList(number, getPrimesList(number/2 + 1))
    }

    /**
     *
     * @param number
     * @return true if #number is a prime number
     */
    def isPrime(number: Int): Boolean = {
        if (number < 2)             false   // 0, 1 and negative numbers aren't prime
        else if (number < 4)        true    // 2 and 3 are prime
        else if (number % 2 == 0)   false   // multiples of 2 aren't prime
        else if (number < 9)        true    // 5 and 7 are prime
        else if (number % 3 == 0)   false   // multiples of 3 aren't prime
        else if (number % 5 == 0)   false   // multiples of 5 aren't prime
        else {
            val root = math.floor(math.sqrt(number.toDouble))
            var factor = 5
            while (factor <= root) {
                if (number % factor == 0)               return false
                else if (number % (factor + 2) == 0)    return false
                else                                    factor += 6
            }
            return true
        }
    }

    /**
     * @param n
     * @return the nth prime
     */
    def getNthPrime(n: Int): Int = {
        var candidate = 1
        var count = 1
        while (count < n) {
            candidate += 2
            if (isPrime(candidate))
                count += 1
        }
        candidate
    }

    /**
     * Calculates a bit array where the value = 0 if the index is not a prime or 1 if it is.
     * @param max
     * @return a bit array of primes
     */
    def getPrimesAsBitArray(max: Int): Array[Int] = {
        val bitArray = Array.fill(max + 1)(1)
        bitArray(0) = 0
        bitArray(1) = 0

        for (index <- (2 to max).filter(i => bitArray(i) != 0); multiplication <- 2 to (max / index))
            bitArray(index * multiplication) = 0
        bitArray
    }

}
