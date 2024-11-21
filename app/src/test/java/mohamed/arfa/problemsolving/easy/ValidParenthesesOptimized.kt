package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ValidParenthesesOptimized {
    /**
     * # [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
     * Given a string `s` containing just the characters `'(', ')', '{', '}', '[' and ']'`,
     * determine if the input string is valid.
     *
     * ## Example 1:
     * - **Input:** s = "()"
     * - **Output:** true
     *
     * ## Example 2:
     * - **Input:** s = "()[]{}"
     * - **Output:** true
     *
     * ## Example 3:
     * - **Input:** s = "(]"
     * - **Output:** false
     *
     * ## Constraints:
     * - 1 <= s.length <= 10^4
     * - `s` consists of parentheses only `'()[]{}'`.
     */

    private val testCases = mutableListOf<Pair<String, Boolean>>()

    @Before
    fun setup() {
        testCases.add(Pair("()", true))
        testCases.add(Pair("()[]{}", true))
        testCases.add(Pair("(]", false))
        testCases.add(Pair("([])", true))
        testCases.add(Pair("{[()]}", true))
        testCases.add(Pair("{[()]}[", false))
    }

    /**
     * # Optimized function to check if parentheses are valid
     */
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()
        val matchingPairs = mapOf(')' to '(', '}' to '{', ']' to '[')

        for (char in s) {
            if (char in matchingPairs.values) {
                stack.add(char)
            } else if (stack.isNotEmpty() && stack.last() == matchingPairs[char]) {
                stack.removeAt(stack.size - 1)
            } else {
                return false
            }
        }

        return stack.isEmpty()
    }

    @Test
    fun isValidTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = isValid(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the string:**
     *    - This takes **O(n)**, where `n` is the length of the string.
     *
     * 2. **Stack operations:**
     *    - Each push or pop operation takes **O(1)**.
     *    - In the worst case, every character is pushed and popped once.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for the stack in the worst case (when all characters are open brackets).
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
