package mohamed.arfa.problemsolving.easy.solved.ConcatenationOfArray

object ConcatenationOfArrayKotlin {
    /**
     * # Pseudo code
     * ## (V1) Function getConcatenationV1(nums):
     * 1. create new array o(1)
     * 2. loop in nums array o(n)
     * 3. add element in array o(1)
     * 4. loop in nums array again o(n)
     * 5. add element in array again o(1)
     *  ### Summary:
     *  - **Time Complexity:** **O(n)**
     *  - **Space Complexity:** **O(n)**
     * */
    fun getConcatenationV1(nums: IntArray): IntArray {
        val ans = IntArray(nums.size*2)
        nums.forEachIndexed { index,element ->
            ans[index] = element
        }
        nums.forEachIndexed { index,element ->
            ans[nums.size+index] = element
        }
        return ans
    }

    /**
     * # Pseudo code
     * ## (V2) Function getConcatenationV2(nums):
     * 1. create new array o(1)
     * 2. loop in nums array o(n)
     * 3. add element in array at index o(1)
     * 4. add element in array at size of nums + index o(1)
     *  ### Summary:
     *  - **Time Complexity:** **O(n)**
     *  - **Space Complexity:** **O(n)**
     * */
    fun getConcatenationV2(nums: IntArray): IntArray {
        val ans = IntArray(nums.size*2)
        nums.forEachIndexed { index,element ->
            ans[index] = element
            ans[nums.size+index] = element
        }
        return ans
    }
}