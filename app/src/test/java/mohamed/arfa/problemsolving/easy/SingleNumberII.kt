package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

/////////////
class SingleNumberII {
    /**
     * # [137. Single Number II](https://leetcode.com/problems/single-number-ii/)
     * Given an integer array `nums` where every element appears three times except for one, which appears exactly once. Find the single element and return it.
     *
     * ## Example 1:
     * - **Input:** nums = [2,2,3,2]
     * - **Output:** 3
     * ## Example 2:
     * - **Input:** nums = [0,1,0,1,0,1,99]
     * - **Output:** 99
     *
     * ## Constraints:
     * - 1 <= nums.length <= 3 * 10^4
     * - -2^31 <= nums[i] <= 2^31 - 1
     * - Each element in `nums` appears exactly three times except for one element which appears once.
     */

    private val testCases = mutableMapOf<IntArray, Int>()

    @Before
    fun setup() {
        testCases[intArrayOf(2, 2, 3, 2)] = 3
        testCases[intArrayOf(0, 1, 0, 1, 0, 1, 99)] = 99
    }

    /**
     * # Pseudo code
     * ## Function singleNumber(nums):
     * 1. Initialize two variables `ones` and `twos` to 0.
     * 2. For each number `num` in the array `nums`:
     *    - Update `ones` with the XOR of `num` and `ones`, and mask it with `~twos`.
     *    - Update `twos` with the XOR of `num` and `twos`, and mask it with `~ones`.
     * 3. Return `ones` as it contains the single element that appears once.
     */
    private fun singleNumber(nums: IntArray): Int {
        var ones = 0
        var twos = 0
        for (num in nums) {
            ones = (ones xor num) and twos.inv()
            twos = (twos xor num) and ones.inv()
        }
        return ones
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating over the array:**
     *    The function iterates over the entire array once, which takes **O(n)** time where `n` is the number of elements in the array.
     *
     * 2. **Bitwise operations:**
     *    Each bitwise operation (AND, OR, XOR, and NOT) is a constant-time operation: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(n)` where `n` is the number of elements in the array.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since only a constant amount of extra space is used (`ones` and `twos`).
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
    @Test
    fun singleNumberIITests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = singleNumber(input)
            assertEquals(expectedResult, actualResult)
        }
    }
}
