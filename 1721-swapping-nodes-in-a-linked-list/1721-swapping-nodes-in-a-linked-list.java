class Solution {
    public ListNode swapNodes(ListNode head, int k) {
        if(head == null) return null;
        if(head.next == null) return head;

        // 1. Calculate length
        int length = 0;
        ListNode root = head;
        while(root != null){
            length++;
            root = root.next;
        }

        // 2. Find index of the node from the end (Fixed typo: Inx -> Idx)
        int secondNodeIdx = length - k + 1; 
        
        // 3. Move to the kth node from the beginning
        root = head;
        while(k > 1){
            root = root.next;
            k--;
        }
        ListNode firstElement = root;

        // 4. Move to the kth node from the end (Fixed typo: seconfElement -> secondElement)
        root = head;
        while(secondNodeIdx > 1){
            root = root.next;
            secondNodeIdx--;
        }
        ListNode secondElement = root;

        // 5. Swap the values!
        int temp = firstElement.val;
        firstElement.val = secondElement.val;
        secondElement.val = temp;

        return head;
    }
}