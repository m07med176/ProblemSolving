package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ValidAnagram {
    /**
     * # [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/)
     * Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.
     *
     * ## Example 1:
     * - **Input:** s = "anagram", t = "nagaram"
     * - **Output:** true
     *
     * ## Example 2:
     * - **Input:** s = "rat", t = "car"
     * - **Output:** false
     *
     * ## Constraints:
     * - 1 <= s.length, t.length <= 5 * 10^4
     * - `s` and `t` consist of lowercase English letters.
     */

    private val testCases = mutableListOf<Triple<String, String, Boolean>>()

    @Before
    fun setup() {
        testCases.add(
            Triple("anagram", "nagaram", true) // Expected result
        )
        testCases.add(
            Triple("rat", "car", false) // Expected result
        )
        testCases.add(
            Triple("aabbcc", "ccbbaa", true) // Expected result
        )
        testCases.add(
            Triple("hello", "oellh", true) // Expected result
        )
        testCases.add(
            Triple("test", "tset", true) // Expected result
        )
    }

    /**
     * # Function to check if two strings are anagrams
     */
    fun isAnagram(s: String, t: String): Boolean {
        if (s.length != t.length) return false
        return s.toCharArray().sorted() == t.toCharArray().sorted()
    }

    @Test
    fun isAnagramTests() {
        testCases.forEach { (s, t, expectedResult) ->
            val actualResult = isAnagram(s, t)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting both strings:**
     *    - Sorting each string takes **O(n log n)**, where `n` is the length of the string.
     *
     * 2. **Comparison:**
     *    - Comparing two sorted arrays takes **O(n)**.
     *
     * 3. **Overall Complexity:**
     *    - The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)** for storing the sorted arrays.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(n)**
     */
}
