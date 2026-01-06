package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ProductOfArrayExceptSelf {
    /**
     * # [238. Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     *
     * ## Example 1:
     * - **Input:** nums = [1,2,3,4]
     * - **Output:** [24,12,8,6]
     *
     * ## Example 2:
     * - **Input:** nums = [-1,1,0,-3,3]
     * - **Output:** [0,0,9,0,0]
     *
     * ## Constraints:
     * - 2 <= nums.length <= 10^5
     * - -30 <= nums[i] <= 30
     * - The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     */

    private val testCases = mutableListOf<Pair<IntArray, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(1, 2, 3, 4),
                intArrayOf(24, 12, 8, 6) // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(-1, 1, 0, -3, 3),
                intArrayOf(0, 0, 9, 0, 0) // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function productExceptSelf(nums):
     * 1. Create an output array initialized to 1.
     * 2. Traverse from left to right:
     *    - Maintain a running product of elements to the left of the current index.
     *    - Assign this product to the output array.
     * 3. Traverse from right to left:
     *    - Maintain a running product of elements to the right of the current index.
     *    - Multiply this product with the existing value in the output array.
     * 4. Return the output array.
     */
    private fun productExceptSelf(nums: IntArray): IntArray {
        val n = nums.size
        val output = IntArray(n) { 1 }

        // Left pass
        var leftProduct = 1
        for (i in nums.indices) {
            output[i] = leftProduct
            leftProduct *= nums[i]
        }

        // Right pass
        var rightProduct = 1
        for (i in nums.indices.reversed()) {
            output[i] *= rightProduct
            rightProduct *= nums[i]
        }

        return output
    }

    @Test
    fun productExceptSelfTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = productExceptSelf(input)
            assertArrayEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Left and right traversal:**
     *    Each traversal takes **O(n)**, where `n` is the length of the array.
     * 2. **Overall Complexity:**
     *    The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** for the output array (excluding input and output).
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)** (output array is not considered extra space).
     */
}
