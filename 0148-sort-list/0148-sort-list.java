/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode MergeSortCombine(ListNode head1, ListNode head2){
        ListNode root1=head1;
        ListNode root2=head2;
        ListNode dummy=new ListNode(0);
        ListNode root=dummy;

        while(head1!=null && head2!=null){
            if(head1.val<=head2.val){
                dummy.next=head1;
                head1=head1.next;
                dummy=dummy.next;
            }else{
                dummy.next=head2;
                head2=head2.next;
                dummy=dummy.next;
            }
        }
        while(head1!=null){
            dummy.next=head1;
            head1=head1.next;
            dummy=dummy.next;
        }
        while(head2!=null){
            dummy.next=head2;
            head2=head2.next;
            dummy=dummy.next;
        }

        return root.next;
    }

    public ListNode MergeSort(ListNode head){
        // 1. Base Case: a list of 0 or 1 element is already sorted
        if (head == null || head.next == null) return head;

        // 2. Find the midpoint. 
        // Starting fast at head.next leaves slow at the END of the left half.
        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // 3. Split the list into two halves cleanly
        ListNode rightHead = slow.next; 
        slow.next = null; // This breaks the link, separating left and right halves

        // 4. Recurse on both halves
        ListNode head1 = MergeSort(head);      // left part (now safely bounded)
        ListNode head2 = MergeSort(rightHead); // right part

        // 5. Merge them back together using your working combine function
        return MergeSortCombine(head1, head2);
    }
    public ListNode sortList(ListNode head) {
        return MergeSort(head);
    }
}