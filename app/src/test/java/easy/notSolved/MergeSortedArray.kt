package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MergeSortedArray {
    /**
     * # [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
     * You are given two integer arrays nums1 and nums2, sorted in non-decreasing order, and two integers m and n.
     * Merge nums1 and nums2 into a single array sorted in non-decreasing order.
     *
     * ## Example 1:
     * - **Input:** nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * - **Output:** [1,2,2,3,5,6]
     *
     * ## Example 2:
     * - **Input:** nums1 = [1], m = 1, nums2 = [], n = 0
     * - **Output:** [1]
     *
     * ## Example 3:
     * - **Input:** nums1 = [0], m = 0, nums2 = [1], n = 1
     * - **Output:** [1]
     *
     * ## Constraints:
     * - nums1.length == m + n
     * - nums2.length == n
     * - 0 <= m, n <= 200
     * - 1 <= m + n <= 200
     * - -10^9 <= nums1[i], nums2[j] <= 10^9
     */

    private val testCases = mutableListOf<Triple<IntArray, Pair<Int, IntArray>, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(1, 2, 3, 0, 0, 0),
                Pair(3, intArrayOf(2, 5, 6)),
                intArrayOf(1, 2, 2, 3, 5, 6)
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1),
                Pair(1, intArrayOf()),
                intArrayOf(1)
            )
        )
        testCases.add(
            Triple(
                intArrayOf(0),
                Pair(0, intArrayOf(1)),
                intArrayOf(1)
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function merge(nums1, m, nums2, n):
     * 1. Start merging from the back of nums1 and nums2 to avoid overwriting existing values in nums1.
     * 2. Initialize three pointers:
     *    - `p1` at index `m - 1` (last valid element in nums1)
     *    - `p2` at index `n - 1` (last element in nums2)
     *    - `p` at index `m + n - 1` (last index of nums1).
     * 3. Compare elements pointed by `p1` and `p2`:
     *    - Place the larger element at index `p` and move the corresponding pointer backward.
     * 4. Continue until either nums2 is fully merged or nums1 is completely processed.
     * 5. If any elements remain in nums2, copy them into nums1.
     */
    private fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var p1 = m - 1
        var p2 = n - 1
        var p = m + n - 1

        while (p1 >= 0 && p2 >= 0) {
            if (nums1[p1] > nums2[p2]) {
                nums1[p] = nums1[p1]
                p1--
            } else {
                nums1[p] = nums2[p2]
                p2--
            }
            p--
        }

        // If there are remaining elements in nums2, copy them to nums1
        while (p2 >= 0) {
            nums1[p] = nums2[p2]
            p2--
            p--
        }
    }

    @Test
    fun mergeSortedArrayTests() {
        testCases.forEach { (nums1, params, expectedResult) ->
            val (m, nums2) = params
            merge(nums1, m, nums2, nums2.size)
            assertArrayEquals(expectedResult, nums1)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Merging elements:**
     *    The function iterates through both nums1 and nums2, making the complexity **O(m + n)** where `m` and `n` are the lengths of nums1 and nums2 respectively.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since no additional data structures are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(m + n)**
     * - **Space Complexity:** **O(1)**
     */
}
