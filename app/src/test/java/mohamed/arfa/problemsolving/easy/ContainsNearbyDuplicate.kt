package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ContainsNearbyDuplicate {
    /**
     * # [219. Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)
     * Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices `i` and `j`
     * such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
     *
     * ## Example 1:
     * - **Input:** nums = [1,2,3,1], k = 3
     * - **Output:** true
     *
     * ## Example 2:
     * - **Input:** nums = [1,0,1,1], k = 1
     * - **Output:** true
     *
     * ## Example 3:
     * - **Input:** nums = [1,2,3,1,2,3], k = 2
     * - **Output:** false
     *
     * ## Constraints:
     * - 1 <= nums.length <= 10^5
     * - -10^9 <= nums[i] <= 10^9
     * - 0 <= k <= 10^5
     */

    private val testCases = mutableListOf<Triple<IntArray, Int, Boolean>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(1, 2, 3, 1),
                3,
                true // Expected result
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1, 0, 1, 1),
                1,
                true // Expected result
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1, 2, 3, 1, 2, 3),
                2,
                false // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function containsNearbyDuplicate(nums, k):
     * 1. Initialize an empty `Map` to store the last seen index of each number.
     * 2. Iterate through the array `nums` with index `i` and value `num`:
     *    - If `num` exists in the `Map` and `i - map[num] <= k`, return `true`.
     *    - Otherwise, update the map with the current index of `num`.
     * 3. If no duplicates are found within the distance `k`, return `false`.
     */
    private fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val lastSeen = mutableMapOf<Int, Int>()

        for ((i, num) in nums.withIndex()) {
            if (lastSeen.containsKey(num) && i - lastSeen[num]!! <= k) {
                return true
            }
            lastSeen[num] = i
        }

        return false
    }

    @Test
    fun containsNearbyDuplicateTests() {
        testCases.forEach { (nums, k, expectedResult) ->
            val actualResult = containsNearbyDuplicate(nums, k)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    - This takes **O(n)** where `n` is the size of the `nums` array.
     *
     * 2. **Map operations (lookup and update):**
     *    - Each operation takes **O(1)** on average, resulting in a total of **O(n)** for all elements.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for the `Map`, where `n` is the number of unique elements in `nums`.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
