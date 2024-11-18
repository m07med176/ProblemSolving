package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class CountingBits {
    /**
     * # [338. Counting Bits](https://leetcode.com/problems/counting-bits/)
     * Given an integer `n`, return an array `ans` of length `n + 1` such that for each `i` (0 <= i <= n), `ans[i]` is the number of 1's in the binary representation of `i`.
     *
     * ## Example 1:
     * - **Input:** n = 2
     * - **Output:** [0,1,1]
     * - **Explanation:**
     *     - 0 --> 0
     *     - 1 --> 1
     *     - 2 --> 10
     * ## Example 2:
     * - **Input:** n = 5
     * - **Output:** [0,1,1,2,1,2]
     * - **Explanation:**
     *     - 0 --> 0
     *     - 1 --> 1
     *     - 2 --> 10
     *     - 3 --> 11
     *     - 4 --> 100
     *     - 5 --> 101
     *
     * ## Constraints:
     * - 0 <= n <= 10^5
     */

    private val testCases = mutableMapOf<Int, IntArray>()

    @Before
    fun setup() {
        testCases[2] = intArrayOf(0, 1, 1)
        testCases[5] = intArrayOf(0, 1, 1, 2, 1, 2)
    }

    /**
     * # Pseudo code
     * ## Function countBits(n):
     * 1. Create an array `ans` of size `n + 1` initialized to 0.
     * 2. For each index `i` from 1 to `n`:
     *    - Calculate `ans[i]` as `ans[i shr 1] + (i and 1)`.
     *    - `i shr 1` is equivalent to `i / 2` (right shift).
     *    - `i and 1` checks if `i` is odd (adds 1 if true).
     * 3. Return the array `ans`.
     */
    private fun countBits(n: Int): IntArray {
        val ans = IntArray(n + 1)
        for (i in 1..n) {
            ans[i] = ans[i shr 1] + (i and 1)
        }
        return ans
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating over the range [0, n]:**
     *    We iterate through each number from 0 to `n`, so the time complexity is **O(n)** where `n` is the input value.
     *
     * 2. **Bitwise operations:**
     *    Each calculation involving bitwise operations (shift and bitwise AND) takes constant time: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(n)` where `n` is the input value.
     *
     * ### Space Complexity:
     * The space complexity is **O(n)** due to the array used to store the results.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
    @Test
    fun countingBitsTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = countBits(input)
            assertArrayEquals(expectedResult, actualResult)
        }
    }
}
