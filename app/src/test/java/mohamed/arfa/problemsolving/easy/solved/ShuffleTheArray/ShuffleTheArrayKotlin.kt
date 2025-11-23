package mohamed.arfa.problemsolving.easy.solved.ShuffleTheArray

object ShuffleTheArrayKotlin {
    /**
     * # Pseudo Code
     * ## in shuffle function
     * - create new array length of `nums` o(1)
     * - define variable currentIndex = 0
     * - loop in `nums` o(n)
     * - add element of index
     * - update currentIndex + 1
     * - add element of currentIndex + `n`
     * - update currentIndex + 1
     * - update currentIndex each time +1
     * - when index of loop reach to n stop loop
     *
     * ### Summary
     * * space complexity o(n)
     * * time complexity o(n)
     */
    private fun shuffleV1(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(nums.size)
        var currentIndex = 0
        for (index in 0 until nums.size) {
            if (index == n) break
            ans[currentIndex] = nums[index]
            currentIndex++
            ans[currentIndex] = nums[index+n]
            currentIndex++
        }
        return ans
    }

    private fun shuffleV2(nums: IntArray, n: Int): IntArray {
        val ans = IntArray(nums.size)
        for (i in 0 until n) {
            ans[2 * i] = nums[i]
            ans[2 * i + 1] = nums[i + n]
        }
        return ans
    }

    fun shuffle(nums: IntArray, n: Int): IntArray {
        var list = mutableListOf<Int>()
        for (i in 0 until n) {
            list.add(nums[i])
            list.add(nums[i+n])
        }
        return list.toIntArray()
    }
}