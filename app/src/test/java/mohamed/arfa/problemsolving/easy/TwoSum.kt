package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class TwoSum {
    /**
     * # [1. Two Sum](https://leetcode.com/problems/two-sum/)
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     *
     * ## Example 1:
     * - **Input:** nums = [2,7,11,15], target = 9
     * - **Output:** [0,1]
     * - **Explanation:** Because nums[0] + nums[1] == 9, we return [0, 1].
     *
     * ## Example 2:
     * - **Input:** nums = [3,2,4], target = 6
     * - **Output:** [1,2]
     *
     * ## Example 3:
     * - **Input:** nums = [3,3], target = 6
     * - **Output:** [0,1]
     *
     * ## Constraints:
     * - 2 <= nums.length <= 10^4
     * - -10^9 <= nums[i] <= 10^9
     * - -10^9 <= target <= 10^9
     * - Only one valid answer exists.
     */

    private val testCases = mutableListOf<Triple<IntArray, Int, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(2, 7, 11, 15),
                9,
                intArrayOf(0, 1) // Expected: Indices 0 and 1
            )
        )
        testCases.add(
            Triple(
                intArrayOf(3, 2, 4),
                6,
                intArrayOf(1, 2) // Expected: Indices 1 and 2
            )
        )
        testCases.add(
            Triple(
                intArrayOf(3, 3),
                6,
                intArrayOf(0, 1) // Expected: Indices 0 and 1
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function twoSum(nums, target):
     * 1. Create a HashMap to store the value and its index.
     * 2. Iterate through the array:
     *    - For each element `nums[i]`, calculate `complement = target - nums[i]`.
     *    - Check if `complement` exists in the HashMap:
     *      - If it exists, return the indices `[map[complement], i]`.
     *      - Otherwise, add the current element `nums[i]` and its index `i` to the HashMap.
     * 3. Return the indices when the pair is found.
     */
    private fun twoSum(nums: IntArray, target: Int): IntArray {
        val map = mutableMapOf<Int, Int>()

        for ((index, num) in nums.withIndex()) {
            val complement = target - num
            if (map.containsKey(complement)) {
                return intArrayOf(map[complement]!!, index)
            }
            map[num] = index
        }

        throw IllegalArgumentException("No two sum solution found")
    }

    @Test
    fun twoSumTests() {
        testCases.forEach { (nums, target, expectedResult) ->
            val actualResult = twoSum(nums, target)
            assertArrayEquals(expectedResult.sortedArray(), actualResult.sortedArray())
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    The function iterates through the array once, making the complexity **O(n)** where `n` is the length of the array.
     * 2. **HashMap operations:**
     *    Insertion and lookup in a HashMap are **O(1)** on average.
     *
     * ### Space Complexity:
     * The space complexity is **O(n)** due to the HashMap storing up to `n` elements.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
