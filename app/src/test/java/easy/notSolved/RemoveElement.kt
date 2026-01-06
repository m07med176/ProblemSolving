package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class RemoveElement {
    /**
     * # [27. Remove Element](https://leetcode.com/problems/remove-element/)
     * Given an integer array nums and an integer val, remove all occurrences of val in nums in-place.
     * The order of the elements may be changed. Then return the number of elements in nums which are not equal to val.
     *
     * ## Example 1:
     * - **Input:** nums = [3,2,2,3], val = 3
     * - **Output:** 2, nums = [2,2,_,_]
     * - **Explanation:** Your function should return k = 2, with the first two elements of nums being 2.
     * ## Example 2:
     * - **Input:** nums = [0,1,2,2,3,0,4,2], val = 2
     * - **Output:** 5, nums = [0,1,4,0,3,_,_,_]
     * - **Explanation:** Your function should return k = 5, with the first five elements of nums containing 0, 0, 1, 3, and 4.
     *
     * ## Constraints:
     * - 0 <= nums.length <= 100
     * - 0 <= nums[i] <= 50
     * - 0 <= val <= 100
     */

    private val testCases = mutableListOf<Pair<Pair<IntArray, Int>, Pair<Int, IntArray>>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                Pair(intArrayOf(3, 2, 2, 3), 3),
                Pair(2, intArrayOf(2, 2)) // Expected: k = 2, nums = [2, 2]
            )
        )
        testCases.add(
            Pair(
                Pair(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2),
                Pair(5, intArrayOf(0, 1, 3, 0, 4)) // Expected: k = 5, nums = [0, 1, 3, 0, 4]
            )
        )
        testCases.add(
            Pair(
                Pair(intArrayOf(), 1),
                Pair(0, intArrayOf()) // Expected: k = 0, nums = []
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function removeElement(nums, val):
     * 1. Initialize a pointer `k` to track the position for non-val elements.
     * 2. Iterate through the array using a for loop:
     *    - If the current element `nums[i]` is not equal to `val`, assign `nums[k] = nums[i]` and increment `k`.
     * 3. After the loop, `k` represents the count of elements not equal to `val`.
     * 4. Return `k`.
     */
    private fun removeElement(nums: IntArray, `val`: Int): Int {
        var k = 0
        for (i in nums.indices) {
            if (nums[i] != `val`) {
                nums[k] = nums[i]
                k++
            }
        }
        return k
    }

    @Test
    fun removeElementTests() {
        testCases.forEach { (input, expectedResult) ->
            val (nums, `val`) = input
            val (expectedK, expectedNums) = expectedResult

            val actualK = removeElement(nums, `val`)
            assertEquals(expectedK, actualK)

            // Validate that the first k elements match the expectedNums
            assertArrayEquals(expectedNums, nums.take(actualK).toIntArray())
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Traversing the array:**
     *    The function iterates through the array once, making the complexity **O(n)** where `n` is the length of the array.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since the operation is performed in-place with no additional data structures.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
