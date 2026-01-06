package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ReverseLinkedListII {
    /**
     * # [92. Reverse Linked List II](https://leetcode.com/problems/reverse-linked-list-ii/)
     * Given the head of a singly linked list and two integers left and right where left <= right,
     * reverse the nodes of the list from position left to position right, and return the reversed list.
     *
     * ## Example 1:
     * - **Input:** head = [1,2,3,4,5], left = 2, right = 4
     * - **Output:** [1,4,3,2,5]
     * ## Example 2:
     * - **Input:** head = [5], left = 1, right = 1
     * - **Output:** [5]
     *
     * ## Constraints:
     * - The number of nodes in the list is n.
     * - 1 <= n <= 500
     * - -500 <= Node.val <= 500
     * - 1 <= left <= right <= n
     */

    private val testCases = mutableMapOf<Triple<ListNode?, Int, Int>, ListNode?>()

    @Before
    fun setup() {
        val head1 = ListNode(
            1, ListNode(
                2, ListNode(
                    3, ListNode(
                        4, ListNode(5)
                    )
                )
            )
        )
        val expected1 = ListNode(
            1, ListNode(
                4, ListNode(
                    3, ListNode(
                        2, ListNode(5)
                    )
                )
            )
        )
        testCases[Triple(head1, 2, 4)] = expected1

        val head2 = ListNode(5)
        val expected2 = ListNode(5)
        testCases[Triple(head2, 1, 1)] = expected2
    }

    /**
     * # Pseudo code
     * ## Function reverseBetween(head, left, right):
     * 1. Create a dummy node pointing to the head to handle edge cases.
     * 2. Move a pointer `prev` to the node right before `left`.
     * 3. Start the reversal between `left` and `right`.
     * 4. Adjust the links accordingly to reverse the sublist.
     * 5. Return the modified list.
     */
    private fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
        if (head == null || left == right) return head

        val dummy = ListNode(0)
        dummy.next = head
        var prev: ListNode? = dummy

        // Move `prev` to the node before `left`
        for (i in 1 until left) {
            prev = prev?.next
        }

        // Start reversing the sublist
        val start = prev?.next
        var then = start?.next

        for (i in 0 until (right - left)) {
            start?.next = then?.next
            then?.next = prev?.next
            prev?.next = then
            then = start?.next
        }

        return dummy.next
    }

    @Test
    fun reverseLinkedListIITests() {
        testCases.forEach { (input, expectedResult) ->
            val (head, left, right) = input
            val actualResult = reverseBetween(head, left, right)
            val result = actualResult?.equal(expectedResult)
            assertEquals(result, true)
        }
    }
    /**
     * ### Time Complexity:
     *
     * 1. **Initialization of pointers (dummy, prev, start, and then):**
     *    This is a constant-time operation: **O(1)**.
     *
     * 2. **Moving the `prev` pointer to the node before the `left` position:**
     *    This loop runs `left - 1` times, so the complexity is **O(left)**.
     *
     * 3. **Reversing the sublist between `left` and `right`:**
     *    This loop runs `(right - left)` times, which in the worst case is **O(n)** where `n` is the total number of nodes in the list.
     *
     * 4. **Reassignment of pointers during reversal:**
     *    Each reassignment within the loop is a constant-time operation: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(left) + O(right - left) ≈ O(n)`
     * This is because traversing the list and reversing a segment within it is linear with respect to the total number of nodes.
     *
     * ### Space Complexity:
     * The space complexity of this function is **O(1)** since it only uses a few pointers for manipulation and no additional data structures.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */

    fun ListNode.equal(other: ListNode?): Boolean {
        var current1: ListNode? = this
        var current2: ListNode? = other

        while (current1 != null && current2 != null) {
            if (current1.value != current2.value) {
                return false
            }
            current1 = current1.next
            current2 = current2.next
        }

        return current1 == null && current2 == null
    }

    class ListNode(var value: Int) {
        var next: ListNode? = null

        constructor(value: Int, next: ListNode?) : this(value) {
            this.next = next
        }
    }
}