package mohamed.arfa.problemsolving.medium.swappingNodesInALinkedList

import org.junit.Before


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

    private val testCases = mutableMapOf<Pair<String,String>,Boolean>()
    @Before
    fun start(){
        testCases["anagram" to "nagaram"] = true
        testCases["moioi" to "oimoi"] = true
        testCases["rat" to "car"] = false
    }

    fun swapNodes(head: Any?, k: Int): Any? {

        return Any()
    }


}