package mohamed.arfa.problemsolving.problemSolving.easy

import org.junit.Before

class ValidParentheses {
    /**
     * # [20. Valid Parentheses](https://leetcode.com/problems/valid-parentheses/description/)
     */
    private val testCases = mutableMapOf<Pair<String,String>,Boolean>()
    @Before
    fun start(){
        testCases["anagram" to "nagaram"] = true
        testCases["moioi" to "oimoi"] = true
        testCases["rat" to "car"] = false
    }

}