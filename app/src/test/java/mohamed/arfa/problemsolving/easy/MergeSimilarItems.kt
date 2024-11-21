package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MergeSimilarItems {
    /**
     * # [2363. Merge Similar Items](https://leetcode.com/problems/merge-similar-items/)
     * Given two 2D integer arrays `items1` and `items2`, representing two sets of items, return a 2D integer array
     * where each item is represented by its value and the sum of its weights. The result must be sorted in ascending order by value.
     *
     * ## Example 1:
     * - **Input:** items1 = [[1,1],[4,5],[3,8]], items2 = [[3,1],[1,5]]
     * - **Output:** [[1,6],[3,9],[4,5]]
     *
     * ## Example 2:
     * - **Input:** items1 = [[1,1],[3,2],[2,3]], items2 = [[2,1],[3,2],[1,3]]
     * - **Output:** [[1,4],[2,4],[3,4]]
     *
     * ## Example 3:
     * - **Input:** items1 = [[1,3],[2,2]], items2 = [[7,1],[2,2],[1,4]]
     * - **Output:** [[1,7],[2,4],[7,1]]
     *
     * ## Constraints:
     * - 1 <= items1.length, items2.length <= 1000
     * - items1[i].length == items2[i].length == 2
     * - 1 <= valuei, weighti <= 1000
     * - Each valuei in items1 is unique.
     * - Each valuei in items2 is unique.
     */

    private val testCases = mutableListOf<Triple<Array<IntArray>, Array<IntArray>, List<List<Int>>>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                arrayOf(intArrayOf(1, 1), intArrayOf(4, 5), intArrayOf(3, 8)),
                arrayOf(intArrayOf(3, 1), intArrayOf(1, 5)),
                listOf(listOf(1, 6), listOf(3, 9), listOf(4, 5)) // Expected result
            )
        )
        testCases.add(
            Triple(
                arrayOf(intArrayOf(1, 1), intArrayOf(3, 2), intArrayOf(2, 3)),
                arrayOf(intArrayOf(2, 1), intArrayOf(3, 2), intArrayOf(1, 3)),
                listOf(listOf(1, 4), listOf(2, 4), listOf(3, 4)) // Expected result
            )
        )
        testCases.add(
            Triple(
                arrayOf(intArrayOf(1, 3), intArrayOf(2, 2)),
                arrayOf(intArrayOf(7, 1), intArrayOf(2, 2), intArrayOf(1, 4)),
                listOf(listOf(1, 7), listOf(2, 4), listOf(7, 1)) // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function mergeSimilarItems(items1, items2):
     * 1. Create a `Map` to store the total weight for each value.
     * 2. Iterate through `items1` and add each value and weight to the map.
     * 3. Iterate through `items2` and update the map with the sum of weights for each value.
     * 4. Convert the map entries to a list of lists, sorted by value.
     * 5. Return the sorted list of lists.
     */
    private fun mergeSimilarItems(items1: Array<IntArray>, items2: Array<IntArray>): List<List<Int>> {
        val weightMap = mutableMapOf<Int, Int>()

        // Add weights from items1
        for (item in items1) {
            val value = item[0]
            val weight = item[1]
            weightMap[value] = weightMap.getOrDefault(value, 0) + weight
        }

        // Add weights from items2
        for (item in items2) {
            val value = item[0]
            val weight = item[1]
            weightMap[value] = weightMap.getOrDefault(value, 0) + weight
        }

        // Convert map to sorted list of lists
        return weightMap.entries
            .sortedBy { it.key }
            .map { listOf(it.key, it.value) }
    }

    @Test
    fun mergeSimilarItemsTests() {
        testCases.forEach { (items1, items2, expectedResult) ->
            val actualResult = mergeSimilarItems(items1, items2)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Inserting into the map:**
     *    - For both `items1` and `items2`, this takes **O(n + m)**, where `n` is the size of `items1` and `m` is the size of `items2`.
     *
     * 2. **Sorting the map:**
     *    - Sorting the entries in the map takes **O(k log k)**, where `k` is the number of unique keys in the map.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n + m + k log k)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(k)** for the map, where `k` is the number of unique keys.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n + m + k log k)**
     * - **Space Complexity:** **O(k)**
     */
}
