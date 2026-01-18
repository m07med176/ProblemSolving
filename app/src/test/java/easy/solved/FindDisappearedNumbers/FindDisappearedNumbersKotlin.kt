package easy.solved.FindDisappearedNumbers

object FindDisappearedNumbersKotlin {

    /**
     * # My Solution
     *
     */
    val solution0 = object : FindDisappearedNumbers.Solution{
        override fun findDisappearedNumbers(nums: IntArray): List<Int> {
            val comparedNumber = nums.mapIndexed { index, _ ->  index+1 }
            val missingNumber = mutableListOf<Int>()
            comparedNumber.forEach {
                if (!nums.contains(it)){
                    missingNumber.add(it)
                }
            }
            return missingNumber
        }

    }


    /**
     * # Boolean Array
     */
    val solution1 = object : FindDisappearedNumbers.Solution{
        override fun findDisappearedNumbers(nums: IntArray): List<Int> {
            val appeared = BooleanArray(nums.size + 1)
            for (num in nums) {
                appeared[num] = true
            }
            val missingNumber = mutableListOf<Int>()
            for (i in 1 until appeared.size) {
                if (!appeared[i]) {
                    missingNumber.add(i)
                }
            }
            return missingNumber
        }
    }

    /**
     * Using Hash Set
     */
    val solution2 = object : FindDisappearedNumbers.Solution{
        override fun findDisappearedNumbers(nums: IntArray): List<Int> {
            val set = nums.toSet()
            val disappearedNumList = mutableListOf<Int>()
            for (i in 1..nums.size) {
                if (!set.contains(i)) disappearedNumList.add(i)
            }
            return disappearedNumList
        }
    }
}