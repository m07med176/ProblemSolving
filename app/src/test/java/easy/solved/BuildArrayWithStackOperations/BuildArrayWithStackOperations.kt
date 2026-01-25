package easy.solved.BuildArrayWithStackOperations

import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalysisExtension
import mohamed.arfa.problemsolving.complextiyReports.ComplexityAnalyzer
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.DynamicTest
import org.junit.jupiter.api.TestFactory
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(ComplexityAnalysisExtension::class)
class BuildArrayWithStackOperations {
    /**
     * # [Build an Array With Stack Operations](https://leetcode.com/problems/build-an-array-with-stack-operations/)
     * You are given an integer array `target` and an integer `n`.
     * You have an empty stack with the two following operations:
     * - `"Push"`: pushes an integer to the top of the stack.
     * - `"Pop"`: removes the integer on the top of the stack.
     *
     * You also have a stream of the integers in the range `[1, n]`.
     * Use the two stack operations to make the numbers in the stack (from the bottom to the top) equal to `target`.
     *
     * You should follow the following rules:
     * - If the stream of the integers is not empty, pick the next integer from the stream and push it to the top of the stack.
     * - If the stack is not empty, pop the integer at the top of the stack.
     * - If, at any moment, the elements in the stack (from the bottom to the top) are equal to `target`,
     *   do not read new integers from the stream and do not do more operations on the stack.
     *
     * Return the stack operations needed to build `target` following the mentioned rules.
     * If there are multiple valid answers, return any of them.
     *
     * ## Example 1
     * ```kotlin
     * val target = intArrayOf(1, 3)
     * val n = 3
     * val result = buildArray(target, n) // result = ["Push","Push","Pop","Push"]
     * ```
     * **Explanation:**
     * - Initially the stack s is empty. The last element is the top of the stack.
     * - Read 1 from the stream and push it to the stack. s = [1].
     * - Read 2 from the stream and push it to the stack. s = [1,2].
     * - Pop the integer on the top of the stack. s = [1].
     * - Read 3 from the stream and push it to the stack. s = [1,3].
     *
     * ## Example 2
     * ```kotlin
     * val target = intArrayOf(1, 2, 3)
     * val n = 3
     * val result = buildArray(target, n) // result = ["Push","Push","Push"]
     * ```
     *
     * ## Example 3
     * ```kotlin
     * val target = intArrayOf(1, 2)
     * val n = 4
     * val result = buildArray(target, n) // result = ["Push","Push"]
     * ```
     * **Explanation:** We stop the stack operations since the stack equals target.
     *
     * ## Constraints
     * - `1 <= target.length <= 100`
     * - `1 <= n <= 100`
     * - `1 <= target[i] <= n`
     * - `target` is strictly increasing.
     *
     * @param target the target array to build using stack operations
     * @param n the range of integers in the stream [1, n]
     * @return a list of stack operations needed to build the target array
     */

    private val testCases = listOf(
        (intArrayOf(1, 3) to 3) to listOf("Push", "Push", "Pop", "Push"),
        (intArrayOf(1, 2, 3) to 3) to listOf("Push", "Push", "Push"),
        (intArrayOf(1, 2) to 4) to listOf("Push", "Push"),
        (intArrayOf(1) to 1) to listOf("Push"),
        (intArrayOf(2) to 2) to listOf("Push", "Pop", "Push"),
        (intArrayOf(1, 2, 3, 4, 5) to 5) to listOf("Push", "Push", "Push", "Push", "Push"),
        (intArrayOf(2, 3, 4) to 5) to listOf("Push", "Pop", "Push", "Push", "Push"),
        (intArrayOf(1, 5) to 5) to listOf("Push", "Push", "Pop", "Push", "Pop", "Push", "Pop", "Push"),
        (intArrayOf(1, 4, 5) to 5) to listOf("Push", "Push", "Pop", "Push", "Pop", "Push", "Push"),
        (intArrayOf(3, 5, 7) to 10) to listOf("Push", "Pop", "Push", "Pop", "Push", "Push", "Pop", "Push", "Pop", "Push"),
        (intArrayOf(1, 2, 5, 6) to 6) to listOf("Push", "Push", "Push", "Pop", "Push", "Pop", "Push", "Push")
    )

    @TestFactory
    fun testAllSolutions() = listOf(
        BuildArrayWithStackOperationsKotlin.solution0 to "Solution 0: My Solution",
//        BuildArrayStackKotlin.solution1 to "Solution 1: Simulation",
//        BuildArrayStackKotlin.solution2 to "Solution 2: Optimized with Pointer",
//        BuildArrayStackKotlin.solution3 to "Solution 3: Using Set for Lookup"
    ).flatMap { (solution, name) ->
        testCases.mapIndexed { index, item ->
            DynamicTest.dynamicTest("$name: Test Case ${index + 1}") {
                val (result, time) = ComplexityAnalyzer().analyzeComplexity(
                    methodName = name,
                    inputSize = item.first.first.size
                ) {
                    solution.buildArray(item.first.first, item.first.second)
                }
                assertEquals(
                    item.second,
                    result,
                    "Expected ${item.second} but got $result for input target=${item.first.first.contentToString()}, n=${item.first.second}"
                )
            }
        }
    }

    interface Solution {
        fun buildArray(target: IntArray, n: Int): List<String>
    }
}