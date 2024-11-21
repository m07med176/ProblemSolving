package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class JewelsAndStones {
    /**
     * # [771. Jewels and Stones](https://leetcode.com/problems/jewels-and-stones/)
     * You're given strings `jewels` representing the types of stones that are jewels, and `stones` representing the stones you have.
     * Each character in `stones` is a type of stone you have.
     * You want to know how many of the stones you have are also jewels.
     *
     * ## Example 1:
     * - **Input:** jewels = "aA", stones = "aAAbbbb"
     * - **Output:** 3
     *
     * ## Example 2:
     * - **Input:** jewels = "z", stones = "ZZ"
     * - **Output:** 0
     *
     * ## Constraints:
     * - 1 <= jewels.length, stones.length <= 50
     * - `jewels` and `stones` consist of only English letters.
     * - All the characters of `jewels` are unique.
     */

    private val testCases = mutableListOf<Triple<String, String, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Triple("aA", "aAAbbbb", 3) // Expected result
        )
        testCases.add(
            Triple("z", "ZZ", 0) // Expected result
        )
        testCases.add(
            Triple("bB", "bbBccBB", 5) // Expected result
        )
    }

    /**
     * # Function to count the number of jewels in stones
     */
    fun numJewelsInStones(jewels: String, stones: String): Int {
        return jewels.sumOf { jewel -> stones.count { it == jewel } }
    }

    @Test
    fun numJewelsInStonesTests() {
        testCases.forEach { (jewels, stones, expectedResult) ->
            val actualResult = numJewelsInStones(jewels, stones)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating over `jewels`:**
     *    - This loop runs for each character in `jewels`, so it takes **O(m)**, where `m` is the length of `jewels`.
     *
     * 2. **Counting occurrences in `stones`:**
     *    - For each character in `jewels`, counting occurrences in `stones` takes **O(n)**, where `n` is the length of `stones`.
     *    - The total time complexity is **O(m * n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** as no additional data structures are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(m * n)**
     * - **Space Complexity:** **O(1)**
     */
}
