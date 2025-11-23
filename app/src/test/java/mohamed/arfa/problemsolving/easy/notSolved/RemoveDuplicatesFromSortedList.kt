package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

/////////////////////
class RemoveDuplicatesFromSortedList {
    /**
     * # [83. Remove Duplicates from Sorted List](https://leetcode.com/problems/remove-duplicates-from-sorted-list/)
     * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
     * Return the linked list sorted as well.
     *
     * ## Example 1:
     * - **Input:** head = [1,1,2]
     * - **Output:** [1,2]
     * ## Example 2:
     * - **Input:** head = [1,1,2,3,3]
     * - **Output:** [1,2,3]
     *
     * ## Constraints:
     * - The number of nodes in the list is in the range [0, 300].
     * - -100 <= Node.val <= 100
     * - The list is guaranteed to be sorted in ascending order.
     */

    private val testCases = mutableMapOf<ListNode?, ListNode?>()

    @Before
    fun setup() {
        val head1 = ListNode(1, ListNode(1, ListNode(2)))
        val expected1 = ListNode(1, ListNode(2))
        testCases[head1] = expected1

        val head2 = ListNode(1, ListNode(1, ListNode(2, ListNode(3, ListNode(3)))))
        val expected2 = ListNode(1, ListNode(2, ListNode(3)))
        testCases[head2] = expected2

        val head3: ListNode? = null
        val expected3: ListNode? = null
        testCases[head3] = expected3
    }

    /**
     * # Pseudo code
     * ## Function deleteDuplicates(head):
     * 1. If the list is empty, return `null`.
     * 2. Start with the head node and traverse the list.
     * 3. If the current node's value equals the next node's value:
     *    - Skip the next node by adjusting the current node's `next` pointer.
     * 4. Move to the next node.
     * 5. Return the head node.
     */
    private fun deleteDuplicates(head: ListNode?): ListNode? {
        var current = head

        while (current?.next != null) {
            if (current.value == current.next?.value) {
                current.next = current.next?.next
            } else {
                current = current.next
            }
        }

        return head
    }

    @Test
    fun deleteDuplicatesTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = deleteDuplicates(input)
            val result = actualResult?.equal(expectedResult)
            assertEquals(result, true)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Traversing the list:**
     *    The function iterates through the linked list once, making the complexity **O(n)** where `n` is the number of nodes.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since no additional data structures are used.
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
