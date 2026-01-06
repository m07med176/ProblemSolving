package mohamed.arfa.problemsolving.easy

import kotlin.math.abs
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class PermutationDifference {
    /**
     * # [3146. Permutation Difference between Two Strings](https://leetcode.com/problems/permutation-difference-between-two-strings/)
     * The permutation difference between two strings `s` and `t` is the sum of the absolute differences between the indices of each character in `s` and the indices of the same character in `t`.
     *
     * ## Example 1:
     * - **Input:** s = "abc", t = "bac"
     * - **Output:** 2
     *
     * ## Example 2:
     * - **Input:** s = "abcde", t = "edbac"
     * - **Output:** 12
     *
     * ## Constraints:
     * - 1 <= s.length <= 26
     * - Each character occurs at most once in `s`.
     * - `t` is a permutation of `s`.
     * - `s` consists only of lowercase English letters.
     */

    private val testCases = mutableListOf<Triple<String, String, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Triple("abc", "bac", 2) // Expected result
        )
        testCases.add(
            Triple("abcde", "edbac", 12) // Expected result
        )
        testCases.add(
            Triple("abcd", "dcba", 8) // Expected result
        )
    }

    /**
     * # Function to calculate the permutation difference
     */
    fun findPermutationDifference(s: String, t: String): Int {
        return s.mapIndexed { index, c -> abs(index - t.indexOf(c)) }.sum()
    }

    @Test
    fun findPermutationDifferenceTests() {
        testCases.forEach { (s, t, expectedResult) ->
            val actualResult = findPermutationDifference(s, t)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Index lookup in `t`:**
     *    - For each character in `s`, we find its index in `t`. This takes **O(n)** in the worst case for each character.
     *    - Since `s` has `n` characters, this process takes **O(n^2)** in total.
     *
     * 2. **Sum operation:**
     *    - Summing the absolute differences also takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n^2)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** as no additional data structures are used apart from temporary variables.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n^2)**
     * - **Space Complexity:** **O(1)**
     */
}
