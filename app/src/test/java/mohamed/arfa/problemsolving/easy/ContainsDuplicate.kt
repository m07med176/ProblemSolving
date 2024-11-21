package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ContainsDuplicate {
    /**
     * # [217. Contains Duplicate](https://leetcode.com/problems/contains-duplicate/)
     * Given an integer array nums, return true if any value appears at least twice in the array,
     * and return false if every element is distinct.
     *
     * ## Example 1:
     * - **Input:** nums = [1,2,3,1]
     * - **Output:** true
     * - **Explanation:** The element 1 occurs at the indices 0 and 3.
     *
     * ## Example 2:
     * - **Input:** nums = [1,2,3,4]
     * - **Output:** false
     * - **Explanation:** All elements are distinct.
     *
     * ## Example 3:
     * - **Input:** nums = [1,1,1,3,3,4,3,2,4,2]
     * - **Output:** true
     *
     * ## Constraints:
     * - 1 <= nums.length <= 10^5
     * - -10^9 <= nums[i] <= 10^9
     */

    private val testCases = mutableListOf<Pair<IntArray, Boolean>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(1, 2, 3, 1),
                true // Expected: true (1 is repeated)
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 2, 3, 4),
                false // Expected: false (all elements are unique)
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2),
                true // Expected: true (multiple duplicates exist)
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function containsDuplicate(nums):
     * 1. Create an empty set to store unique elements.
     * 2. Iterate through the array:
     *    - If the current element is already in the set, return true.
     *    - Otherwise, add the current element to the set.
     * 3. If the loop completes without finding duplicates, return false.
     */
    private fun containsDuplicate(nums: IntArray): Boolean {
        val seen = mutableSetOf<Int>()
        for (num in nums) {
            if (num in seen) return true
            seen.add(num)
        }
        return false
    }

    @Test
    fun containsDuplicateTests() {
        testCases.forEach { (nums, expectedResult) ->
            val actualResult = containsDuplicate(nums)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    The function iterates through the array once, making the complexity **O(n)** where `n` is the length of the array.
     * 2. **Set operations:**
     *    Adding and checking elements in a set is **O(1)** on average.
     *
     * ### Space Complexity:
     * The space complexity is **O(n)** due to the additional set used to store unique elements.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
