package problem031_040

import common.Problem
import collection.mutable

/**
 * We shall say that an n-digit number is pandigital
 * if it makes use of all the digits 1 to n exactly once.
 * Example: the 5-digit number, 15234, is 1 through 5 pandigital.
 *
 * The product 7254 is unusual,
 * as the identity, 39 x 186 = 7254, containing multiplicand, multiplier, and product is 1 through 9 pandigital.
 *
 * Find the sum of all products whose multiplicand/multiplier/product identity can be written as a 1 through 9 pandigital.
 * HINT: Some products can be obtained in more than one way so be sure to only include it once in your sum.
 * @author moerie
 */
object Problem32 extends Problem{

    val numbers = (1 to 9).toList.map(i => i.toString)
    val bound = 10000

    val products = mutable.Set[Int]()

    def solve() {
        def hasDuplicateCharacters(text: String): Boolean =  {
            val charArray = text.toCharArray
            for (i <- 0 until charArray.length - 1) {
                for (j <- i + 1 until charArray.length) {
                    if (charArray(i) == charArray(j))
                        return true
                }
            }
            return false
        }

        def isPandigital(i: Int, j:Int): Boolean = {
            val concatenated = (i.toString + j.toString + (i*j).toString)
            !concatenated.contains("0") && !hasDuplicateCharacters(concatenated) && numbers.filter(n => !concatenated.contains(n)).length == 0

        }

        for (i <- 1 to 99; j <- i to bound if(isPandigital(i,j) && !products.contains(i*j))) {
            printf("i = %d, j = %d, product = %d\n", i, j, i * j)
            products += i * j
        }

        println(products.sum)
    }
}
