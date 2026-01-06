package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class GoalParserInterpretation {
    /**
     * # [1678. Goal Parser Interpretation](https://leetcode.com/problems/goal-parser-interpretation/)
     * Given the string `command`, return the Goal Parser's interpretation by replacing:
     * - `"G"` with `"G"`
     * - `"()"` with `"o"`
     * - `"(al)"` with `"al"`
     *
     * ## Example 1:
     * - **Input:** command = "G()(al)"
     * - **Output:** "Goal"
     *
     * ## Example 2:
     * - **Input:** command = "G()()()()(al)"
     * - **Output:** "Gooooal"
     *
     * ## Example 3:
     * - **Input:** command = "(al)G(al)()()G"
     * - **Output:** "alGalooG"
     *
     * ## Constraints:
     * - 1 <= command.length <= 100
     * - `command` consists of "G", "()", and/or "(al)" in some order.
     */

    private val testCases = mutableListOf<Pair<String, String>>()

    @Before
    fun setup() {
        testCases.add(
            Pair("G()(al)", "Goal") // Expected result
        )
        testCases.add(
            Pair("G()()()()(al)", "Gooooal") // Expected result
        )
        testCases.add(
            Pair("(al)G(al)()()G", "alGalooG") // Expected result
        )
    }

    /**
     * # Function to interpret the Goal Parser's command
     */
    fun interpret(command: String): String {
        return command.replace("()", "o").replace("(al)", "al")
    }

    @Test
    fun interpretTests() {
        testCases.forEach { (command, expectedResult) ->
            val actualResult = interpret(command)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Replacing substrings:**
     *    - Each `replace` operation processes the string once, so each operation takes **O(n)**, where `n` is the length of the string.
     *
     * 2. **Overall Complexity:**
     *    - The total complexity is **O(n)** as there are two replace operations.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** because a new string is created as a result of the replace operations.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
