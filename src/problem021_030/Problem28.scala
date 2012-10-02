package problem021_030

import common.Problem

/**
 * Starting with the number 1 and moving to the right in a clockwise direction a 5 by 5 spiral is formed as follows:
 *
 * 21 22 23 24 25
 * 20  7  8  9 10
 * 19  6  1  2 11
 * 18  5  4  3 12
 * 17 16 15 14 13
 *
 * It can be verified that the sum of the numbers on the diagonals is 101.
 * What is the sum of the numbers on the diagonals in a 1001 by 1001 spiral formed in the same way?
 * @author moerie
 */
object Problem28 extends Problem {
    val n = 1001
    def solve() {
        /**
         * Math theory time!
         * A square matrix' size is always equal to the square of of the length of one side
         * Interesting to note is that the a square with size n always increases
         * by n² - (n-2)² for each increment of n
         *
         * If we were only interested in the upper right diagonal of a square with n = 5 (see example), the sum would be
         * 25 + 9 + 1 = 5² + 3² + 1² = n² + (n -2)² + (n - 4)²
         *
         * These are also the max values for their current inner "circle"
         * If we move to the left, we get
         * 21 + 7 + 1 = upper right - 4 + upper right - 2 + upper right
         *
         * Moving to down left we get
         * 17 + 5 + 1 = upper left - 4 + upper left - 2 + upper left
         *
         * Moving to down right we get
         * 13 + 3 + 1 = down left - 4 + down left - 2 + down left
         *
         * The 'radius' of the spiral can be calculated like this
         */
        val radius = n / 2
        def getDiagonalSum(i: Int = 0,
                           upperRight: BigInt = 0,
                           upperLeft: BigInt = 0,
                           downLeft: BigInt = 0,
                           downRight: BigInt = 0): BigInt = {
            if (i == radius)    upperRight + upperLeft + downLeft + downRight + 1
            else {
                val newUpperRight = (n - i*2) * (n - i*2)
                val newUpperLeft = newUpperRight - (radius-i) * 2
                val newDownLeft = newUpperLeft - (radius-i) * 2
                val newDownRight = newDownLeft - (radius-i) * 2
                getDiagonalSum(i + 1,
                    upperRight  + newUpperRight,
                    upperLeft   + newUpperLeft,
                    downRight   + newDownRight,
                    downLeft    + newDownLeft)
            }
        }

        println(getDiagonalSum())

    }
}