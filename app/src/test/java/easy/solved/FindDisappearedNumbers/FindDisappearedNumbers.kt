package easy.solved.FindDisappearedNumbers

import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalysisExtension
import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalyzer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ComplexityAnalysisExtension::class)
class FindDisappearedNumbers {
    /**
     * # [Find All Numbers Disappeared in an Array](https://leetcode.com/problems/find-all-numbers-disappeared-in-an-array/)
     * Given an array `nums` of `n` integers where `nums[i]` is in the range `[1, n]`,
     * return an array of all the integers in the range `[1, n]` that do not appear in `nums`.
     *
     * ## Example 1
     * ```kotlin
     * val nums = intArrayOf(4, 3, 2, 7, 8, 2, 3, 1)
     * val result = findDisappearedNumbers(nums) // result = [5, 6]
     * ```
     *
     * ## Example 2
     * ```kotlin
     * val nums = intArrayOf(1, 1)
     * val result = findDisappearedNumbers(nums) // result = [2]
     * ```
     *
     * ## Constraints
     * - `n == nums.length`
     * - `1 <= n <= 10^5`
     * - `1 <= nums[i] <= n`
     *
     * @param nums the input integer array with values in range [1, n]
     * @return a list of integers that are missing from the array
     */

    private val testCases = listOf(
        intArrayOf(4, 3, 2, 7, 8, 2, 3, 1) to listOf(5, 6),
        intArrayOf(1, 1) to listOf(2),
        intArrayOf(1, 2, 3, 4, 5) to listOf(),
        intArrayOf(2, 2, 2, 2, 2) to listOf(1, 3, 4, 5),
        intArrayOf(1) to listOf(),
        intArrayOf(5, 4, 3, 2, 1) to listOf(),
        intArrayOf(1, 3, 5, 7, 9, 2, 4, 6, 8, 10) to listOf(),
        intArrayOf(10, 9, 8, 7, 6, 5, 4, 3, 2, 1) to listOf(),
        intArrayOf(1, 1, 1, 1) to listOf(2, 3, 4)
    )

    @TestFactory
    fun testAllSolutions() = listOf(
        FindDisappearedNumbersKotlin.solution0 to "Solution 0: My Solution",
        FindDisappearedNumbersKotlin.solution1 to "Solution 1: Using Boolean Array",
        FindDisappearedNumbersKotlin.solution2 to "Solution 2: Using HashSet"
    ).flatMap { (solution, name) ->
        testCases.mapIndexed { index, item ->
            DynamicTest.dynamicTest("$name: Test Case ${index + 1}") {
                val (result, time) = ComplexityAnalyzer().analyzeComplexity(
                    methodName = name,
                    inputSize = item.first.size
                ) {
                    solution.findDisappearedNumbers(item.first)
                }
                assertEquals(
                    item.second,
                    result,
                    "Expected ${item.second} but got $result for input ${item.first.contentToString()}"
                )
            }
        }
    }

    interface Solution {
        fun findDisappearedNumbers(nums: IntArray): List<Int>
    }
}