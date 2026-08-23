class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        if(head == null || head.next == null) return head;

        int length = 1;
        ListNode temp = head;

        while(temp.next != null){
            length++;
            temp = temp.next;
        }

        temp.next = head; // make circular

        k = k % length;
        if(k == 0) {
            temp.next = null;
            return head;
        }

        int tail = length - k;

        temp = head; // reset to head

        for(int i = 1; i < tail; i++){
            temp = temp.next;
        }

        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }
}