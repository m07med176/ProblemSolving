package mohamed.arfa.problemsolving.problemSolving.easy

import mohamed.arfa.problemsolving.problemSolving.KotlinProblemSolving
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class MergeSortedArray {
    /**
     * # [88. Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/?envType=study-plan-v2&envId=top-interview-150)
     * Given a string `s` containing just the characters `'('`, `')'`, `'{'`, `'}'`, `'['` and `']'`, determine if the input string is valid.
     *
     * ### A string is valid if:
     * - Open brackets must be closed by the same type of brackets.
     * - Open brackets must be closed in the correct order.
     * - Every close bracket has a corresponding open bracket of the same type.
     *
     * ### Example 1:
     * **Input**: `s = "()"`
     * **Output**: `true`
     *
     * ### Example 2:
     * **Input**: `s = "()[]{}"`
     * **Output**: `true`
     *
     * ### Example 3:
     * **Input**: `s = "(]"`
     * **Output**: `false`
     *
     * ### Constraints:
     * - `1 <= s.length <= 10^4`
     * - `s` consists of parentheses only: `'()[]{}'`.
     *
     */
    private val testCases = mutableMapOf<String,Boolean>()
    @Before
    fun start(){
        testCases["()"] = true
        testCases["()[]{}"] = true
        testCases["(]"] = false
        testCases["([)]"] = false
    }

    /**
     * ## Pseudo Code
     * - assign set list of ()
     * - assign set list of []
     * - assign set list of {}
     * - loop in string
     * - when start ( add
     * - when start ) search on item have (
     * - if have ( add )
     * - if not have ( don`t add )
     * - do this in every {,(,[
     * - search in set haven`t close brackets
     * - return result of search
     */

    @Test
    fun isValidKotlinA1(){
        testCases.forEach { (key, expect) ->
            val actual = KotlinProblemSolving.isValid(key)
            Assert.assertEquals(actual,expect)
        }
    }
}