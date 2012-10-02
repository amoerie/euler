package problem031_040

import common.Problem

/**
 * In England the currency is made up of pound, £, and pence, p, and there are eight coins in general circulation:
 * 1p, 2p, 5p, 10p, 20p, 50p, £1 (100p) and £2 (200p).
 * It is possible to make £2 in the following way:
 * 1 * £1 + 1 * 50p + 2 * 20p + 1 * 5p + 1 * 2p + 3 * 1p
 * How many different ways can £2 be made using any number of coins?
 * @author moerie
 */
object Problem31 extends Problem{

    val maxPrecision = 100
    val coins = List[Double](0.01, 0.02, 0.05, 0.10, 0.20, 0.50, 1, 2)
    val amount = 2

    val coinsAsInts = coins.map(c => (c * maxPrecision).toInt)
    val amountAsInt = (amount * maxPrecision).toInt

    def solve() {
        def countChange(money: Int, coins: List[Int]): Int =  {
            def countCombinations(sumSoFar: Int, lastCoinUsed: Int): Int = {
                if(sumSoFar > money)            0
                else if(sumSoFar == money)      1
                else coins.filter(c => c >= lastCoinUsed).map(c => countCombinations(sumSoFar + c, c)).sum
            }
            countCombinations(0,0)
        }
        println(countChange(amountAsInt, coinsAsInts))

    }
}
