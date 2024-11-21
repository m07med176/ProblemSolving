package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class FinalValueOfVariable {
    /**
     * # [2011. Final Value of Variable After Performing Operations](https://leetcode.com/problems/final-value-of-variable-after-performing-operations/)
     * Given an array of strings `operations` containing a list of operations, return the final value of `X` after performing all the operations.
     *
     * ## Example 1:
     * - **Input:** operations = ["--X","X++","X++"]
     * - **Output:** 1
     *
     * ## Example 2:
     * - **Input:** operations = ["++X","++X","X++"]
     * - **Output:** 3
     *
     * ## Example 3:
     * - **Input:** operations = ["X++","++X","--X","X--"]
     * - **Output:** 0
     *
     * ## Constraints:
     * - 1 <= operations.length <= 100
     * - `operations[i]` will be either "++X", "X++", "--X", or "X--".
     */

    private val testCases = mutableListOf<Pair<Array<String>, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                arrayOf("--X", "X++", "X++"),
                1 // Expected result
            )
        )
        testCases.add(
            Pair(
                arrayOf("++X", "++X", "X++"),
                3 // Expected result
            )
        )
        testCases.add(
            Pair(
                arrayOf("X++", "++X", "--X", "X--"),
                0 // Expected result
            )
        )
    }

    /**
     * # Function to calculate the final value of the variable
     */
    fun finalValueAfterOperations(operations: Array<String>): Int {
        var x = 0
        for (operation in operations) {
            if (operation.contains("+")) {
                x++
            } else if (operation.contains("-")) {
                x--
            }
        }
        return x
    }

    @Test
    fun finalValueAfterOperationsTests() {
        testCases.forEach { (operations, expectedResult) ->
            val actualResult = finalValueAfterOperations(operations)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    - Iterating over `operations` takes **O(n)**, where `n` is the size of the array.
     *
     * 2. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** since no additional space is used apart from the `x` variable.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */
}
