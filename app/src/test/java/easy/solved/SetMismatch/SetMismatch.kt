package easy.solved.SetMismatch

import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalysisExtension
import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalyzer
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.Assertions.*

@ExtendWith(ComplexityAnalysisExtension::class)
class SetMismatch {
    /**
     * # [Set Mismatch](https://leetcode.com/problems/set-mismatch/)
     * You have a set of integers `s`, which originally contains all the numbers from `1` to `n`. 
     * Unfortunately, due to some error, one of the numbers in `s` got duplicated to another number 
     * in the set, which results in repetition of one number and loss of another number.
     *
     * You are given an integer array `nums` representing the data status of this set after the error.
     * Find the number that occurs twice and the number that is missing and return them in the form of an array.
     *
     * ## Example 1
     * ```kotlin
     * val nums = intArrayOf(1, 2, 2, 4)
     * val result = findErrorNums(nums) // result = [2, 3]
     * ```
     * **Explanation:** The number 2 occurs twice and the number 3 is missing.
     *
     * ## Example 2
     * ```kotlin
     * val nums = intArrayOf(1, 1)
     * val result = findErrorNums(nums) // result = [1, 2]
     * ```
     * **Explanation:** The number 1 occurs twice and the number 2 is missing.
     *
     * ## Constraints
     * - `2 <= nums.length <= 10^4`
     * - `1 <= nums[i] <= 10^4`
     *
     * @param nums the integer array representing the set after error
     * @return an array containing [duplicate, missing]
     */

    private val testCases = listOf(
        intArrayOf(1, 2, 2, 4) to intArrayOf(2, 3),
        intArrayOf(1, 1) to intArrayOf(1, 2),
        intArrayOf(3, 2, 2) to intArrayOf(2, 1),
        intArrayOf(2, 2) to intArrayOf(2, 1),
        intArrayOf(3, 2, 3, 4, 6, 5) to intArrayOf(3, 1),
        intArrayOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 10) to intArrayOf(10, 11),
        intArrayOf(2, 3, 2) to intArrayOf(2, 1)
    )

    @TestFactory
    fun testAllSolutions() = listOf(
        SetMismatchKotlin.solution0 to "Solution 0: My Solution",
//        SetMismatchKotlin.solution1 to "Solution 1: Using HashSet",
//        SetMismatchKotlin.solution2 to "Solution 2: Using Frequency Array",
//        SetMismatchKotlin.solution3 to "Solution 3: Using Math (Sum Formula)",
//        SetMismatchKotlin.solution4 to "Solution 4: Using Negation Marking"
    ).flatMap { (solution, name) ->
        testCases.mapIndexed { index, item ->
            DynamicTest.dynamicTest("$name: Test Case ${index + 1}") {
                val (result, time) = ComplexityAnalyzer().analyzeComplexity(
                    methodName = name,
                    inputSize = item.first.size
                ) {
                    solution.findErrorNums(item.first)
                }
                assertArrayEquals(
                    item.second, 
                    result, 
                    "Expected ${item.second.contentToString()} but got ${result.contentToString()} for input ${item.first.contentToString()}"
                )
            }
        }
    }

    interface Solution {
        fun findErrorNums(nums: IntArray): IntArray
    }
}

