package mohamed.arfa.problemsolving.problemSolving

object CppProblemSolving {
    init {
        System.loadLibrary("native-lib")
    }
    external fun isAnagramAl1(s: String, t: String): Boolean

    external fun getName():String
    @JvmStatic
    fun main(args: Array<String>) {
       val result = CppProblemSolving.isAnagramAl1("d","")
        println(result)
    }
}