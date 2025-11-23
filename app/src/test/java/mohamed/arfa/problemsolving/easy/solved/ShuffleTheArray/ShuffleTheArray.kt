package mohamed.arfa.problemsolving.easy.solved.ShuffleTheArray

import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ShuffleTheArray {
    /**
     * # [1470. Shuffle the Array](https://leetcode.com/problems/shuffle-the-array/)
     * Given the array `nums` consisting of `2n` elements in the form `[x1,x2,...,xn,y1,y2,...,yn]`.
     * Return the array in the form `[x1,y1,x2,y2,...,xn,yn]`.
     *
     * ## Example 1:
     * - **Input:** nums = [2,5,1,3,4,7], n = 3
     * - **Output:** [2,3,5,4,1,7]
     * - **Explanation:** Since x1=2, x2=5, x3=1, y1=3, y2=4, y3=7 then the answer is [2,3,5,4,1,7].
     *
     * ## Example 2:
     * - **Input:** nums = [1,2,3,4,4,3,2,1], n = 4
     * - **Output:** [1,4,2,3,3,2,4,1]
     *
     * ## Example 3:
     * - **Input:** nums = [1,1,2,2], n = 2
     * - **Output:** [1,2,1,2]
     *
     * ## Constraints:
     * - 1 <= n <= 500
     * - nums.length == 2n
     * - 1 <= nums[i] <= 10^3
     */

    private val testCases = mutableListOf<Triple<IntArray, Int, IntArray>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(2, 5, 1, 3, 4, 7),
                3,
                intArrayOf(2, 3, 5, 4, 1, 7)
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1, 2, 3, 4, 4, 3, 2, 1),
                4,
                intArrayOf(1, 4, 2, 3, 3, 2, 4, 1)
            )
        )
        testCases.add(
            Triple(
                intArrayOf(1, 1, 2, 2),
                2,
                intArrayOf(1, 2, 1, 2)
            )
        )
    }

    @Test
    fun shuffleTests() {
        testCases.forEach { (nums, n, expectedResult) ->
            val actualResult = ShuffleTheArrayKotlin.shuffle(nums, n)
            Assert.assertEquals(expectedResult.size, actualResult.size)
        }
    }
}