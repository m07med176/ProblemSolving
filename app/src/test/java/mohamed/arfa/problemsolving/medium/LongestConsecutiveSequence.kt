package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class LongestConsecutiveSequence {
    /**
     * # [128. Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
     * Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
     * You must write an algorithm that runs in O(n) time.
     *
     * ## Example 1:
     * - **Input:** nums = [100,4,200,1,3,2]
     * - **Output:** 4
     * - **Explanation:** The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
     *
     * ## Example 2:
     * - **Input:** nums = [0,3,7,2,5,8,4,6,0,1]
     * - **Output:** 9
     *
     * ## Constraints:
     * - 0 <= nums.length <= 10^5
     * - -10^9 <= nums[i] <= 10^9
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(100, 4, 200, 1, 3, 2),
                4 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1),
                9 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(),
                0 // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, 2, 0, 1),
                3 // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function longestConsecutive(nums):
     * 1. Create a HashSet from the nums array to allow O(1) access.
     * 2. Initialize a variable `longestStreak` to 0.
     * 3. Iterate through each number in nums:
     *    - If `num - 1` is not in the set, it's the start of a sequence.
     *    - Initialize `currentNum` to `num` and `currentStreak` to 1.
     *    - While `currentNum + 1` is in the set:
     *        - Increment `currentNum` and `currentStreak`.
     *    - Update `longestStreak` if `currentStreak` is greater.
     * 4. Return `longestStreak`.
     */
    private fun longestConsecutive(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val numSet = nums.toHashSet()
        var longestStreak = 0

        for (num in numSet) {
            // Check if it's the start of a sequence
            if (!numSet.contains(num - 1)) {
                var currentNum = num
                var currentStreak = 1

                while (numSet.contains(currentNum + 1)) {
                    currentNum += 1
                    currentStreak += 1
                }

                longestStreak = maxOf(longestStreak, currentStreak)
            }
        }

        return longestStreak
    }

    @Test
    fun longestConsecutiveTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = longestConsecutive(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Creating the HashSet:**
     *    - Converting the array to a HashSet takes **O(n)** time.
     *
     * 2. **Iterating through the set:**
     *    - We iterate through each unique number once, so **O(n)** iterations.
     *    - Inside the loop, we might do additional iterations to find consecutive numbers, but each number is visited at most once in this inner loop.
     *    - Therefore, the total time complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** due to the HashSet storing up to `n` elements.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
