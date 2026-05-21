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
    public ListNode reverseListNode(ListNode head){

        if(head==null || head.next==null) return head;

        ListNode prv=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next= curr.next;
            curr.next=prv;
            prv=curr;
            curr=next;
        }
        return prv;
    }
    public ListNode eliminate(ListNode head){
        ListNode root=head;
        ListNode dummy=root;    // 1st node always included

        while(dummy!=null &&  dummy.next!=null){
            if(dummy.next.val >= dummy.val){
                dummy=dummy.next;
            }else{
                dummy.next=dummy.next.next;
            }
        }
        return root;
    }
    public ListNode removeNodes(ListNode head) {

        if(head==null || head.next==null) return head;

        ListNode revHead1=reverseListNode(head);
        ListNode removed=eliminate(revHead1);
        ListNode revHead2=reverseListNode(removed);

        return revHead2;
        
    }
}