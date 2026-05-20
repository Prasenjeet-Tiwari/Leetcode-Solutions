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
    public boolean isPalindrome(ListNode head) {
        // Guard clause: An empty list is technically a palindrome
        if (head == null || head.next==null) {
            return true;
        }

        // Step 1: Find the middle of the list using slow/fast pointers
        ListNode fast = head;
        ListNode slow = head;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // Step 2: Reverse the second half of the list in-place
        // We use the middle node (slow) as our reversal anchor base
        ListNode prv2 = slow;
        ListNode curr = prv2.next;
        
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prv2;
            prv2 = curr;
            curr = nextNode;
        }

        // Sever the bridge between the two halves to cleanly stop the loop later
        slow.next = null;

        // Step 3: Simultaneously iterate from both ends and compare values
        ListNode headA = head;
        ListNode headB = prv2; // This is now the head of the reversed second half

        while (headA != null && headB != null) {
            if (headA.val != headB.val) {
                return false; 
            }
            headA = headA.next;
            headB = headB.next;
        }

        return true;
    }
}