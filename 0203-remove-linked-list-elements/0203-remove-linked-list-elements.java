class Solution {
    public ListNode removeElements(ListNode head, int val) {
        // 1. Create a dummy node that points to the head
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        // 2. Start our traveler pointer at the dummy node
        ListNode current = dummy;
        
        // 3. Look ahead to the next node
        while (current.next != null) {
            if (current.next.val == val) {
                // Skip the node containing the target value
                current.next = current.next.next;
                // Notice we DO NOT move 'current' forward here, 
                // because we need to check the new current.next on the next loop!
            } else {
                // Only move forward if we didn't delete anything
                current = current.next;
            }
        }
        
        // 4. Return the actual head, which is safely attached to dummy.next
        return dummy.next;
    }
}