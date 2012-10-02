package problem021_030

import io.Source
import common.Problem

/**
 * @author moerie
 */
object Problem22 extends Problem {
    def solve() {
        val indexedAlphabet = Map(('A' to 'Z').zip((1 to 26)): _*)
        val input = Source.fromFile("C:\\Users\\almo\\Euler\\resources\\problem22_names.txt")
        val names = input.getLines().toList.head.replace("\"", "").split(",").sortWith(_.compareTo(_) < 0).toArray
        input.close ()

        var totalScore = 0
        for (i <- 0 until names.length) {
            totalScore += (i+1) * names(i).filter(c => c != ' ').map(c => indexedAlphabet(c)).sum
        }

        println(totalScore)
    }
}
