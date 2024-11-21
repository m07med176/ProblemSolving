package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

///////////////////
class PrimeNumberSetBits {
    /**
     * # [762. Prime Number of Set Bits in Binary Representation](https://leetcode.com/problems/prime-number-of-set-bits-in-binary-representation/)
     * Given two integers `left` and `right`, return the count of numbers in the inclusive range `[left, right]` having a prime number of set bits in their binary representation.
     *
     * ## Example 1:
     * - **Input:** left = 6, right = 10
     * - **Output:** 4
     * - **Explanation:**
     *     - 6  -> 110 (2 set bits, 2 is prime)
     *     - 7  -> 111 (3 set bits, 3 is prime)
     *     - 8  -> 1000 (1 set bit, 1 is not prime)
     *     - 9  -> 1001 (2 set bits, 2 is prime)
     *     - 10 -> 1010 (2 set bits, 2 is prime)
     * ## Example 2:
     * - **Input:** left = 10, right = 15
     * - **Output:** 5
     * - **Explanation:**
     *     - 10 -> 1010 (2 set bits, 2 is prime)
     *     - 11 -> 1011 (3 set bits, 3 is prime)
     *     - 12 -> 1100 (2 set bits, 2 is prime)
     *     - 13 -> 1101 (3 set bits, 3 is prime)
     *     - 14 -> 1110 (3 set bits, 3 is prime)
     *     - 15 -> 1111 (4 set bits, 4 is not prime)
     *
     * ## Constraints:
     * - 1 <= left <= right <= 10^6
     * - 0 <= right - left <= 10^4
     */

    private val testCases = listOf(
        Triple(6, 10, 4),
        Triple(10, 15, 5)
    )

    /**
     * # Pseudo code
     * ## Function countPrimeSetBits(left, right):
     * 1. Define a set of small prime numbers.
     * 2. Initialize a counter `count` to 0.
     * 3. For each number `num` in the range [left, right]:
     *    - Count the number of set bits in `num` using `Integer.bitCount()`.
     *    - Check if the count is in the set of primes.
     *    - Increment `count` if the count is prime.
     * 4. Return the count.
     */
    private fun countPrimeSetBits(left: Int, right: Int): Int {
        val primeSet = setOf(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31)
        var count = 0
        for (num in left..right) {
            if (Integer.bitCount(num) in primeSet) {
                count++
            }
        }
        return count
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Iterating over the range [left, right]:**
     *    The function iterates through each number from `left` to `right`, so the complexity is **O(right - left)**.
     *
     * 2. **Counting set bits:**
     *    Counting set bits using `Integer.bitCount()` is a constant-time operation relative to a 32-bit integer: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(right - left)` where `right - left` is at most 10^4.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since only a constant amount of extra space is used (set of prime numbers and a counter).
     *
     * ### Summary:
     * - **Time Complexity:** **O(right - left)**
     * - **Space Complexity:** **O(1)**
     */
    @Test
    fun countPrimeSetBitsTests() {
        testCases.forEach { (left, right, expectedResult) ->
            val actualResult = countPrimeSetBits(left, right)
            assertEquals(expectedResult, actualResult)
        }
    }
}
