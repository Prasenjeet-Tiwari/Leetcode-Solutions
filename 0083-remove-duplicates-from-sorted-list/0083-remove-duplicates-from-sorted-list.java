class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;

        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                // Duplicate found: skip the next node
                current.next = current.next.next;
            } else {
                // Distinct value: move to the next node
                current = current.next;
            }
        }

        return head;
    }
}
