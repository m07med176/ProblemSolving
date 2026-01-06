package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class SortThePeople {
    /**
     * # [2418. Sort the People](https://leetcode.com/problems/sort-the-people/)
     * Given an array of strings `names` and an array `heights`, return names sorted in descending order by the people's heights.
     *
     * ## Example 1:
     * - **Input:** names = ["Mary","John","Emma"], heights = [180,165,170]
     * - **Output:** ["Mary","Emma","John"]
     *
     * ## Example 2:
     * - **Input:** names = ["Alice","Bob","Bob"], heights = [155,185,150]
     * - **Output:** ["Bob","Alice","Bob"]
     *
     * ## Constraints:
     * - n == names.length == heights.length
     * - 1 <= n <= 10^3
     * - 1 <= names[i].length <= 20
     * - 1 <= heights[i] <= 10^5
     * - names[i] consists of lower and upper case English letters.
     * - All the values of heights are distinct.
     */

    private val testCases = mutableListOf<Pair<Array<String>, Pair<IntArray, Array<String>>>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                arrayOf("Mary", "John", "Emma"),
                Pair(intArrayOf(180, 165, 170), arrayOf("Mary", "Emma", "John"))
            )
        )
        testCases.add(
            Pair(
                arrayOf("Alice", "Bob", "Bob"),
                Pair(intArrayOf(155, 185, 150), arrayOf("Bob", "Alice", "Bob"))
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function sortPeople(names, heights):
     * 1. Combine names and heights into a list of pairs.
     * 2. Sort the list of pairs by the height in descending order.
     * 3. Extract the names from the sorted list of pairs.
     * 4. Return the sorted names.
     */
    private fun sortPeople(names: Array<String>, heights: IntArray): Array<String> {
        return names.zip(heights.asList())
            .sortedByDescending { it.second }
            .map { it.first }
            .toTypedArray()
    }

    @Test
    fun sortPeopleTests() {
        testCases.forEach { (names, pair) ->
            val (heights, expectedResult) = pair
            val actualResult = sortPeople(names, heights)
            assertArrayEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Combining names and heights:**
     *    - Zipping the arrays takes **O(n)**.
     *
     * 2. **Sorting:**
     *    - Sorting the array of pairs takes **O(n log n)**.
     *
     * 3. **Extracting names:**
     *    - Extracting names after sorting takes **O(n)**.
     *
     * 4. **Overall Complexity:**
     *    - The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for storing the list of pairs and the sorted result.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(n)**
     */
}
