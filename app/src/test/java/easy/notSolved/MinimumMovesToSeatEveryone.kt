package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class MinimumMovesToSeatEveryone {
    /**
     * # [2037. Minimum Number of Moves to Seat Everyone](https://leetcode.com/problems/minimum-number-of-moves-to-seat-everyone/)
     * There are n available seats and n students standing in a room. You are given an array seats of length n,
     * where seats[i] is the position of the ith seat, and an array students of length n, where students[j] is the
     * position of the jth student. Return the minimum number of moves required to move each student to a seat.
     *
     * ## Example 1:
     * - **Input:** seats = [3,1,5], students = [2,7,4]
     * - **Output:** 4
     * - **Explanation:**
     *    - Move student at 2 -> 1 using 1 move.
     *    - Move student at 7 -> 5 using 2 moves.
     *    - Move student at 4 -> 3 using 1 move.
     *    - Total moves = 1 + 2 + 1 = 4.
     *
     * ## Example 2:
     * - **Input:** seats = [4,1,5,9], students = [1,3,2,6]
     * - **Output:** 7
     *
     * ## Example 3:
     * - **Input:** seats = [2,2,6,6], students = [1,3,2,6]
     * - **Output:** 4
     *
     * ## Constraints:
     * - n == seats.length == students.length
     * - 1 <= n <= 100
     * - 1 <= seats[i], students[j] <= 100
     */

    private val testCases = mutableListOf<Triple<IntArray, IntArray, Int>>()

    @Before
    fun setup() {
        testCases.add(
            Triple(
                intArrayOf(3, 1, 5),
                intArrayOf(2, 7, 4),
                4 // Expected: 4 moves
            )
        )
        testCases.add(
            Triple(
                intArrayOf(4, 1, 5, 9),
                intArrayOf(1, 3, 2, 6),
                7 // Expected: 7 moves
            )
        )
        testCases.add(
            Triple(
                intArrayOf(2, 2, 6, 6),
                intArrayOf(1, 3, 2, 6),
                4 // Expected: 4 moves
            )
        )
    }

    /**
     * # Pseudo code
     * ## Function minMovesToSeat(seats, students):
     * 1. Sort both the `seats` and `students` arrays.
     * 2. Initialize a variable `totalMoves` to 0.
     * 3. Iterate through the arrays:
     *    - For each index `i`, calculate `abs(seats[i] - students[i])` and add it to `totalMoves`.
     * 4. Return `totalMoves`.
     */
    private fun minMovesToSeat(seats: IntArray, students: IntArray): Int {
        seats.sort()
        students.sort()

        var totalMoves = 0
        for (i in seats.indices) {
            totalMoves += kotlin.math.abs(seats[i] - students[i])
        }

        return totalMoves
    }

    @Test
    fun minMovesToSeatTests() {
        testCases.forEach { (seats, students, expectedResult) ->
            val actualResult = minMovesToSeat(seats, students)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Sorting:**
     *    Sorting the `seats` and `students` arrays takes **O(n log n)** each, where `n` is the size of the arrays.
     * 2. **Iterating through the arrays:**
     *    Iterating through the arrays to calculate the moves takes **O(n)**.
     * 3. **Overall Complexity:**
     *    The total complexity is **O(n log n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(1)** as the sorting is done in place, and no additional data structures are used.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n log n)**
     * - **Space Complexity:** **O(1)**
     */
}
