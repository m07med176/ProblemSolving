package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MaximumProductOfTwoElements {
    /**
     * # [464. Maximum Product of Two Elements in an Array](https://leetcode.com/problems/maximum-product-of-two-elements-in-an-array/)
     * Given an array of integers nums, you will choose two different indices i and j of that array.
     * Return the maximum value of `(nums[i]-1)*(nums[j]-1)`.
     *
     * ## Example 1:
     * - **Input:** nums = [3,4,5,2]
     * - **Output:** 12
     *
     * ## Example 2:
     * - **Input:** nums = [1,5,4,5]
     * - **Output:** 16
     *
     * ## Example 3:
     * - **Input:** nums = [3,7]
     * - **Output:** 12
     *
     * ## Constraints:
     * - 2 <= nums.length <= 500
     * - 1 <= nums[i] <= 10^3
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(3, 4, 5, 2),
                12 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 5, 4, 5),
                16 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(3, 7),
                12 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function maxProduct(nums):
     * 1. Sort the array in descending order.
     * 2. Take the two largest numbers:
     *    - `max1` = nums[0], `max2` = nums[1].
     * 3. Compute the maximum product:
     *    - `(max1 - 1) * (max2 - 1)`.
     * 4. Return the result.
     */
    private fun maxProduct(nums: IntArray): Int {
        nums.sortDescending()
        val max1 = nums[0]
        val max2 = nums[1]
        return (max1 - 1) * (max2 - 1)
    }
    /**
     * ### Time Complexity:
     *
     * 1. **Sorting the array:**
     *    Sorting takes **O(n log n)** where `n` is the size of the array.
     *
     * 2. **Overall Complexity:**
     *    The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** since sorting is done in place and no extra space is used apart from variables.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(1)**
     */

    private fun maxProduct2(nums: IntArray): Int {
        var max1 = 0
        var max2 = 0

        for (num in nums) {
            if (num > max1) {
                max2 = max1
                max1 = num
            } else if (num > max2) {
                max2 = num
            }
        }

        return (max1 - 1) * (max2 - 1)
    }

    @Test
    fun maxProductTests1() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = maxProduct(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    @Test
    fun maxProductTests2() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = maxProduct2(input)
            assertEquals(expectedResult, actualResult)
        }
    }


}
