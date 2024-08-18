package mohamed.arfa.problemsolving.kotlin

import org.junit.Assert.*

import org.junit.Test

class ProblemSolvingTest {

    @Test
    fun isAnagramAl1Test() {
        var s = "anagram"
        var t = "nagaram"
        var expected =  true

        var result = ProblemSolving().isAnagramAl1(s,t)
        assertEquals(expected,result)

        s = "rat"
        t = "car"
        expected = false
        result = ProblemSolving().isAnagramAl1(s,t)
        assertEquals(expected,result)

    }

    @Test
    fun isAnagramAl2Test() {
        var s = "anagram"
        var t = "nagaram"
        var expected =  true

        var result = ProblemSolving().isAnagramAl2(s,t)
        assertEquals(expected,result)

        s = "rat"
        t = "car"
        expected = false
        result = ProblemSolving().isAnagramAl2(s,t)
        assertEquals(expected,result)
    }

    @Test
    fun isAnagramAl3Test() {
        var s = "anagram"
        var t = "nagaram"
        var expected =  true

        var result = ProblemSolving().isAnagramAl3(s,t)
        assertEquals(expected,result)

        s = "rat"
        t = "car"
        expected = false
        result = ProblemSolving().isAnagramAl3(s,t)
        assertEquals(expected,result)
    }


}