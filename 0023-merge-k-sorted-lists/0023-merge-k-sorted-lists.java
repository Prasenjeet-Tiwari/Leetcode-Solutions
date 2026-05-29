import java.util.PriorityQueue;

class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;

        //  Pass a custom comparator so the heap knows how to sort nodes
        PriorityQueue<ListNode> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.val, b.val)
        );

        // Insert the head of each non-empty linked list into the min-heap
        for (ListNode head : lists) {
            if (head != null) {
                pq.offer(head);
            }
        }

        // Initialize a dummy node to build the new list safely
        ListNode dummy = new ListNode(-1);
        ListNode current = dummy;

        while (!pq.isEmpty()) {
            ListNode smallestNode = pq.poll();
            current.next = smallestNode;
            current = current.next;

            // If the pulled node has a next element, push it into the heap
            if (smallestNode.next != null) {
                pq.offer(smallestNode.next);
            }
        }

        return dummy.next;
    }
}