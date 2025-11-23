package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MaximumProductDifference {
    /**
     * # [1913. Maximum Product Difference Between Two Pairs](https://leetcode.com/problems/maximum-product-difference-between-two-pairs/)
     * The product difference between two pairs (a, b) and (c, d) is defined as `(a * b) - (c * d)`.
     *
     * ## Example 1:
     * - **Input:** nums = [5,6,2,7,4]
     * - **Output:** 34
     *
     * ## Example 2:
     * - **Input:** nums = [4,2,5,9,7,4,8]
     * - **Output:** 64
     *
     * ## Constraints:
     * - 4 <= nums.length <= 10^4
     * - 1 <= nums[i] <= 10^4
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(5, 6, 2, 7, 4),
                34 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(4, 2, 5, 9, 7, 4, 8),
                64 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function maxProductDifference(nums):
     * 1. Sort the array in ascending order.
     * 2. The two largest numbers are at the end of the array.
     * 3. The two smallest numbers are at the beginning of the array.
     * 4. Compute the product difference:
     *    - `(nums[n-1] * nums[n-2]) - (nums[0] * nums[1])`
     * 5. Return the result.
     */
    private fun maxProductDifference(nums: IntArray): Int {
        nums.sort()
        val n = nums.size
        val largestProduct = nums[n - 1] * nums[n - 2]
        val smallestProduct = nums[0] * nums[1]
        return largestProduct - smallestProduct
    }

    @Test
    fun maxProductDifferenceTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = maxProductDifference(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting the array:**
     *    Sorting takes **O(n log n)** where `n` is the size of the array.
     * 2. **Computing the product difference:**
     *    Accessing the required elements and calculating the difference takes **O(1)**.
     * 3. **Overall Complexity:**
     *    The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** for the in-place sort.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(1)**
     */
}
