package easy.solved.SmallerNumbersThanCurrent

import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalysisExtension
import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalyzer
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ComplexityAnalysisExtension::class)
class SmallerNumbersThanCurrent {
    /**
     * # [How Many Numbers Are Smaller Than the Current Number](https://leetcode.com/problems/how-many-numbers-are-smaller-than-the-current-number/)
     * Given the array `nums`, for each `nums[i]` find out how many numbers in the array are smaller than it.
     * That is, for each `nums[i]` you have to count the number of valid `j's` such that `j != i` and `nums[j] < nums[i]`.
     *
     * Return the answer in an array.
     *
     * ## Example 1
     * ```kotlin
     * val nums = intArrayOf(8, 1, 2, 2, 3)
     * val result = smallerNumbersThanCurrent(nums) // result = [4, 0, 1, 1, 3]
     * ```
     * **Explanation:**
     * - For nums[0]=8 there exist four smaller numbers than it (1, 2, 2 and 3).
     * - For nums[1]=1 does not exist any smaller number than it.
     * - For nums[2]=2 there exist one smaller number than it (1).
     * - For nums[3]=2 there exist one smaller number than it (1).
     * - For nums[4]=3 there exist three smaller numbers than it (1, 2 and 2).
     *
     * ## Example 2
     * ```kotlin
     * val nums = intArrayOf(6, 5, 4, 8)
     * val result = smallerNumbersThanCurrent(nums) // result = [2, 1, 0, 3]
     * ```
     *
     * ## Example 3
     * ```kotlin
     * val nums = intArrayOf(7, 7, 7, 7)
     * val result = smallerNumbersThanCurrent(nums) // result = [0, 0, 0, 0]
     * ```
     *
     * ## Constraints
     * - `2 <= nums.length <= 500`
     * - `0 <= nums[i] <= 100`
     *
     * @param nums the input integer array
     * @return an array where each element is the count of smaller numbers
     */

    private val testCases = listOf(
        intArrayOf(8, 1, 2, 2, 3) to intArrayOf(4, 0, 1, 1, 3),
        intArrayOf(6, 5, 4, 8) to intArrayOf(2, 1, 0, 3),
        intArrayOf(7, 7, 7, 7) to intArrayOf(0, 0, 0, 0),
        intArrayOf(0, 0) to intArrayOf(0, 0),
        intArrayOf(5, 0, 10, 0, 10, 6) to intArrayOf(2, 0, 4, 0, 4, 3),
        intArrayOf(1, 2, 3, 4, 5) to intArrayOf(0, 1, 2, 3, 4),
        intArrayOf(5, 4, 3, 2, 1) to intArrayOf(4, 3, 2, 1, 0),
        intArrayOf(100, 0, 50) to intArrayOf(2, 0, 1)
    )

    @TestFactory
    fun testAllSolutions() = listOf(
        SmallerNumbersThanCurrentKotlin.solution0 to "Solution 0: Two Loops for n Kotlin",
        SmallerNumbersThanCurrentJava.solution0 to  "Solution 0: Two Loops for n Java"
    ).flatMap { (solution, name) ->
        testCases.mapIndexed { index, item ->
            DynamicTest.dynamicTest("$name: Test Case ${index + 1}") {
                val (result, time) = ComplexityAnalyzer().analyzeComplexity(
                    methodName = name,
                    inputSize = item.first.size
                ) {
                    solution.smallerNumbersThanCurrent(item.first)
                }
                Assertions.assertArrayEquals(
                    item.second,
                    result,
                    "Expected ${item.second.contentToString()} but got ${result.contentToString()} for input ${item.first.contentToString()}"
                )
            }
        }
    }

    interface Solution {
        fun smallerNumbersThanCurrent(nums: IntArray): IntArray
    }
}