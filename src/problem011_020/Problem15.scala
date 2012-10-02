package problem011_020

import common.Problem

/**
 * Starting in the top left corner of a 2x2 grid, there are 6 routes (without backtracking) to the bottom right corner.
 * How many routes are there through a 20x20 grid?
 * @author moerie
 */
object Problem15  extends Problem {

    val GRID_SIZE = 20

    def solve() {
        def factorial(n: Int): BigInt = {
            if (n == 0) 1 else n * factorial(n - 1)
        }
        println(factorial(2 * GRID_SIZE) / (factorial(GRID_SIZE) * factorial(GRID_SIZE)))
    }
}
