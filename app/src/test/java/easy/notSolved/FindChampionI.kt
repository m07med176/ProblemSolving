package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class FindChampionI {
    /**
     * # [2923. Find Champion I](https://leetcode.com/problems/find-champion-i/)
     * There are n teams numbered from 0 to n - 1 in a tournament. Given a 0-indexed 2D boolean matrix `grid`, return
     * the team that will be the champion of the tournament. The champion is a team that is not weaker than any other team.
     *
     * ## Example 1:
     * - **Input:** grid = [[0,1],[0,0]]
     * - **Output:** 0
     *
     * ## Example 2:
     * - **Input:** grid = [[0,0,1],[1,0,1],[0,0,0]]
     * - **Output:** 1
     *
     * ## Constraints:
     * - 2 <= n <= 100
     * - `grid[i][j]` is either 0 or 1.
     * - `grid[i][i]` is always 0.
     * - If team a is stronger than team b and team b is stronger than team c, then team a is stronger than team c.
     */

    private val testCases = mutableListOf<Pair<Array<IntArray>, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                arrayOf(
                    intArrayOf(0, 1),
                    intArrayOf(0, 0)
                ),
                0 // Expected result
            )
        )
        testCases.add(
            Pair(
                arrayOf(
                    intArrayOf(0, 0, 1),
                    intArrayOf(1, 0, 1),
                    intArrayOf(0, 0, 0)
                ),
                1 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function findChampion(grid):
     * 1. Initialize `champion` to 0 (assume team 0 is the champion initially).
     * 2. Iterate over all teams `i` (from 1 to n-1):
     *    - If `grid[champion][i] == 0`:
     *        - Update `champion` to `i` because team `i` is stronger than the current champion.
     * 3. Verify that `champion` is indeed the champion:
     *    - Iterate over all teams `j`:
     *        - If `j != champion` and `grid[j][champion] == 1`, return -1 (no valid champion exists).
     * 4. Return `champion`.
     */
    private fun findChampion(grid: Array<IntArray>): Int {
        var champion = 0

        // Step 1: Find the candidate for the champion
        for (i in grid.indices) {
            if (grid[champion][i] == 0) {
                champion = i
            }
        }

        // Step 2: Verify the candidate is the actual champion
        for (i in grid.indices) {
            if (i != champion && grid[i][champion] == 1) {
                return -1 // This shouldn't happen as per problem constraints
            }
        }

        return champion
    }

    @Test
    fun findChampionTests() {
        testCases.forEach { (grid, expectedResult) ->
            val actualResult = findChampion(grid)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Finding the candidate champion:**
     *    - Iterating through the grid takes **O(n)**.
     *
     * 2. **Verifying the champion:**
     *    - Iterating through the grid again takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** since no additional data structures are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
