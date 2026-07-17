class Solution {
    public ListNode swapPairs(ListNode head) {
        // Create a dummy node to handle edge cases cleanly
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        
        ListNode prv = dummy;
        ListNode currHead = head;
        
        while (currHead != null && currHead.next != null) {
            ListNode temp = currHead.next;
            
            // Fix pointer adjustments
            prv.next = temp;
            currHead.next = temp.next;
            temp.next = currHead;
            
            // Advance pointers for next pair
            prv = currHead;
            currHead = currHead.next;
        }
        
        return dummy.next;
    }
}
