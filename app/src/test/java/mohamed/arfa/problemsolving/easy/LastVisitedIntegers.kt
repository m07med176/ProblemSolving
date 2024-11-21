package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class LastVisitedIntegers {
    /**
     * # [2899. Last Visited Integers](https://leetcode.com/problems/last-visited-integers/)
     * Given an integer array `nums` where each element is either a positive integer or -1, find the "last visited integers."
     *
     * ## Example 1:
     * - **Input:** nums = [1,2,-1,-1,-1]
     * - **Output:** [2,1,-1]
     *
     * ## Example 2:
     * - **Input:** nums = [1,-1,2,-1,-1]
     * - **Output:** [1,2,1]
     *
     * ## Constraints:
     * - 1 <= nums.length <= 100
     * - `nums[i] == -1` or `1 <= nums[i] <= 100`
     */

    private val testCases = mutableListOf<Pair<IntArray, List<Int>>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(1, 2, -1, -1, -1),
                listOf(2, 1, -1) // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1, -1, 2, -1, -1),
                listOf(1, 2, 1) // Expected result
            )
        )
        testCases.add(
            Pair(
                intArrayOf(-1, -1, -1),
                listOf(-1, -1, -1) // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function lastVisitedIntegers(nums):
     * 1. Initialize two lists: `seen` (to store positive integers) and `ans` (to store the result).
     * 2. Initialize a counter `k` to count consecutive -1s.
     * 3. Iterate through the `nums` array:
     *    - If the current element is positive:
     *        - Prepend it to `seen`.
     *        - Reset `k` to 0.
     *    - If the current element is -1:
     *        - Increment `k`.
     *        - If `k` is less than or equal to the size of `seen`:
     *            - Append the `k-th` element in `seen` to `ans`.
     *        - Otherwise, append -1 to `ans`.
     * 4. Return `ans`.
     */
    private fun lastVisitedIntegers(nums: IntArray): List<Int> {
        val seen = mutableListOf<Int>()
        val ans = mutableListOf<Int>()
        var k = 0

        for (num in nums) {
            if (num == -1) {
                k++
                if (k <= seen.size) {
                    ans.add(seen[k - 1])
                } else {
                    ans.add(-1)
                }
            } else {
                seen.add(0, num) // Prepend the positive integer
                k = 0 // Reset k
            }
        }

        return ans
    }

    @Test
    fun lastVisitedIntegersTests() {
        testCases.forEach { (nums, expectedResult) ->
            val actualResult = lastVisitedIntegers(nums)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    - This takes **O(n)**, where `n` is the size of the `nums` array.
     *
     * 2. **Prepending to the `seen` list:**
     *    - Prepending takes **O(n)** in the worst case when called multiple times, but the overall contribution is **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for storing the `seen` and `ans` lists.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
