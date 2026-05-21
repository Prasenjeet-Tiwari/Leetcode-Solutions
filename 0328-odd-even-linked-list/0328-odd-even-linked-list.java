class Solution {
    public ListNode oddEvenList(ListNode head) {
        // Base case: if there are fewer than 3 elements, no rearranging needed
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        } 

        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenHead = even; // Save the start of the even list to stitch later

        // Interleave the skips simultaneously
        while (even != null && even.next != null) {
            odd.next = even.next;    // Connect odd node to next odd node
            odd = odd.next;          // Advance odd pointer
            
            even.next = odd.next;    // Connect even node to next even node
            even = even.next;        // Advance even pointer
        }

        // Stitch the end of the odd list to the head of the even list
        odd.next = evenHead;

        return head;
    }
}