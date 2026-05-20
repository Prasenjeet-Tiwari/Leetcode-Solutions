/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int length(ListNode head){
        int len=0;
        ListNode root= head;
        while(root!=null){
            root=root.next;
            len++;
        }
        return len;
    }

    public ListNode movedNthPlace(ListNode head, int n){
        ListNode root=head;
        while(n>0){
            root=root.next;
            n--;
        }
        return root;
    }
    public ListNode findInternsection(ListNode head1, ListNode head2){

        while(head1!=null && head2!=null){
            if(head1==head2){
                return head1;
            }else{
                //if(head1.next==null || head2.next==null) return null;
                head1=head1.next;
                head2=head2.next;
            }
        }
        return null;
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA=length(headA);
        int lenB=length(headB);

        if(lenA>=lenB){
            ListNode newHeadA=movedNthPlace(headA, lenA-lenB);
            return findInternsection(newHeadA, headB);
        }else{
            ListNode newHeadB=movedNthPlace(headB, lenB-lenA);
            return findInternsection(newHeadB, headA);
        }
    }
}