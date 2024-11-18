package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class SingleNumber {
    /**
     * # [136. Single Number](https://leetcode.com/problems/single-number/)
     * Given a non-empty array of integers nums, every element appears twice except for one. Find that single one.
     *
     * ## Example 1:
     * - **Input:** nums = [2,2,1]
     * - **Output:** 1
     * ## Example 2:
     * - **Input:** nums = [4,1,2,1,2]
     * - **Output:** 4
     * ## Example 3:
     * - **Input:** nums = [1]
     * - **Output:** 1
     *
     * ## Constraints:
     * - 1 <= nums.length <= 3 * 10^4
     * - -3 * 10^4 <= nums[i] <= 3 * 10^4
     * - Each element in the array appears twice except for one element which appears only once.
     */

    private val testCases = mutableMapOf<IntArray, Int>()

    @Before
    fun setup() {
        testCases[intArrayOf(2, 2, 1)] = 1
        testCases[intArrayOf(4, 1, 2, 1, 2)] = 4
        testCases[intArrayOf(1)] = 1
    }

    /**
     * # Pseudo code
     * ## Function singleNumber(nums):
     * 1. Initialize a variable `result` to 0.
     * 2. Iterate over each element `num` in the array `nums`:
     *    - Perform XOR operation between `result` and `num`.
     *    - Update `result` with the XOR result.
     * 3. Return `result` as the single number.
     */
    private fun singleNumber(nums: IntArray): Int {
        var result = 0
        for (num in nums) {
            result = result xor num
        }
        return result
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating over the array:**
     *    The function iterates over the entire array once, which takes **O(n)** time where `n` is the number of elements in the array.
     *
     * 2. **Bitwise XOR operation:**
     *    Each XOR operation is a constant-time operation: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(n)` where `n` is the number of elements in the array.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since only a single integer variable (`result`) is used for the XOR operation.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
    @Test
    fun singleNumberTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = singleNumber(input)
            assertEquals(expectedResult, actualResult)
        }
    }

}
