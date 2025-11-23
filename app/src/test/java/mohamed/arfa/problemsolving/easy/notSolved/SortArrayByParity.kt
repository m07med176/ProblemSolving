package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class SortArrayByParity {
    /**
     * # [905. Sort Array By Parity](https://leetcode.com/problems/sort-array-by-parity/)
     * Given an integer array `nums`, move all the even integers at the beginning of the array followed by all the odd integers.
     * Return any array that satisfies this condition.
     *
     * ## Example 1:
     * - **Input:** nums = [3,1,2,4]
     * - **Output:** [2,4,3,1]
     *
     * ## Example 2:
     * - **Input:** nums = [0]
     * - **Output:** [0]
     *
     * ## Constraints:
     * - 1 <= nums.length <= 5000
     * - 0 <= nums[i] <= 5000
     */

    private val testCases = mutableListOf<Pair<IntArray, List<Int>>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(3, 1, 2, 4),
                listOf(2, 4, 3, 1) // Expected: Any valid parity arrangement
            )
        )
        testCases.add(
            Pair(
                intArrayOf(0),
                listOf(0) // Expected: [0]
            )
        )
        testCases.add(
            Pair(
                intArrayOf(2, 3, 5, 8, 6),
                listOf(2, 8, 6, 3, 5) // Expected: Even followed by odd
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function sortArrayByParity(nums):
     * 1. Initialize two lists: `evens` and `odds`.
     * 2. Iterate through the array:
     *    - Add even numbers to the `evens` list.
     *    - Add odd numbers to the `odds` list.
     * 3. Combine `evens` and `odds` and return the result as an array.
     */
    private fun sortArrayByParity(nums: IntArray): IntArray {
        val evens = mutableListOf<Int>()
        val odds = mutableListOf<Int>()

        for (num in nums) {
            if (num % 2 == 0) {
                evens.add(num)
            } else {
                odds.add(num)
            }
        }

        return (evens + odds).toIntArray()
    }

    @Test
    fun sortArrayByParityTests() {
        testCases.forEach { (nums, expectedResult) ->
            val actualResult = sortArrayByParity(nums).toList()
            val isValid = actualResult.subList(0, actualResult.size / 2).all { it % 2 == 0 } &&
                    actualResult.subList(actualResult.size / 2, actualResult.size).all { it % 2 != 0 }
            assertTrue(isValid)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    - This operation takes **O(n)** where `n` is the size of the array.
     *
     * 2. **Combining two lists:**
     *    - Combining `evens` and `odds` into a single array takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** due to the additional `evens` and `odds` lists.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
