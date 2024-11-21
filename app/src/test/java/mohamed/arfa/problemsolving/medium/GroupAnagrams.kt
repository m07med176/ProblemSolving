package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class GroupAnagrams {
    /**
     * # [49. Group Anagrams](https://leetcode.com/problems/group-anagrams/)
     * Given an array of strings strs, group the anagrams together.
     *
     * ## Example 1:
     * - **Input:** strs = ["eat","tea","tan","ate","nat","bat"]
     * - **Output:** [["bat"],["nat","tan"],["ate","eat","tea"]]
     * - **Explanation:** 
     *    - "bat" has no anagrams in the array.
     *    - "nat" and "tan" are anagrams.
     *    - "ate", "eat", and "tea" are anagrams.
     *
     * ## Example 2:
     * - **Input:** strs = [""]
     * - **Output:** [[""]]
     *
     * ## Example 3:
     * - **Input:** strs = ["a"]
     * - **Output:** [["a"]]
     *
     * ## Constraints:
     * - 1 <= strs.length <= 10^4
     * - 0 <= strs[i].length <= 100
     * - strs[i] consists of lowercase English letters.
     */

    private val testCases = mutableListOf<Pair<Array<String>, List<List<String>>>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                arrayOf("eat", "tea", "tan", "ate", "nat", "bat"),
                listOf(listOf("bat"), listOf("nat", "tan"), listOf("ate", "eat", "tea")) // Anagrams grouped
            )
        )
        testCases.add(
            Pair(
                arrayOf(""),
                listOf(listOf("")) // Single empty string
            )
        )
        testCases.add(
            Pair(
                arrayOf("a"),
                listOf(listOf("a")) // Single letter
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function groupAnagrams(strs):
     * 1. Create a HashMap where:
     *    - Key: The sorted version of each string.
     *    - Value: A list of strings that are anagrams of each other.
     * 2. Iterate through each string in the input array:
     *    - Sort the string and use it as the key in the HashMap.
     *    - Add the string to the corresponding list in the HashMap.
     * 3. Return all the values of the HashMap as the grouped anagrams.
     */
    private fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val map = mutableMapOf<String, MutableList<String>>()

        for (str in strs) {
            val sortedKey = str.toCharArray().sorted().joinToString("")
            map.computeIfAbsent(sortedKey) { mutableListOf() }.add(str)
        }

        return map.values.toList()
    }

    @Test
    fun groupAnagramsTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = groupAnagrams(input).map { it.sorted() }.sortedBy { it.firstOrNull() }
            val expectedSorted = expectedResult.map { it.sorted() }.sortedBy { it.firstOrNull() }
            assertEquals(expectedSorted, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting each string:**
     *    Each string is sorted, which takes O(k log k), where `k` is the average length of strings.
     * 2. **Iterating through the array:**
     *    Iterating through `n` strings in the array takes O(n).
     * 3. **Overall Complexity:**
     *    Sorting all strings results in O(n * k log k).
     *
     * ### Space Complexity:
     * The space complexity is **O(n * k)** due to the storage of strings and their keys in the HashMap.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n * k log k)**
     * - **Space Complexity:** **O(n * k)**
     */
}
