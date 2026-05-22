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
    class HeadTail{
        ListNode head;
        ListNode tail;
        HeadTail(ListNode head, ListNode tail){
            this.head=head;
            this.tail=tail;
        }
    }
    public HeadTail reverseKth(ListNode head){

        ListNode prv=null;
        ListNode curr=head;
        while(curr!=null){
            ListNode next=curr.next;
            curr.next=prv;
            prv=curr;
            curr=next;
        }

        return new HeadTail(prv, head); //(head, tail)
    }
    public ListNode reverseKGroup(ListNode head, int k) {

        if(head==null || head.next==null) return head;
        if(k==1) return head; //i.e jsut reverse the whole list(normally)

        int length=0;
        ListNode temp=head;
        while(temp!=null){
            temp=temp.next;
            length++;
        }
        ListNode realDummy=new ListNode(0); realDummy.next=head;
        ListNode dummy=realDummy;
        ListNode start=head; ListNode end=head;
        int j=0;
        while(end!=null){
            if(j==k-1){
                ListNode nextPtr=end.next;
                end.next=null;
                HeadTail ht= reverseKth(start);

                dummy.next=ht.head;
                ht.tail.next=nextPtr;
                dummy=ht.tail;
                start=end=nextPtr;
                j=0;
            }else{
                end=end.next;
                j++;
            }
            
        }

        return realDummy.next;

        
    }
}