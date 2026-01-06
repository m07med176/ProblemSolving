package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ValidParentheses {
    /**
     * # [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
     * Given a string `s` containing just the characters `'(', ')', '{', '}', '[' and ']'`, determine if the input string is valid.
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
        testCases.add(Pair("([)]", false))
        testCases.add(Pair("{[]}", true))
    }

    /**
     * # Function to check if parentheses are valid
     */
    fun isValid(s: String): Boolean {
        val stack = mutableListOf<Char>()

        for (char in s) {
            when (char) {
                '(', '{', '[' -> stack.add(char)
                ')' -> if (stack.isNotEmpty() && stack.last() == '(') stack.removeAt(stack.size - 1) else return false
                '}' -> if (stack.isNotEmpty() && stack.last() == '{') stack.removeAt(stack.size - 1) else return false
                ']' -> if (stack.isNotEmpty() && stack.last() == '[') stack.removeAt(stack.size - 1) else return false
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
     *    - Pushing or popping from the stack takes **O(1)** each.
     *    - In the worst case, every character is pushed and popped once.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for the stack used to store open parentheses.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
