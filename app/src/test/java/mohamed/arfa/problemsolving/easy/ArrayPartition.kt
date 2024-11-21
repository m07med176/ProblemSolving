package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ArrayPartition {
    /**
     * # [561. Array Partition](https://leetcode.com/problems/array-partition/)
     * Given an integer array nums of 2n integers, group these integers into n pairs such that the sum of min(ai, bi) for all i is maximized.
     *
     * ## Example 1:
     * - **Input:** nums = [1,4,3,2]
     * - **Output:** 4
     *
     * ## Example 2:
     * - **Input:** nums = [6,2,6,5,1,2]
     * - **Output:** 9
     *
     * ## Constraints:
     * - 1 <= n <= 10^4
     * - nums.length == 2 * n
     * - -10^4 <= nums[i] <= 10^4
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(1, 4, 3, 2),
                4 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(6, 2, 6, 5, 1, 2),
                9 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function arrayPairSum(nums):
     * 1. Sort the array in ascending order.
     * 2. Initialize `sum` to 0.
     * 3. Iterate through the array by step 2:
     *    - Add the element at the current index to `sum`.
     * 4. Return `sum`.
     */
    private fun arrayPairSum(nums: IntArray): Int {
        nums.sort()
        var sum = 0

        for (i in nums.indices step 2) {
            sum += nums[i]
        }

        return sum
    }

    @Test
    fun arrayPairSumTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = arrayPairSum(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting the array:**
     *    Sorting takes **O(n log n)** where `n` is the size of the array.
     *
     * 2. **Iterating through half the array:**
     *    Summing the elements takes **O(n / 2)**, which simplifies to **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)**, as no additional data structures are used apart from variables.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(1)**
     */
}
