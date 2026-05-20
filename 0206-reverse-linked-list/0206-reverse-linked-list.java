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
    public ListNode reverse(ListNode head){
        if(head== null) return null;
        if(head.next==null) return head;
        
        ListNode prv=null;
        ListNode curr=head;

        while(curr!=null){
            ListNode nextNode= curr.next;
            curr.next=prv;
            prv=curr;
            curr=nextNode;
        }

        return prv; //cause now prv becomes head
    }
    public ListNode reverseList(ListNode head) {
        return reverse(head);
    }
}