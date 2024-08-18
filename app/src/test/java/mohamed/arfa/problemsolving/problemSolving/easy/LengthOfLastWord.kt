package mohamed.arfa.problemsolving.problemSolving.easy

import mohamed.arfa.problemsolving.problemSolving.JavaProblemSolving
import mohamed.arfa.problemsolving.problemSolving.KotlinProblemSolving
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class LengthOfLastWord {
    /**
     * # [58. Length of Last Word](https://leetcode.com/problems/length-of-last-word/description/?envType=study-plan-v2&envId=top-interview-150)
     */
    private val testCases = mutableMapOf<String,Int>()
    @Before
    fun start(){
        testCases["Hello World"] = 5
        testCases["   fly me   to   the moon  "] = 4
        testCases["   fly me   to   the moon  "] = 4
        testCases["luffy is still joyboy"] = 6
    }

    /**
     * ## Pseudo Code
     * - trim wight space of start and end of sentence
     * - split according to wight space
     * - take last word
     * - trim wight space of start and end of word
     * - return length of word
     * #
     * ## Complexity
     * - **Time complexity:** `O(n)`
     * - **Space complexity:** `O(n)`
     */
    @Test
    fun lengthOfLastWordKotlinA1Test(){
        testCases.forEach{ (key, value) ->
            val result = KotlinProblemSolving.lengthOfLastWordA1(key)
            Assert.assertEquals(result,value)
        }
    }

    @Test
    fun lengthOfLastWordJavaA1Test(){
        testCases.forEach{ (key, value) ->
            val result = JavaProblemSolving.lengthOfLastWordA1(key)
            Assert.assertEquals(result,value)
        }
    }


}