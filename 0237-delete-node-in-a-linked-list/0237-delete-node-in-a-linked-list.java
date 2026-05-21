/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {

        // since the node is not the last element(given in q) we can use this  logic
        int nextNodeVal=node.next.val;
        node.val=nextNodeVal;     // copy the next node value to current
        node.next=node.next.next;   // delet the ndoe after that

        // no need to return anythingcause only uodation is asked
        
    }
}