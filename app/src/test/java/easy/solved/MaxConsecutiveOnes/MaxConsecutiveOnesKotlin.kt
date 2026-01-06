package easy.solved.MaxConsecutiveOnes

object MaxConsecutiveOnesKotlin {

    val solution1 = object : MaxConsecutiveOnes.Solution{
        /**
         * # Solution1: Simple Iteration
         * - define var `maxCount` = 0
         * - define var `currentCount` = 0
         * - loop in `nums` array
         * - if item equal 1
         * - add one to `currentCount`
         * - if `currentCount` > `maxCount`
         * - if true `maxCount` = `currentCount`
         * - if item equal 0
         * - `currentCount` = 0
         * - return `maxCount`
         */
        override fun findMaxConsecutiveOnes(nums: IntArray): Int {
            var maxCount = 0
            var currentCount = 0
            nums.forEach {
                if (it == 1) {
                    currentCount++
                    maxCount = maxOf(maxCount, currentCount)
                } else {
                    currentCount = 0
                }
            }
            return maxCount
        }
    }

    val solution2 = object : MaxConsecutiveOnes.Solution{
        /**
         * # Solution2 : split and map
         * * join items separated replace `0` to `,`
         * * return max char in list
         */
        override fun findMaxConsecutiveOnes(nums: IntArray): Int {
            return nums
                .joinToString("")
                .split("0")
                .maxOfOrNull { it.length }?:0
        }
    }

    val solution3 = object : MaxConsecutiveOnes.Solution {
        /**
         * # Solution3 : Using Fold
         */
        override fun findMaxConsecutiveOnes(nums: IntArray): Int {
            return nums.fold(0 to 0) { (max, current), num ->
                if (num == 1) {
                    val newCurrent = current + 1
                    maxOf(max, newCurrent) to newCurrent
                } else {
                    max to 0
                }
            }.first
        }
    }
}