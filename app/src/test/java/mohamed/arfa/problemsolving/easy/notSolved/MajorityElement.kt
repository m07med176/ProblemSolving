package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MajorityElement {
    /**
     * # [169. Majority Element](https://leetcode.com/problems/majority-element/)
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     *
     * ## Example 1:
     * - **Input:** nums = [3,2,3]
     * - **Output:** 3
     *
     * ## Example 2:
     * - **Input:** nums = [2,2,1,1,1,2,2]
     * - **Output:** 2
     *
     * ## Constraints:
     * - n == nums.length
     * - 1 <= n <= 5 * 10^4
     * - -10^9 <= nums[i] <= 10^9
     */

    private val testCases = mutableListOf<Pair<IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(3, 2, 3),
                3 // Expected: 3
            )
        )
        testCases.add(
            Pair(
                intArrayOf(2, 2, 1, 1, 1, 2, 2),
                2 // Expected: 2
            )
        )
        testCases.add(
            Pair(
                intArrayOf(1),
                1 // Expected: 1
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function majorityElement(nums):
     * 1. Use Boyer-Moore Voting Algorithm:
     *    - Initialize `count` to 0 and `candidate` to null.
     *    - Iterate through the array:
     *      - If `count` is 0, set `candidate` to the current element.
     *      - Increment `count` if the current element is the same as `candidate`, otherwise decrement `count`.
     * 2. The `candidate` at the end of the iteration is the majority element.
     * 3. Return the `candidate`.
     */
    private fun majorityElement(nums: IntArray): Int {
        var count = 0
        var candidate: Int? = null

        for (num in nums) {
            if (count == 0) {
                candidate = num
            }
            count += if (num == candidate) 1 else -1
        }

        return candidate!!
    }

    @Test
    fun majorityElementTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = majorityElement(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    The function iterates through the array once, making the complexity **O(n)** where `n` is the length of the array.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since only a few variables are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
