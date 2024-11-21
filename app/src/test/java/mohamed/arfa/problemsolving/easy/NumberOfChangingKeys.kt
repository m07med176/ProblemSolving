package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class NumberOfChangingKeys {
    /**
     * # [3019. Number of Changing Keys](https://leetcode.com/problems/number-of-changing-keys/)
     * You are given a string `s`. Changing a key is defined as using a key different from the last used key (ignoring case).
     * Return the number of times the user had to change the key.
     *
     * ## Example 1:
     * - **Input:** s = "aAbBcC"
     * - **Output:** 2
     *
     * ## Example 2:
     * - **Input:** s = "AaAaAaaA"
     * - **Output:** 0
     *
     * ## Constraints:
     * - 1 <= s.length <= 100
     * - `s` consists of only upper and lower case English letters.
     */

    private val testCases = mutableListOf<Pair<String, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair("aAbBcC", 2) // Expected result
        )
        testCases.add(
            Pair("AaAaAaaA", 0) // Expected result
        )
        testCases.add(
            Pair("abcABCabc", 2) // Expected result
        )
    }

    /**
     * # Function to count the number of key changes
     */
    fun countKeyChanges(s: String): Int {
        val lowerCase = s.toLowerCase()
        var changes = 0
        for (i in 1 until lowerCase.length) {
            if (lowerCase[i] != lowerCase[i - 1]) {
                changes++
            }
        }
        return changes
    }

    @Test
    fun countKeyChangesTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = countKeyChanges(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Converting string to lowercase:**
     *    - This takes **O(n)**, where `n` is the length of the string.
     *
     * 2. **Iterating through the string:**
     *    - Comparing each character with its previous one takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** since no additional data structures are used, apart from a few variables.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
