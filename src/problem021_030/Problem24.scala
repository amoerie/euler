package problem021_030

import util.TimeUtil
import common.Problem

/**
 * A permutation is an ordered arrangement of objects.
 * For example, 3124 is one possible permutation of the digits 1, 2, 3 and 4.
 * If all of the permutations are listed numerically or alphabetically, we call it lexicographic order.
 *
 * The lexicographic permutations of 0, 1 and 2 are:
 * 012   021   102   120   201   210
 *
 * What is the millionth lexicographic permutation of the digits 0, 1, 2, 3, 4, 5, 6, 7, 8 and 9?
 * @author moerie
 */
object Problem24 extends Problem {
    val elements = Array(0, 1, 2, 3, 4, 5, 6, 7, 8, 9).sortWith(_.compareTo(_) < 0)
    val desiredIteration = 1000000

    def solve() {

        def swap[T](array: Array[T], index1: Int, index2: Int) {
            val temp = array(index1)
            array(index1) = array(index2)
            array(index2) = temp
        }

        def permutate(iteration: Int, array: Array[Int]) {
            val possibleKs = (0 until array.length - 1).filter(k => array(k) < array(k + 1))
            if (!possibleKs.isEmpty && iteration < desiredIteration) {
                val k = possibleKs.max
                val l = (0 until array.length).filter(l => array(k) < array(l)).max
                swap(array, k, l)
                permutate(iteration + 1, array.slice(0, k + 1) ++ array.slice(k + 1, array.length).reverse)
            } else {
                println(iteration + " - " + array.toList)
            }
        }
        permutate(1, elements)

    }

}
