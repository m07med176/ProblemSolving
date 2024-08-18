package mohamed.arfa.problemsolving.problemSolving.easy

import mohamed.arfa.problemsolving.problemSolving.CppProblemSolving
import mohamed.arfa.problemsolving.problemSolving.JavaProblemSolving
import mohamed.arfa.problemsolving.problemSolving.KotlinProblemSolving
import org.junit.Assert.*
import org.junit.Before

import org.junit.Test

class ValidAnagram {


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
     */

    private val testCases = mutableMapOf<Pair<String,String>,Boolean>()
    @Before
    fun start(){
        testCases["anagram" to "nagaram"] = true
        testCases["moioi" to "oimoi"] = true
        testCases["rat" to "car"] = false
    }

    /**
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
    @Test
    fun isAnagramKotlinAl1Test() {
        testCases.forEach { (key, value) ->
            val result = KotlinProblemSolving.isAnagramAl1(key.first, key.second)
            assertEquals(value,result)
        }
    }

    @Test
    fun isAnagramJavaAl1Test() {
        testCases.forEach { (key, value) ->
            val result = JavaProblemSolving.isAnagramAl1(key.first, key.second)
            assertEquals(value, result)
        }
    }

    @Test
    fun isAnagramCppAl1Test() {
        testCases.forEach { (key, value) ->
            val result = CppProblemSolving.isAnagramAl1(key.first, key.second)
            assertEquals(value, result)
        }
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
    @Test
    fun isAnagramKotlinAl2Test() {
        testCases.forEach { (key, value) ->
            val result = KotlinProblemSolving.isAnagramAl2(key.first, key.second)
            assertEquals(value, result)
        }
    }


}