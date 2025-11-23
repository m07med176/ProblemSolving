package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class FindWordsContainingCharacter {
    /**
     * # [2942. Find Words Containing Character](https://leetcode.com/problems/find-words-containing-character/)
     * Given a 0-indexed array of strings `words` and a character `x`, return an array of indices representing the words
     * that contain the character `x`. The returned array may be in any order.
     *
     * ## Example 1:
     * - **Input:** words = ["leet","code"], x = "e"
     * - **Output:** [0,1]
     *
     * ## Example 2:
     * - **Input:** words = ["abc","bcd","aaaa","cbc"], x = "a"
     * - **Output:** [0,2]
     *
     * ## Example 3:
     * - **Input:** words = ["abc","bcd","aaaa","cbc"], x = "z"
     * - **Output:** []
     *
     * ## Constraints:
     * - 1 <= words.length <= 50
     * - 1 <= words[i].length <= 50
     * - `x` is a lowercase English letter.
     * - `words[i]` consists only of lowercase English letters.
     */

    private val testCases = mutableListOf<Triple<Array<String>, Char, List<Int>>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                arrayOf("leet", "code"),
                'e',
                listOf(0, 1) // Expected result
            )
        )
        testCases.add(
            Triple(
                arrayOf("abc", "bcd", "aaaa", "cbc"),
                'a',
                listOf(0, 2) // Expected result
            )
        )
        testCases.add(
            Triple(
                arrayOf("abc", "bcd", "aaaa", "cbc"),
                'z',
                listOf() // Expected result
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function findWordsContaining(words, x):
     * 1. Initialize an empty list `result` to store indices.
     * 2. Iterate through the array `words` with index `i` and value `word`.
     *    - If `word` contains the character `x`, add `i` to `result`.
     * 3. Return the `result` list.
     */
    private fun findWordsContaining(words: Array<String>, x: Char): List<Int> {
        val result = mutableListOf<Int>()

        for ((index, word) in words.withIndex()) {
            if (x in word) {
                result.add(index)
            }
        }

        return result
    }

    @Test
    fun findWordsContainingTests() {
        testCases.forEach { (words, x, expectedResult) ->
            val actualResult = findWordsContaining(words, x)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating through the array:**
     *    - This operation takes **O(n)** where `n` is the size of the `words` array.
     *
     * 2. **Checking if a word contains `x`:**
     *    - For each word, checking if it contains `x` takes **O(m)**, where `m` is the average length of the words.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n * m)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(k)**, where `k` is the number of indices in the result.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n * m)**
     * - **Space Complexity:** **O(k)**
     */
}
