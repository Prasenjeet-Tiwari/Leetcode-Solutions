class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // Use descriptive iterator names instead of underscores
        ListNode p1 = l1;
        ListNode p2 = l2;

        // Establish a clear dummy head tracking system
        ListNode dummyHead = new ListNode(0);
        ListNode currentTail = dummyHead;
        int carry = 0;

        // Keep looping as long as there are numbers left to add or a leftover carry
        while (p1 != null || p2 != null || carry != 0) {
            int val1 = (p1 != null) ? p1.val : 0;
            int val2 = (p2 != null) ? p2.val : 0;

            // Compute math metrics
            int totalSum = val1 + val2 + carry;
            int digitValue = totalSum % 10;
            carry = totalSum / 10;

            // Append the new digit node to our result list
            currentTail.next = new ListNode(digitValue);
            currentTail = currentTail.next;

            // Safely advance our input iterators forward
            if (p1 != null) p1 = p1.next;
            if (p2 != null) p2 = p2.next;
        }

        // Return the actual head skipping our dummy buffer
        return dummyHead.next;
    }
}