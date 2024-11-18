package mohamed.arfa.problemsolving.medium

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*


class SwappingNodesInALinkedList {
    /**
     * # [1721. Swapping Nodes in a Linked List](https://leetcode.com/problems/swapping-nodes-in-a-linked-list/description/)
     * You are given the `head` of a linked list, and an integer `k`.
     *
     * Return the head of the linked list after swapping the values of the kth node from the beginning and the kth node from the end (the list is 1-indexed).
     *
     *
     *
     * ## Example 1:
     * [Description of Image](https://assets.leetcode.com/uploads/2020/09/21/linked1.jpg)
     * - **Input:** head = [1,2,3,4,5], k = 2
     * - **Output:** [1,4,3,2,5]
     * ## Example 2:
     *
     * - **Input:** head = [7,9,6,6,7,8,3,0,9,5], k = 5
     * - **Output:** [7,9,6,6,8,7,3,0,9,5]
     *
     * ## Constraints:
     *
     * - The number of nodes in the list is n.
     * - 1 <= k <= n <= 105
     * - 0 <= Node.val <= 100
     */

    private val testCases = mutableMapOf<Pair<ListNode,Int>, ListNode>()

    @Before
    fun start() {
        val head = ListNode(
            1,
            ListNode(
                2,
                ListNode(
                    3,
                    ListNode(4, ListNode(5))
                )
            )
        )

        val expected  = ListNode(
            1,
            ListNode(
                4,
                ListNode(
                    3,
                    ListNode(
                        2,
                        ListNode(5)
                    )
                )
            )
        )

        testCases[head to 2] = expected

        val head2 = ListNode(
            7, ListNode(
                9, ListNode(
                    6, ListNode(
                        6, ListNode(
                            7, ListNode(
                                8, ListNode(
                                    3, ListNode(
                                        0, ListNode(
                                            9, ListNode(5)
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )

        val expected2 = ListNode(
            7,
            ListNode(
                9,
                ListNode(
                    6,
                    ListNode(
                        6,
                        ListNode(
                            8,
                            ListNode(
                                7,
                                ListNode(
                                    3,
                                    ListNode(
                                        0,
                                        ListNode(
                                            9,
                                            ListNode(5)
                                        )
                                    )
                                )
                            )
                        )
                    )
                )
            )
        )

        testCases[head2 to 5] = expected2
    }

    /**
     * # Pseudo code
     * ## Function swapNodes(head, k):
     * 1.    Initialize left pointer to head
     * 3.    Initialize right pointer to head
     * 3.    Move the left pointer to the k-th node
     * 4.    For i from 1 to k-1:
     * 5.        Move left to the next node
     * 6.   Use curr to find the end of the list while adjusting right pointer
     * 7.   Initialize curr pointer to left
     * 8.   While curr has a next node:
     * 9.       Move curr to the next node
     * 10.      Move right to the next node
     * 11.   Swap the values of the nodes at left and right
     * 12.   temp = left's value
     * 13.   left's value = right's value
     * 14.   right's value = temp
     * 15.   Return the head of the list
     */
    private fun swapNodes(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        var left = head
        var right = head
        for (i in 1 until k) {
            left = left?.next
        }
        var curr = left
        while (curr?.next != null) {
            curr = curr.next
            right = right?.next
        }
        val temp = left?.value
        left?.value = right?.value!!
        right.value = temp!!
        return head
    }
    /**
     * ### Time Complexity:
     *
     * 1. **Initialization of pointers (left and right):**
     *    This is a constant-time operation: **O(1)**.
     *
     * 2. **Moving left pointer to the k-th node:**
     *    This loop runs `k-1` times, so the complexity is **O(k)**.
     *
     * 3. **Moving `curr` pointer to the end while adjusting the right pointer:**
     *    This loop traverses the rest of the list after the k-th node, effectively traversing up to **O(n - k)** elements where `n` is the total number of nodes in the list.
     *    Since the sum of `k` and `n-k` is equivalent to `n`, this loop runs in **O(n)** time.
     *
     * 4. **Swapping values:**
     *    This is a constant-time operation: **O(1)**.
     *
     * ### Overall Time Complexity:
     * The total time complexity is:
     * `O(k) + O(n - k) + O(1) ≈ O(n)`
     * This is because the sum of **O(k)** and **O(n - k)** simplifies to **O(n)**.
     *
     * ### Space Complexity:
     * The space complexity of this function is **O(1)** since it only uses a constant amount of extra space for pointers and variables, regardless of the input size.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(1)**
     */

    @Test
    fun swappingNodesInALinkedList() {
        testCases.forEach { (input, expectedResult) ->
            val actualResult = swapNodes(input.first,input.second)
            val result = actualResult?.equal(expectedResult)
            assertEquals(result,true)
        }
    }
    private fun ListNode.equal(other: ListNode?): Boolean {
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

        constructor(value: Int, next: ListNode) : this(value) {
            this.next = next
        }
    }
}