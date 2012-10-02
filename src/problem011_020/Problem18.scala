package problem011_020

import scala.collection._
import mutable.{ArrayBuffer, ListBuffer}
import common.Problem

/**
 * By starting at the top of the triangle below and moving to adjacent numbers on the row below, the maximum total from top to bottom is 23.
 * 3
 * 7 4
 * 2 4 6
 * 8 5 9 3
 * That is, 3 + 7 + 4 + 9 = 23.
 * Find the maximum total from top to bottom of the triangle below:
 *
 * 75
 * 95 64
 * 17 47 82
 * 18 35 87 10
 * 20 04 82 47 65
 * 19 01 23 75 03 34
 * 88 02 77 73 07 63 67
 * 99 65 04 28 06 16 70 92
 * 41 41 26 56 83 40 80 70 33
 * 41 48 72 33 47 32 37 16 94 29
 * 53 71 44 65 25 43 91 52 97 51 14
 * 70 11 33 28 77 73 17 78 39 68 17 57
 * 91 71 52 38 17 14 91 43 58 50 27 29 48
 * 63 66 04 68 89 53 67 30 73 16 69 87 40 31
 * 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
 *
 * @author moerie
 */
object Problem18 extends Problem {
    val PYRAMID =
        """
          | 75
          | 95 64
          | 17 47 82
          | 18 35 87 10
          | 20 04 82 47 65
          | 19 01 23 75 03 34
          | 88 02 77 73 07 63 67
          | 99 65 04 28 06 16 70 92
          | 41 41 26 56 83 40 80 70 33
          | 41 48 72 33 47 32 37 16 94 29
          | 53 71 44 65 25 43 91 52 97 51 14
          | 70 11 33 28 77 73 17 78 39 68 17 57
          | 91 71 52 38 17 14 91 43 58 50 27 29 48
          | 63 66 04 68 89 53 67 30 73 16 69 87 40 31
          | 04 62 98 27 23 09 70 98 73 93 38 53 60 04 23
        """.stripMargin.replace("\r", "").trim().split("\n").map(s => s.trim().split(" ").map(s => s.toInt))


    /**
     * For the heuristic function we'll use an overly optimistic value
     * suggesting that the remaining route will be filled with MAX VALUES
     * so as to ensure the optimal path is definitely taken
     */
    val MAX_VALUE = PYRAMID.flatten.max

    val pathList = mutable.Map[List[(Int, Int)], Int]()

    /**
     * The solution to this exercise is an application of A* search
     * but rather than searching for an optimal route (lowest cost)
     * we are looking for the 'worst' route.
     * @param args
     */
    def solve() {
        def open(pathSoFar: List[(Int, Int)]) {
            if (pathSoFar.length == PYRAMID.length) {
                println("Best path = " + pathSoFar.map(step => PYRAMID(step._1)(step._2)).reverse
                    + " ( Path cost = " + pathSoFar.map(step => PYRAMID(step._1)(step._2)).sum + " )")
            } else {
                val lastNode = pathSoFar.head
                val leftNode = (lastNode._1 + 1, lastNode._2)
                val rightNode = (lastNode._1 + 1, lastNode._2 + 1)

                pathList += (leftNode :: pathSoFar) -> (pathList(pathSoFar) + PYRAMID(leftNode._1)(leftNode._2))
                pathList += (rightNode :: pathSoFar) -> (pathList(pathSoFar) + PYRAMID(rightNode._1)(rightNode._2))
                pathList -= pathSoFar

                open(pathList.maxBy(path => evaluate(path._1))._1)
            }

        }

        def evaluate(path: List[(Int, Int)]): Int = {
            val steps = path.length
            val pathCostSoFar = pathList(path)
            pathCostSoFar + (PYRAMID.length - steps) * MAX_VALUE
        }

        val start = List((0, 0))
        pathList += start -> PYRAMID(0)(0)
        open(start)
    }
}
