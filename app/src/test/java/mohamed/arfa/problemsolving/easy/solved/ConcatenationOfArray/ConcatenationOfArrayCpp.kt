package mohamed.arfa.problemsolving.easy.solved.ConcatenationOfArray

object ConcatenationOfArrayCpp {
    init {
        System.loadLibrary("native-lib")
    }

    external fun getConcatenation(nums: IntArray): IntArray
}