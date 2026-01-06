package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class ReverseLinkedList {
    /**
     * # [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
     * Given the head of a singly linked list, reverse the list, and return the reversed list.
     *
     * ## Example 1:
     * - **Input:** head = [1,2,3,4,5]
     * - **Output:** [5,4,3,2,1]
     * ## Example 2:
     * - **Input:** head = [1,2]
     * - **Output:** [2,1]
     * ## Example 3:
     * - **Input:** head = []
     * - **Output:** []
     *
     * ## Constraints:
     * - The number of nodes in the list is in the range [0, 5000].
     * - -5000 <= Node.val <= 5000
     */

    private val testCases = mutableMapOf<ListNode?, ListNode?>()

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
            5, ListNode(
                4, ListNode(
                    3, ListNode(
                        2, ListNode(1)
                    )
                )
            )
        )
        testCases[head1] = expected1

        val head2 = ListNode(1, ListNode(2))
        val expected2 = ListNode(2, ListNode(1))
        testCases[head2] = expected2

        val head3: ListNode? = null
        val expected3: ListNode? = null
        testCases[head3] = expected3
    }
    /**
     * # Pseudo code
     * ## Function reverseList(head):
     * 1. Initialize `prev` pointer to null and `current` pointer to head.
     * 2. While `current` is not null:
     *    - Save the next node (nextTemp).
     *    - Reverse the link by pointing `current.next` to `prev`.
     *    - Move `prev` to `current` and `current` to nextTemp.
     * 3. Return `prev` as the new head of the reversed list.
     */
    private fun reverseList(head: ListNode?): ListNode? {
        var prev: ListNode? = null
        var current = head

        while (current != null) {
            val nextTemp =current.next
            current.next = prev
            prev = current
            current = nextTemp
        }
        return prev
    }

    @Test
    fun reverseLinkedListTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = reverseList(input)
            val result = actualResult.equal(expectedResult)
            assertEquals(result, true)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Traversing the list:**
     *    We traverse the list once to reverse all nodes, which takes **O(n)** time where `n` is the number of nodes in the list.
     *
     * 2. **Reassigning pointers:**
     *    Each pointer reassignment is a constant-time operation: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(n)` where `n` is the number of nodes in the list.
     *
     * ### Space Complexity:
     * The space complexity of this function is **O(1)** since it only uses a few pointers for traversal and manipulation, regardless of the input size.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */

    private fun ListNode?.equal(other: ListNode?): Boolean {
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