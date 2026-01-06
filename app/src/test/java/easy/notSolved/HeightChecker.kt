package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class HeightChecker {
    /**
     * # [1051. Height Checker](https://leetcode.com/problems/height-checker/)
     * A school is trying to take an annual photo of all the students. The students are asked to stand in non-decreasing order by height.
     * Let this ordering be represented by the integer array `expected` where `expected[i]` is the expected height of the `i-th` student in line.
     *
     * ## Example 1:
     * - **Input:** heights = [1,1,4,2,1,3]
     * - **Output:** 3
     *
     * ## Example 2:
     * - **Input:** heights = [5,1,2,3,4]
     * - **Output:** 5
     *
     * ## Example 3:
     * - **Input:** heights = [1,2,3,4,5]
     * - **Output:** 0
     *
     * ## Constraints:
     * - 1 <= heights.length <= 100
     * - 1 <= heights[i] <= 100
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(1, 1, 4, 2, 1, 3),
                3 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(5, 1, 2, 3, 4),
                5 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 2, 3, 4, 5),
                0 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function heightChecker(heights):
     * 1. Create a sorted copy of the `heights` array, called `expected`.
     * 2. Initialize a counter `count` to 0.
     * 3. Iterate through both `heights` and `expected`:
     *    - If `heights[i] != expected[i]`, increment `count`.
     * 4. Return `count`.
     */
    private fun heightChecker(heights: IntArray): Int {
        val expected = heights.sortedArray()
        var count = 0

        for (i in heights.indices) {
            if (heights[i] != expected[i]) {
                count++
            }
        }

        return count
    }

    @Test
    fun heightCheckerTests() {
        testCases.forEach { (heights, expectedResult) ->
            val actualResult = heightChecker(heights)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting the array:**
     *    Sorting the `expected` array takes **O(n log n)** where `n` is the size of the array.
     *
     * 2. **Comparing arrays:**
     *    Comparing the elements of `heights` and `expected` takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for storing the `expected` array.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(n)**
     */
}
