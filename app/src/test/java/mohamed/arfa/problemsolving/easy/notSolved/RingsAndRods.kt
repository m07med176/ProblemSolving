package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class RingsAndRods {
    /**
     * # [2103. Rings and Rods](https://leetcode.com/problems/rings-and-rods/)
     * You are given a string `rings` that describes the rings placed onto rods labeled from `0` to `9`. Return the number of rods that have all three colors of rings on them.
     *
     * ## Example 1:
     * - **Input:** rings = "B0B6G0R6R0R6G9"
     * - **Output:** 1
     *
     * ## Example 2:
     * - **Input:** rings = "B0R0G0R9R0B0G0"
     * - **Output:** 1
     *
     * ## Example 3:
     * - **Input:** rings = "G4"
     * - **Output:** 0
     *
     * ## Constraints:
     * - `rings.length == 2 * n`
     * - `1 <= n <= 100`
     * - `rings[i]` where `i` is even is either `'R'`, `'G'`, or `'B'`.
     * - `rings[i]` where `i` is odd is a digit from `'0'` to `'9'`.
     */

    private val testCases = mutableListOf<Pair<String, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair("B0B6G0R6R0R6G9", 1) // Expected result
        )
        testCases.add(
            Pair("B0R0G0R9R0B0G0", 1) // Expected result
        )
        testCases.add(
            Pair("G4", 0) // Expected result
        )
    }

    /**
     * # Function to calculate the number of rods with all three colors
     */
    fun countPoints(rings: String): Int {
        val rodMap = mutableMapOf<Char, MutableSet<Char>>()

        for (i in rings.indices step 2) {
            val color = rings[i]
            val rod = rings[i + 1]
            rodMap.computeIfAbsent(rod) { mutableSetOf() }.add(color)
        }

        return rodMap.values.count { it.size == 3 }
    }

    @Test
    fun countPointsTests() {
        testCases.forEach { (rings, expectedResult) ->
            val actualResult = countPoints(rings)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Processing the string:**
     *    - The loop runs for half the length of `rings`, so it takes **O(n)** where `n` is the length of `rings`.
     *
     * 2. **Counting rods with all three colors:**
     *    - Counting the sets in `rodMap` takes **O(10)** since there are at most 10 rods.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(10)** for the map storing at most 10 rods.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)** (constant with respect to the number of rods)
     */
}
