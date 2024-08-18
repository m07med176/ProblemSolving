package mohamed.arfa.problemsolving.kotlin

class ProblemSolving {

    /**
     * # [242. Valid Anagram](https://leetcode.com/problems/valid-anagram/description/)
     * Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.
     *
     * An **Anagram** is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.
     *
     * **Example 1:**
     *
     * - **Input:** `s = "anagram"`, `t = "nagaram"`
     * - **Output:** `true`
     *
     * **Example 2:**
     *
     * - **Input:** `s = "rat"`, `t = "car"`
     * - **Output:** `false`
     *
     * **Constraints:**
     * - `1 <= s.length, t.length <= 5 * 104`
     * - `s` and `t` consist of lowercase English letters.
     * #
     * # `isAnagramAl1()`
     * ### Pseudo code
     * - Creating boolean flag
     * - Looping on `s`
     * - each char in `s` search it in `t` items
     * - if true or false update boolean flag until finish looping
     * - finally return flag
     *
     * ### Complexity
     * - **Time complexity:** `O(2n)`
     * - **Space complexity:** `O(1)`
     */
    fun isAnagramAl1(s: String, t: String): Boolean {
        var result = false
        s.forEach { item->
            result = t.contains(item)
        }
        return result
    }

    /**
     * # `isAnagramAl2()`
     * ### pseudo code
     * - sort `s`
     * - sort `t`
     * - compare `s` with `t` if equal or not
     * ### Complexity
     * - **Time complexity:** `O(2n log n)`
     * - **Space complexity:** `O(2n)`
     */
    fun isAnagramAl2(s: String, t: String): Boolean {
        return s.toSortedSet() == t.toSortedSet()
    }

    fun isAnagramAl3(s: String, t: String): Boolean {
        var sCount = 0
        s.forEach {
            sCount+= it.code
        }

        var tCount = 0
        t.forEach {
            tCount+=it.code
        }
        return sCount == tCount
    }

    /**
     * # 125. Valid Palindrome
     * https://leetcode.com/problems/valid-palindrome/description/
     */
    fun isPalindrome(s: String): Boolean {

        return true
    }

    /**
     * # 14. Longest Common Prefix
     * https://leetcode.com/problems/longest-common-prefix/description/
     */
    fun longestCommonPrefix(strs: Array<String>): String {

        return ""
    }

    /**
     * # 2053. Kth Distinct String in an Array
     * https://leetcode.com/problems/kth-distinct-string-in-an-array/description/?envType=daily-question&envId=2024-08-05
     */
    fun kthDistinct(arr: Array<String>, k: Int): String {

        return ""
    }

    /**
     * # 88. Merge Sorted Array
     * https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150
     */
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    }


    /**
     * # 26. Remove Duplicates from Sorted Array
     * https://leetcode.com/problems/remove-duplicates-from-sorted-array/description/?envType=study-plan-v2&envId=top-interview-150
     */

    fun removeDuplicates(nums: IntArray): Int {

        return 0
    }

    /**
     * # 20. Valid Parentheses
     * https://leetcode.com/problems/valid-parentheses/description/
     */
    fun isValid(s: String): Boolean {

        return true
    }

    /**
     * # 58. Length of Last Word
     * https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150
     */
    fun lengthOfLastWord(s: String): Int {

        return 0
    }

    /**
     * # 15. 3Sum
     * https://leetcode.com/problems/3sum/description/
     */
    fun threeSum(nums: IntArray): List<List<Int>> {

        return emptyList()
    }

    /**
     * # 167. Two Sum II - Input Array Is Sorted
     * https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/description/
     */
    fun twoSum(numbers: IntArray, target: Int): IntArray {

        return intArrayOf()
    }
}
