package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*
////////////
class MergeTwoSortedLists {
    /**
     * # [21. Merge Two Sorted Lists](https://leetcode.com/problems/merge-two-sorted-lists/)
     * You are given the heads of two sorted linked lists list1 and list2.
     * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
     * Return the head of the merged linked list.
     *
     * ## Example 1:
     * - **Input:** list1 = [1,2,4], list2 = [1,3,4]
     * - **Output:** [1,1,2,3,4,4]
     * ## Example 2:
     * - **Input:** list1 = [], list2 = []
     * - **Output:** []
     * ## Example 3:
     * - **Input:** list1 = [], list2 = [0]
     * - **Output:** [0]
     *
     * ## Constraints:
     * - The number of nodes in both lists is in the range [0, 50].
     * - -100 <= Node.val <= 100
     * - Both list1 and list2 are sorted in non-decreasing order.
     */

    private val testCases = mutableMapOf<Pair<ListNode?, ListNode?>, ListNode?>()

    @Before
    fun setup() {
        val list1_1 = ListNode(
            1, ListNode(
                2, ListNode(4)
            )
        )
        val list2_1 = ListNode(
            1, ListNode(
                3, ListNode(4)
            )
        )
        val expected1 = ListNode(
            1, ListNode(
                1, ListNode(
                    2, ListNode(
                        3, ListNode(
                            4, ListNode(4)
                        )
                    )
                )
            )
        )
        testCases[Pair(list1_1, list2_1)] = expected1

        val list1_2: ListNode? = null
        val list2_2: ListNode? = null
        val expected2: ListNode? = null
        testCases[Pair(list1_2, list2_2)] = expected2

        val list1_3: ListNode? = null
        val list2_3 = ListNode(0)
        val expected3 = ListNode(0)
        testCases[Pair(list1_3, list2_3)] = expected3
    }

    /**
     * # Pseudo code
     * ## Function mergeTwoLists(list1, list2):
     * 1. Create a dummy node to serve as the start of the merged list.
     * 2. Initialize a pointer `current` to the dummy node.
     * 3. While both lists are not empty:
     *    - Compare the values of the current nodes in `list1` and `list2`.
     *    - Attach the smaller node to `current.next`.
     *    - Move the pointer of the list whose node was attached.
     *    - Move `current` to `current.next`.
     * 4. Attach the remaining nodes of the non-empty list (if any) to `current.next`.
     * 5. Return `dummy.next`.
     */
    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val dummy = ListNode(0)
        var current = dummy
        var l1 = list1
        var l2 = list2

        while (l1 != null && l2 != null) {
            if (l1.value <= l2.value) {
                current.next = l1
                l1 = l1.next
            } else {
                current.next = l2
                l2 = l2.next
            }
            current = current.next!!
        }

        current.next = l1 ?: l2

        return dummy.next
    }

    @Test
    fun mergeTwoListsTests() {
        testCases.forEach { (input, expectedResult) ->
            val (list1, list2) = input
            val actualResult = mergeTwoLists(list1, list2)
            val result = actualResult?.equal(expectedResult)
            assertEquals(result, true)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Traversing through both lists:**
     *    The function traverses all nodes in both lists, making the complexity **O(n + m)** where `n` and `m` are the lengths of the two lists.
     *
     * ### Space Complexity:
     * The space complexity is **O(1)** since only a few pointers are used for manipulation.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n + m)**
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
