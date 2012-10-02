package util

/**
 * @author moerie
 */
object TimeUtil {
    def time[T](code : => T) =  {
        val t0 = System.nanoTime : Double
        val res = code
        val t1 = System.nanoTime : Double
        println("Elapsed time " + (t1 - t0) / 1000000.0 + " ms")
        res
    }
}
