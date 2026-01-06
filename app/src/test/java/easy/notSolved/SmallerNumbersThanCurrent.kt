package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class SmallerNumbersThanCurrent {
    /**
     * # [1365. How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)
     * Given the array nums, for each nums[i] find out how many numbers in the array are smaller than it.
     *
     * ## Example 1:
     * - **Input:** nums = [8,1,2,2,3]
     * - **Output:** [4,0,1,1,3]
     *
     * ## Example 2:
     * - **Input:** nums = [6,5,4,8]
     * - **Output:** [2,1,0,3]
     *
     * ## Example 3:
     * - **Input:** nums = [7,7,7,7]
     * - **Output:** [0,0,0,0]
     *
     * ## Constraints:
     * - 2 <= nums.length <= 500
     * - 0 <= nums[i] <= 100
     */

    private val testCases = mutableListOf<Pair<IntArray, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                intArrayOf(8, 1, 2, 2, 3),
                intArrayOf(4, 0, 1, 1, 3) // Expected: [4, 0, 1, 1, 3]
            )
        )
        testCases.add(
            Pair(
                intArrayOf(6, 5, 4, 8),
                intArrayOf(2, 1, 0, 3) // Expected: [2, 1, 0, 3]
            )
        )
        testCases.add(
            Pair(
                intArrayOf(7, 7, 7, 7),
                intArrayOf(0, 0, 0, 0) // Expected: [0, 0, 0, 0]
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function smallerNumbersThanCurrent(nums):
     * 1. Create a frequency array of size 101 (range of nums is 0 to 100).
     * 2. Count the occurrences of each number in the frequency array.
     * 3. Create a prefix sum of the frequency array to store the number of elements smaller than each number.
     * 4. Traverse nums, and for each number, get the count of smaller numbers from the prefix array.
     * 5. Return the result array.
     */
    private fun smallerNumbersThanCurrent(nums: IntArray): IntArray {
        val freq = IntArray(101) { 0 }

        // Count frequencies of each number
        for (num in nums) {
            freq[num]++
        }

        // Create prefix sum array
        for (i in 1..100) {
            freq[i] += freq[i - 1]
        }

        // Build the result array
        return nums.map { if (it > 0) freq[it - 1] else 0 }.toIntArray()
    }

    @Test
    fun smallerNumbersThanCurrentTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = smallerNumbersThanCurrent(input)
            assertArrayEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Counting frequencies:**
     *    Iterating through nums takes **O(n)** where `n` is the length of the array.
     * 2. **Creating prefix sum:**
     *    Building the prefix sum for the frequency array takes **O(101)** (constant).
     * 3. **Building the result:**
     *    Traversing nums to create the result array takes **O(n)**.
     * 4. **Overall Complexity:**
     *    **O(n)**, as `101` is a constant and does not depend on the size of nums.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** (excluding the output) because the frequency array is of fixed size 101.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
