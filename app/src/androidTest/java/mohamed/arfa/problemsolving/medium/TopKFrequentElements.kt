package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
import java.util.PriorityQueue

class TopKFrequentElements {
    /**
     * # [347. Top K Frequent Elements](https://leetcode.com/problems/top-k-frequent-elements/)
     * Given an integer array nums and an integer k, return the k most frequent elements.
     *
     * ## Example 1:
     * - **Input:** nums = [1,1,1,2,2,3], k = 2
     * - **Output:** [1,2]
     *
     * ## Example 2:
     * - **Input:** nums = [1], k = 1
     * - **Output:** [1]
     *
     * ## Constraints:
     * - 1 <= nums.length <= 10^5
     * - -10^4 <= nums[i] <= 10^4
     * - k is in the range [1, the number of unique elements in the array].
     * - It is guaranteed that the answer is unique.
     */

    private val testCases = mutableListOf<Triple<IntArray, Int, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(1, 1, 1, 2, 2, 3),
                2,
                intArrayOf(1, 2) // Expected: Top 2 frequent elements are 1 and 2
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1),
                1,
                intArrayOf(1) // Expected: Top 1 frequent element is 1
            )
        )
        testCases.add(
            Triple(
                intArrayOf(4, 4, 4, 3, 3, 2, 1),
                3,
                intArrayOf(4, 3, 2) // Expected: Top 3 frequent elements are 4, 3, and 2
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function topKFrequent(nums, k):
     * 1. Create a HashMap to store the frequency of each number.
     * 2. Populate the HashMap by iterating through the array and counting occurrences.
     * 3. Use a priority queue (min-heap) to keep track of the top k elements based on frequency.
     *    - Add each element-frequency pair to the heap.
     *    - If the heap size exceeds k, remove the smallest element.
     * 4. Extract the k most frequent elements from the heap and return them as an array.
     */
    private fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val frequencyMap = mutableMapOf<Int, Int>()

        // Count frequencies
        for (num in nums) {
            frequencyMap[num] = frequencyMap.getOrDefault(num, 0) + 1
        }

        // Use a priority queue (min-heap) to keep top k frequent elements
        val minHeap = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })

        for ((num, freq) in frequencyMap) {
            minHeap.add(num to freq)
            if (minHeap.size > k) {
                minHeap.poll()
            }
        }

        // Extract the elements from the heap
        return minHeap.map { it.first }.toIntArray()
    }

    @Test
    fun topKFrequentTests() {
        testCases.forEach { (nums, k, expectedResult) ->
            val actualResult = topKFrequent(nums, k).sorted()
            val expectedSorted = expectedResult.sorted()
            assertEquals(expectedSorted, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Counting frequencies:**
     *    Iterating through the array takes **O(n)** where `n` is the length of the array.
     * 2. **Building the heap:**
     *    Adding `m` unique elements to the heap takes **O(m log k)** where `m` is the number of unique elements, and `k` is the size of the heap.
     * 3. **Extracting k elements:**
     *    Extracting elements from the heap takes **O(k log k)**.
     * 4. **Overall Complexity:**
     *    **O(n + m log k)**, where `n` is the array length and `m` is the number of unique elements.
     *
     * ### Space Complexity:
     * The space complexity is **O(m + k)** due to the frequency map and the heap.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n + m log k)**
     * - **Space Complexity:** **O(m + k)**
     */
}
