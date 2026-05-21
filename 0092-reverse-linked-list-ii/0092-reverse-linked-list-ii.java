class Solution {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        // Step 1: Dummy node setup
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        // Step 2: Move prev to the node right before the sublist starts
        for (int i = 1; i < left; i++) {
            prev = prev.next;
        }

        // Step 3: curr starts at the beginning of the sublist
        ListNode curr = prev.next;

        // Step 4: Reverse the links within the sublist range
        //i.e take current node put it just after prev and adjust rest acc
        for (int i = 0; i < right - left; i++) {
            ListNode nxt = curr.next;
            curr.next = nxt.next;
            nxt.next = prev.next;
            prev.next = nxt;
        }

        return dummy.next;
    }
}