package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class FindPeaks {
    /**
     * # [2951. Find the Peaks](https://leetcode.com/problems/find-the-peaks/)
     * Given a 0-indexed array `mountain`, find all the peaks in the array. A peak is an element strictly greater than its neighbors.
     * Return an array of indices of the peaks.
     *
     * ## Example 1:
     * - **Input:** mountain = [2,4,4]
     * - **Output:** []
     *
     * ## Example 2:
     * - **Input:** mountain = [1,4,3,8,5]
     * - **Output:** [1,3]
     *
     * ## Constraints:
     * - 3 <= mountain.length <= 100
     * - 1 <= mountain[i] <= 100
     */

    private val testCases = mutableListOf<Pair<IntArray, List<Int>>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(2, 4, 4),
                listOf() // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 4, 3, 8, 5),
                listOf(1, 3) // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(3, 6, 4, 7, 6, 8),
                listOf(1, 3, 5) // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function findPeaks(mountain):
     * 1. Initialize an empty list `peaks` to store indices of peaks.
     * 2. Iterate from the second element to the second-last element of the array (index 1 to n-2).
     * 3. For each index `i`, check if `mountain[i] > mountain[i-1]` and `mountain[i] > mountain[i+1]`.
     *    - If true, add `i` to `peaks`.
     * 4. Return the `peaks` list.
     */
    private fun findPeaks(mountain: IntArray): List<Int> {
        val peaks = mutableListOf<Int>()

        for (i in 1 until mountain.size - 1) {
            if (mountain[i] > mountain[i - 1] && mountain[i] > mountain[i + 1]) {
                peaks.add(i)
            }
        }

        return peaks
    }

    @Test
    fun findPeaksTests() {
        testCases.forEach { (mountain, expectedResult) ->
            val actualResult = findPeaks(mountain)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    - The iteration takes **O(n)**, where `n` is the size of the array.
     *
     * 2. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(k)**, where `k` is the number of peaks found (to store the indices).
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(k)**
     */
}
