package mohamed.arfa.problemsolving.easy.solved.MaxConsecutiveOnes


import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalysisExtension
import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalyzer
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions.*

@ExtendWith(ComplexityAnalysisExtension::class)
class MaxConsecutiveOnes {
    /**
     * # [Max Consecutive Ones](https://leetcode.com/problems/max-consecutive-ones/)
     * Given a binary array `nums`, returns the maximum number of consecutive 1's in the array.
     *
     * ## Example 1
     * ```kotlin
     * val nums = intArrayOf(1, 1, 0, 1, 1, 1)
     * val result = findMaxConsecutiveOnes(nums) // result = 3
     * ```
     * **Explanation:** The first two digits or the last three digits are consecutive 1s.
     * The maximum number of consecutive 1s is 3.
     *
     * ## Example 2
     * ```kotlin
     * val nums = intArrayOf(1, 0, 1, 1, 0, 1)
     * val result = findMaxConsecutiveOnes(nums) // result = 2
     * ```
     *
     * ## Constraints
     * - `1 <= nums.length <= 10^5`
     * - `nums[i]` is either 0 or 1
     *
     * @param nums the binary array of 0s and 1s
     * @return the maximum number of consecutive 1's in `nums`
     */

    private val testCases = listOf(
        intArrayOf(1, 1, 0, 1, 1, 1) to 3,
        intArrayOf(1, 0, 1, 1, 0, 1) to 2,
        intArrayOf(1, 1, 1, 1) to 4,
        intArrayOf(0, 0, 0) to 0,
        intArrayOf(1) to 1,
        intArrayOf(0) to 0,
        intArrayOf(1, 1, 0, 1, 1, 1, 0, 1, 1, 1, 1) to 4
    )

    @TestFactory
    fun testAllSolutions() = listOf(
        MaxConsecutiveOnesKotlin.solution1 to "Solution 1: Simple Iteration",
        MaxConsecutiveOnesKotlin.solution2 to "Solution 2: Split and map",
        MaxConsecutiveOnesKotlin.solution3 to "Solution 3: Using Fold",
    ).flatMap { (solution, name) ->
        testCases.mapIndexed { index, item ->
            DynamicTest.dynamicTest("$name: Test Case ${index + 1}") {
                val (result, time) = ComplexityAnalyzer().analyzeComplexity(
                    methodName = name,
                    inputSize = item.first.size
                ) {
                    solution.findMaxConsecutiveOnes(item.first)
                }
                assertEquals(item.second, result, "Expected ${item.second} but got $result for input ${item.first.contentToString()}")
            }
        }
    }

    interface Solution {
        fun findMaxConsecutiveOnes(nums: IntArray): Int
    }
}