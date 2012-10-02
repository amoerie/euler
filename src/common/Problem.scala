package common

import _root_.util.TimeUtil

/**
 * @author moerie
 */
abstract class Problem {
    def main(args: Array[String]) {
        TimeUtil.time(solve())
    }

    def solve()
}
