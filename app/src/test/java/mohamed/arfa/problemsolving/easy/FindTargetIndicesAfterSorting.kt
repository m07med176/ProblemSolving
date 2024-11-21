package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class FindTargetIndicesAfterSorting {
    /**
     * # [2089. Find Target Indices After Sorting Array](https://leetcode.com/problems/find-target-indices-after-sorting-array/)
     * Given a 0-indexed integer array `nums` and a target element `target`, return a list of the target indices of nums after sorting nums in non-decreasing order.
     *
     * ## Example 1:
     * - **Input:** nums = [1,2,5,2,3], target = 2
     * - **Output:** [1,2]
     *
     * ## Example 2:
     * - **Input:** nums = [1,2,5,2,3], target = 3
     * - **Output:** [3]
     *
     * ## Example 3:
     * - **Input:** nums = [1,2,5,2,3], target = 5
     * - **Output:** [4]
     *
     * ## Constraints:
     * - 1 <= nums.length <= 100
     * - 1 <= nums[i], target <= 100
     */

    private val testCases = mutableListOf<Triple<IntArray, Int, List<Int>>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(1, 2, 5, 2, 3),
                2,
                listOf(1, 2) // Expected result
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1, 2, 5, 2, 3),
                3,
                listOf(3) // Expected result
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1, 2, 5, 2, 3),
                5,
                listOf(4) // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function targetIndices(nums, target):
     * 1. Sort the array in non-decreasing order.
     * 2. Initialize an empty list `result`.
     * 3. Iterate through the sorted array:
     *    - If the current element equals the target, add its index to `result`.
     * 4. Return the `result` list.
     */
    private fun targetIndices(nums: IntArray, target: Int): List<Int> {
        nums.sort()
        val result = mutableListOf<Int>()
        for (i in nums.indices) {
            if (nums[i] == target) {
                result.add(i)
            }
        }
        return result
    }

    @Test
    fun targetIndicesTests() {
        testCases.forEach { (nums, target, expectedResult) ->
            val actualResult = targetIndices(nums, target)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting the array:**
     *    Sorting takes **O(n log n)** where `n` is the size of the array.
     *
     * 2. **Finding target indices:**
     *    Iterating through the array takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** as the sorting is done in place and no extra data structures are used apart from the result list.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(1)** (excluding the output list)
     */
}
