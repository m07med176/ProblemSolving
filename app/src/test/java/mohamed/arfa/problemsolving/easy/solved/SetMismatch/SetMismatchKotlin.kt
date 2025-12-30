package mohamed.arfa.problemsolving.easy.solved.SetMismatch

import kotlin.math.abs


object SetMismatchKotlin {
    /**
     * # Solution 1: Using HashSet
     *
     * Uses a HashSet to track seen numbers and identify the duplicate.
     * Then calculates the missing number using the expected sum formula.
     *
     * * T-> O(n)
     * * S-> O(n)
     */
    val solution1 = object : SetMismatch.Solution {
        override fun findErrorNums(nums: IntArray): IntArray {
            val seen = HashSet<Int>()
            var duplicate = 0

            // Find duplicate
            for (num in nums) {
                if (num in seen) {
                    duplicate = num
                } else {
                    seen.add(num)
                }
            }

            // Find missing
            val n = nums.size
            val expectedSum = n * (n + 1) / 2
            val actualSum = nums.sum()
            val missing = expectedSum - (actualSum - duplicate)

            return intArrayOf(duplicate, missing)
        }
    }

    /**
     * # Solution 2: Using Frequency Array
     *
     * Uses an array to count occurrences of each number.
     * The number with count 2 is duplicate, count 0 is missing.
     *
     * * T -> O(n)
     * * S -> O(n)
     */
    val solution2 = object : SetMismatch.Solution {
        override fun findErrorNums(nums: IntArray): IntArray {
            val n = nums.size
            val count = IntArray(n + 1)

            // Count occurrences
            for (num in nums) {
                count[num]++
            }

            var duplicate = 0
            var missing = 0

            // Find duplicate and missing
            for (i in 1..n) {
                when (count[i]) {
                    2 -> duplicate = i
                    0 -> missing = i
                }
            }

            return intArrayOf(duplicate, missing)
        }
    }

    /**
     * # Solution 3: Using Math (Sum Formula)
     *
     * Uses mathematical approach with sum formulas to find both numbers.
     * Calculates the difference between expected and actual values.
     *
     * * T-> O(n)
     * * S-> O(1)
     */
    val solution3 = object : SetMismatch.Solution {
        override fun findErrorNums(nums: IntArray): IntArray {
            val n = nums.size
            val expectedSum = n * (n + 1) / 2
            val actualSum = nums.sum()

            val seen = mutableSetOf<Int>()
            var duplicate = 0

            for (num in nums) {
                if (num in seen) {
                    duplicate = num
                    break
                }
                seen.add(num)
            }

            val missing = expectedSum - actualSum + duplicate

            return intArrayOf(duplicate, missing)
        }
    }

    /**
     * # Solution 4: Using Negation Marking
     *
     * Marks visited indices by negating values in the array.
     * When we see a negative value, we found the duplicate.
     *
     * * T-> O(n)
     * * S-> O(1) - modifies input array
     */
    val solution4 = object : SetMismatch.Solution {
        override fun findErrorNums(nums: IntArray): IntArray {
            var duplicate = 0
            var missing = 0

            // Find duplicate using negation
            for (num in nums) {
                val index = abs(num) - 1
                if (nums[index] < 0) {
                    duplicate = abs(num)
                } else {
                    nums[index] = -nums[index]
                }
            }

            // Find missing (positive index)
            for (i in nums.indices) {
                if (nums[i] > 0) {
                    missing = i + 1
                    break
                }
            }

            return intArrayOf(duplicate, missing)
        }
    }
}