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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = 0;
        ListNode temp = head;
        ListNode  ans =null;

        while(temp!=null){
            len++;
            temp=temp.next;
        }
        if(len==1) return ans;
        if(len == n) return head.next;
        temp=head;
        int i=1;

        while(temp!=null){
            if(len-n==i){
                //continue;
                temp.next=temp.next.next;
                break;
            }
            temp=temp.next;
            i++;
        }
        return head;
    }

}