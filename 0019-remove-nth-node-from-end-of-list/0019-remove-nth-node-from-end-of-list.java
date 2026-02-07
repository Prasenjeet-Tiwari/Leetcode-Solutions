class Solution {

    public ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {

        // Step 1: reverse the list
        ListNode revHead = reverse(head);

        // Step 2: remove nth node from start
        if (n == 1) {
            revHead = revHead.next;
        } else {
            ListNode curr = revHead;
            for (int i = 1; i <= n - 2; i++) {
                curr = curr.next;
            }
            curr.next = curr.next.next;
        }

        // Step 3: reverse back
        return reverse(revHead);
    }
}
