package easy.solved.SmallerNumbersThanCurrent

object SmallerNumbersThanCurrentKotlin {

    /**
     * # Solution 0: Two Loops for n
     */
    val solution0 = object : SmallerNumbersThanCurrent.Solution{
        override fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
            val newArray = mutableListOf<Int>()

            for (item in nums) {
                var countSmallest = 0
                for (compare in nums) {
                    if (item > compare) {
                        countSmallest += 1
                    }
                }
                newArray.add(countSmallest)
            }
            return newArray.toIntArray()
        }
    }
}