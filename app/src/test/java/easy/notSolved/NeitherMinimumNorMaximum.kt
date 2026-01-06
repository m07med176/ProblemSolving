package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class NeitherMinimumNorMaximum {
    /**
     * # [2733. Neither Minimum nor Maximum](https://leetcode.com/problems/neither-minimum-nor-maximum/)
     * Given an integer array `nums` containing distinct positive integers, find and return any number from the array
     * that is neither the minimum nor the maximum value in the array, or -1 if there is no such number.
     *
     * ## Example 1:
     * - **Input:** nums = [3,2,1,4]
     * - **Output:** 2
     *
     * ## Example 2:
     * - **Input:** nums = [1,2]
     * - **Output:** -1
     *
     * ## Example 3:
     * - **Input:** nums = [2,1,3]
     * - **Output:** 2
     *
     * ## Constraints:
     * - 1 <= nums.length <= 100
     * - 1 <= nums[i] <= 100
     * - All values in nums are distinct
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(3, 2, 1, 4),
                2 // Expected result (or 3, either is valid)
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 2),
                -1 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(2, 1, 3),
                2 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function findNonMinOrMax(nums):
     * 1. If the length of `nums` is less than 3, return -1 (no valid number exists).
     * 2. Find the minimum and maximum values in the array.
     * 3. Iterate through the array:
     *    - Return the first number that is neither the minimum nor the maximum.
     * 4. If no such number exists, return -1.
     */
    private fun findNonMinOrMax(nums: IntArray): Int {
        if (nums.size < 3) return -1

        val min = nums.minOrNull()!!
        val max = nums.maxOrNull()!!

        for (num in nums) {
            if (num != min && num != max) return num
        }

        return -1
    }

    @Test
    fun findNonMinOrMaxTests() {
        testCases.forEach { (nums, expectedResult) ->
            val actualResult = findNonMinOrMax(nums)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Finding minimum and maximum values:**
     *    - This operation takes **O(n)** where `n` is the size of the array.
     *
     * 2. **Iterating through the array:**
     *    - This operation also takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** since no additional data structures are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
