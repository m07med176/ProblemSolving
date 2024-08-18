package mohamed.arfa.problemsolving.problemSolving.medium

import junit.framework.TestCase.assertEquals
import mohamed.arfa.problemsolving.problemSolving.JavaProblemSolving
import org.junit.Assert
import org.junit.Before
import org.junit.Test

class ContainerWithMostWater {
    /**
     * # [11. Container With Most Water](https://leetcode.com/problems/container-with-most-water/description/)
     * ### Example 1:
     *
     * - **Input**: `height = [1,8,6,2,5,4,8,3,7]`
     * - **Output**: `49`
     * - **Explanation**: The vertical lines are represented by the array `[1,8,6,2,5,4,8,3,7]`. In this case, the maximum area of water (blue section) that the container can contain is `49`.
     *
     * ### Example 2:
     *
     * - **Input**: `height = [1,1]`
     * - **Output**: `1`
     *
     */
    private val testCases = mutableMapOf<IntArray,Int>()
    @Before
    fun start(){
        testCases[intArrayOf(1,8,6,2,5,4,8,3,7)] = 49
        testCases[intArrayOf(1,1)] = 1
    }

    /**
     * # Pseudo code
     * -
     */

    @Test
    fun maxAreaJavaTest(){
        testCases.forEach { key, value ->
           val result =  JavaProblemSolving.maxArea(key)
            assertEquals(value, result)
        }

    }

}