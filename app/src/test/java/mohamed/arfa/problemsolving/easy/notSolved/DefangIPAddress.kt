package mohamed.arfa.problemsolving.easy

import org.junit.Before
import org.junit.Test
import org.junit.Assert.*

class DefangIPAddress {
    /**
     * # [1108. Defanging an IP Address](https://leetcode.com/problems/defanging-an-ip-address/)
     * Given a valid (IPv4) IP address, return a defanged version of that IP address. A defanged IP address replaces every period `"."` with `"[.]"`.
     *
     * ## Example 1:
     * - **Input:** address = "1.1.1.1"
     * - **Output:** "1[.]1[.]1[.]1"
     *
     * ## Example 2:
     * - **Input:** address = "255.100.50.0"
     * - **Output:** "255[.]100[.]50[.]0"
     *
     * ## Constraints:
     * - The given address is a valid IPv4 address.
     */

    private val testCases = mutableListOf<Pair<String, String>>()

    @Before
    fun setup() {
        testCases.add(
            Pair(
                "1.1.1.1",
                "1[.]1[.]1[.]1" // Expected result
            )
        )
        testCases.add(
            Pair(
                "255.100.50.0",
                "255[.]100[.]50[.]0" // Expected result
            )
        )
    }

    /**
     * # Function to defang an IP address
     */
    fun defangIPaddr(address: String): String {
        return address.replace(".", "[.]")
    }

    @Test
    fun defangIPaddrTests() {
        testCases.forEach { (address, expectedResult) ->
            val actualResult = defangIPaddr(address)
            assertEquals(expectedResult, actualResult)
        }
    }

    /**
     * ### Time Complexity:
     *
     * 1. **Replacing periods in the string:**
     *    - The replace operation processes the string once, so it takes **O(n)**, where `n` is the length of the string.
     *
     * 2. **Overall Complexity:**
     *    - The total complexity is **O(n)**.
     *
     * ### Space Complexity:
     * - The space complexity is **O(n)**, as a new string is created for the result.
     *
     * ### Summary:
     * - **Time Complexity:** **O(n)**
     * - **Space Complexity:** **O(n)**
     */
}
