package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class LinkedListCycle {
    /**
     * # [141. Linked List Cycle](https://leetcode.com/problems/linked-list-cycle/)
     * Given head, the head of a linked list, determine if the linked list has a cycle in it.
     *
     * ## Example 1:
     * - **Input:** head = [3,2,0,-4], pos = 1
     * - **Output:** true
     * - **Explanation:** There is a cycle in the linked list, where the tail connects to the 1st node (0-indexed).
     *
     * ## Example 2:
     * - **Input:** head = [1,2], pos = 0
     * - **Output:** true
     * - **Explanation:** There is a cycle in the linked list, where the tail connects to the 0th node.
     *
     * ## Example 3:
     * - **Input:** head = [1], pos = -1
     * - **Output:** false
     * - **Explanation:** There is no cycle in the linked list.
     *
     * ## Constraints:
     * - The number of the nodes in the list is in the range [0, 10^4].
     * - -10^5 <= Node.val <= 10^5
     * - `pos` is -1 or a valid index in the linked-list.
     */

    private val testCases = mutableMapOf<ListNode?, Boolean>()

    @Before
    fun setup() {
        val head1 = ListNode(3).apply {
            next = ListNode(2).apply {
                next = ListNode(0).apply {
                    next = ListNode(-4).apply {
                        next = this@apply // Creating a cycle at node 2
                    }
                }
            }
        }
        testCases[head1] = true

        val head2 = ListNode(1).apply {
            next = ListNode(2).apply {
                next = this // Creating a cycle at node 1
            }
        }
        testCases[head2] = true

        val head3 = ListNode(1)
        testCases[head3] = false

        testCases[null] = false // Empty list
    }

    /**
     * # Pseudo code
     * ## Function hasCycle(head):
     * 1. Use two pointers, `slow` and `fast`.
     * 2. Initialize both pointers at the head of the list.
     * 3. Move `slow` one step and `fast` two steps at a time.
     * 4. If `slow` and `fast` meet at some point, a cycle exists.
     * 5. If `fast` reaches the end of the list (`null`), no cycle exists.
     * 6. Return true if a cycle exists, otherwise false.
     */
    private fun hasCycle(head: ListNode?): Boolean {
        var slow = head
        var fast = head

        while (fast != null && fast.next != null) {
            slow = slow?.next
            fast = fast.next?.next

            if (slow == fast) return true
        }

        return false
    }

    @Test
    fun hasCycleTests() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = hasCycle(input)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Traversal:**
     *    Both `slow` and `fast` pointers traverse the list, so the complexity is **O(n)** where `n` is the number of nodes in the list.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since no extra space is used apart from the pointers.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */

    class ListNode(var value: Int) {
        var next: ListNode? = null

        constructor(value: Int, next: ListNode?) : this(value) {
            this.next = next
        }
    }
}
