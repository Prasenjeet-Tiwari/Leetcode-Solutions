class Solution {
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) return head;

        // Use a PriorityQueue to store nodes sorted by their value
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        
        ListNode curr = head;
        while (curr != null) {
            pq.add(curr);
            curr = curr.next;
        }

        ListNode dummy = new ListNode(0);
        ListNode temp = dummy;

        while (!pq.isEmpty()) {
            ListNode lowest = pq.poll();
            temp.next = lowest;
            temp = temp.next;
        }
        
        temp.next = null; // Important: prevent cycles
        return dummy.next;
    }
}
