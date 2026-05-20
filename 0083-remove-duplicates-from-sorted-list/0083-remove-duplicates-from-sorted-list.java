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

    public ListNode removeDuplicate(ListNode head){

        if(head==null ){
            return null;
        }
        if(head.next==null){
            return head;
        }

        ListNode root=head;

        while(root!=null && root.next!=null){
            ListNode next= root.next;
            if(root.val==next.val){   //same value
                root.next=next.next;
            }else{
                root=next;  //i.e different values 
            }
        }
        return head;
    }


    public ListNode deleteDuplicates(ListNode head) {
        
        return removeDuplicate(head);
    }
}