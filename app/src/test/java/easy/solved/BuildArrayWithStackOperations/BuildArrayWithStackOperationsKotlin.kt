package easy.solved.BuildArrayWithStackOperations

object BuildArrayWithStackOperationsKotlin {

    val solution0 = object : BuildArrayWithStackOperations.Solution {
        override fun buildArray(
            target: IntArray,
            n: Int
        ): List<String> {
            val myArray = mutableListOf<String>()

            val maxNumber = target.max()
            repeat(n) {
                if (it < maxNumber) {
                    if (target.contains(it + 1)) {
                        myArray.add("Push")
                    } else {
                        myArray.addAll(listOf("Push","Pop"))
                    }
                }
            }
            return myArray
        }
    }
}