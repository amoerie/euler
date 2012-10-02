package problem001_010

import common.Problem

/**
 * A Pythagorean triplet is a set of three natural numbers, a  b  c, for which
 * a² + b² = c²
 *
 * For example, 3² + 4² = 5² (9 + 16 = 25)
 * There exists exactly one Pythagorean triplet for which a + b + c = 1000.
 * Find the product abc.
 * @author moerie
 */
object Problem9  extends Problem {

  val TARGET = 1000

  def solve() {
    for (a <- (1 to TARGET / 3); b <- (1 to TARGET - a); c <- (1 to TARGET - a - b)
      if(isPythagoreanTriplet(a, b, c) && a + b + c == TARGET)) {
        printf("a = %s, b = %s, c = %s \n", a, b, c)
        println("a * b * c = ", a * b * c)
    }
  }

  def isPythagoreanTriplet(a: Int, b:Int, c:Int): Boolean = {
    return a < b && b < c && (a*a + b*b == c*c)
  }
}
