package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

//////////////
class MiddleOfLinkedList {
    /**
     * # [876. Middle of the Linked List](https://leetcode.com/problems/middle-of-the-linked-list/)
     * Given the head of a singly linked list, return the middle node of the linked list.
     * If there are two middle nodes, return the second middle node.
     *
     * ## Example 1:
     * - **Input:** head = [1,2,3,4,5]
     * - **Output:** [3,4,5]
     * - **Explanation:** The middle node of the list is node 3.
     * ## Example 2:
     * - **Input:** head = [1,2,3,4,5,6]
     * - **Output:** [4,5,6]
     * - **Explanation:** Since the list has two middle nodes with values 3 and 4, we return the second one.
     *
     * ## Constraints:
     * - The number of nodes in the list is in the range [1, 100].
     * - 1 <= Node.val <= 100
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
            3, ListNode(
                4, ListNode(5)
            )
        )
        testCases[head1] = expected1

        val head2 = ListNode(
            1, ListNode(
                2, ListNode(
                    3, ListNode(
                        4, ListNode(
                            5, ListNode(6)
                        )
                    )
                )
            )
        )
        val expected2 = ListNode(
            4, ListNode(
                5, ListNode(6)
            )
        )
        testCases[head2] = expected2
    }

    /**
     * # Pseudo code
     * ## Function middleNode(head):
     * 1. Use two pointers `slow` and `fast`.
     * 2. Move `slow` one step at a time and `fast` two steps at a time.
     * 3. When `fast` reaches the end, `slow` will be at the middle.
     * 4. Return `slow`.
     */
    private fun middleNode(head: ListNode?): ListNode? {
        var slow = head
        var fast = head
        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next
        }
        return slow
    }

    @Test
    fun middleNodeTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = middleNode(input)
            val result = actualResult?.equal(expectedResult)
            assertEquals(result, true)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Traversing the list using two pointers:**
     *    The function traverses the list once, making the complexity **O(n)** where `n` is the number of nodes.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since only a few pointers are used for manipulation.
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
