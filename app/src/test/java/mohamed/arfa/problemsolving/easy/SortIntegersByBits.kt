package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class SortIntegersByBits {
    /**
     * # [1356. Sort Integers by The Number of 1 Bits](https://leetcode.com/problems/sort-integers-by-the-number-of-1-bits/)
     * Given an integer array `arr`, sort the integers in ascending order by the number of 1's in their binary representation.
     * If two or more integers have the same number of 1's, sort them in ascending order.
     *
     * ## Example 1:
     * - **Input:** arr = [0,1,2,3,4,5,6,7,8]
     * - **Output:** [0,1,2,4,8,3,5,6,7]
     *
     * ## Example 2:
     * - **Input:** arr = [1024,512,256,128,64,32,16,8,4,2,1]
     * - **Output:** [1,2,4,8,16,32,64,128,256,512,1024]
     *
     * ## Constraints:
     * - 1 <= arr.length <= 500
     * - 0 <= arr[i] <= 10^4
     */

    private val testCases = mutableListOf<Pair<IntArray, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(0, 1, 2, 3, 4, 5, 6, 7, 8),
                intArrayOf(0, 1, 2, 4, 8, 3, 5, 6, 7) // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1024, 512, 256, 128, 64, 32, 16, 8, 4, 2, 1),
                intArrayOf(1, 2, 4, 8, 16, 32, 64, 128, 256, 512, 1024) // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function sortByBits(arr):
     * 1. Define a sorting comparator that:
     *    - First compares numbers by the count of 1's in their binary representation.
     *    - If two numbers have the same count, compares them by their value.
     * 2. Sort the array using this comparator.
     * 3. Return the sorted array.
     */
    private fun sortByBits(arr: IntArray): IntArray {
        return arr.sortedWith(compareBy({ Integer.bitCount(it) }, { it })).toIntArray()
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting the array:**
     *    - Sorting takes **O(n log n)** where `n` is the length of the array.
     *    - Calculating the number of 1 bits for each number is a constant-time operation: **O(1)** for each number.
     *
     * 2. **Overall Complexity:**
     *    - The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for storing the sorted array.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(n)**
     */
    @Test
    fun sortByBitsTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = sortByBits(input)
            assertArrayEquals(expectedResult, actualResult)
        }
    }


}
