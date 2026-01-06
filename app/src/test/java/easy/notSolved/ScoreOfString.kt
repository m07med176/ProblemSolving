package mohamed.arfa.problemsolving.easy

import kotlin.math.abs
import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ScoreOfString {
    /**
     * # [3110. Score of a String](https://leetcode.com/problems/score-of-a-string/)
     * The score of a string is defined as the sum of the absolute difference between the ASCII values of adjacent characters.
     *
     * ## Example 1:
     * - **Input:** s = "hello"
     * - **Output:** 13
     *
     * ## Example 2:
     * - **Input:** s = "zaz"
     * - **Output:** 50
     *
     * ## Constraints:
     * - 2 <= s.length <= 100
     * - `s` consists only of lowercase English letters.
     */

    private val testCases = mutableListOf<Pair<String, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                "hello",
                13 // Expected result
            )
        )
        testCases.add(
            Pair(
                "zaz",
                50 // Expected result
            )
        )
        testCases.add(
            Pair(
                "abcd",
                3 // Expected result
            )
        )
    }

    /**
     * # Function to calculate the score of a string
     */
    fun scoreOfString(s: String): Int {
        return s.zipWithNext { a, b -> abs(a - b) }.sum()
    }

    /**
     * # Alternative Implementation (For Demonstration)
     */
    fun scoreOfStringOld(s: String): Int {
        var sum = 0
        for (i in 1 until s.length) {
            sum += abs(s[i] - s[i - 1])
        }
        return sum
    }

    @Test
    fun scoreOfStringTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = scoreOfString(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the string:**
     *    - Using `zipWithNext` processes adjacent pairs of characters in **O(n)** time.
     *
     * 2. **Summing differences:**
     *    - Calculating the sum of differences also takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** as no additional data structures are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
