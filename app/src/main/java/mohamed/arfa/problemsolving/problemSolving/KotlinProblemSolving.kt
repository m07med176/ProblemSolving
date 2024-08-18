package mohamed.arfa.problemsolving.problemSolving

object KotlinProblemSolving {

    fun isAnagramAl1(s: String, t: String): Boolean {
        var result = false
        s.forEach { item->
            result = t.contains(item)
        }
        return result
    }


    fun isAnagramAl2(s: String, t: String): Boolean {
        return s.toSortedSet() == t.toSortedSet()
    }

    fun isPalindrome(s: String): Boolean {

        return true
    }

    fun longestCommonPrefix(strs: Array<String>): String {

        return ""
    }

    fun kthDistinct(arr: Array<String>, k: Int): String {

        return ""
    }

    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {

    }

    fun removeDuplicates(nums: IntArray): Int {

        return 0
    }

    fun isValid(s: String): Boolean {
        val result = mutableListOf<String>()
        s.forEach {
            when(it){
                '('-> {
                    result.add("(")
                }
                '['-> {
                    result.add("[")
                }
                '{'-> {
                    result.add("{")
                }
                ')'-> {
                    if (result.contains("(")){
                        result.remove("(")
                    }
                }
                ']'-> {
                    if (result.contains("[")){
                        result.remove("[")
                    }
                }
                '}'-> {
                    if (result.contains("{")){
                        result.remove("{")
                    }
                }
            }
        }
        return result.isEmpty()
    }

    fun lengthOfLastWordA1(s: String): Int = s.trim()
        .split(" ")
        .last()
        .trim()
        .length

    fun threeSum(nums: IntArray): List<List<Int>> {

        return emptyList()
    }

    fun twoSum(numbers: IntArray, target: Int): IntArray {

        return intArrayOf()
    }

    fun maxArea(height: IntArray): Int {
        return 0
    }
}
