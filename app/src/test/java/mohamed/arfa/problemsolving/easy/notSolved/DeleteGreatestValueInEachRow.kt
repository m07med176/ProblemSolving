package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class DeleteGreatestValueInEachRow {
    /**
     * # [2500. Delete Greatest Value in Each Row](https://leetcode.com/problems/delete-greatest-value-in-each-row/)
     * You are given an m x n matrix grid consisting of positive integers.
     *
     * Perform the following operation until grid becomes empty:
     * 1. Delete the element with the greatest value from each row.
     * 2. Add the maximum of the deleted elements to the answer.
     * 3. Continue until all rows are empty.
     *
     * ## Example 1:
     * - **Input:** grid = [[1,2,4],[3,3,1]]
     * - **Output:** 8
     *
     * ## Example 2:
     * - **Input:** grid = [[10]]
     * - **Output:** 10
     *
     * ## Constraints:
     * - 1 <= m, n <= 50
     * - 1 <= grid[i][j] <= 100
     */

    private val testCases = mutableListOf<Pair<Array<IntArray>, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                arrayOf(
                    intArrayOf(1, 2, 4),
                    intArrayOf(3, 3, 1)
                ),
                8 // Expected result
            )
        )
        testCases.add(
            Pair(
                arrayOf(
                    intArrayOf(10)
                ),
                10 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function deleteGreatestValue(grid):
     * 1. Sort each row in descending order.
     * 2. Initialize `totalSum` to 0.
     * 3. For each column (from the first to the last):
     *    - Extract the largest value from each row (at the current column index).
     *    - Add the maximum of these values to `totalSum`.
     * 4. Return `totalSum`.
     */
    private fun deleteGreatestValue(grid: Array<IntArray>): Int {
        // Sort each row in descending order
        grid.forEach { it.sortDescending() }

        var totalSum = 0

        // Iterate through columns
        for (col in 0 until grid[0].size) {
            var maxInColumn = 0
            for (row in grid.indices) {
                maxInColumn = maxOf(maxInColumn, grid[row][col])
            }
            totalSum += maxInColumn
        }

        return totalSum
    }

    @Test
    fun deleteGreatestValueTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = deleteGreatestValue(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting rows:**
     *    - Each row is sorted in descending order, taking **O(n log n)** per row.
     *    - For `m` rows, this takes **O(m * n log n)** in total.
     *
     * 2. **Iterating through columns:**
     *    - For each column, iterate through `m` rows, taking **O(m * n)** in total.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(m * n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** for in-place sorting.
     *
     * ### Summary:
     * - **Time Complexity:** **O(m * n log n)**
     * - **Space Complexity:** **O(1)**
     */
}
