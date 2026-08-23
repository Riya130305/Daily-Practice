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
    public ListNode reverseList(ListNode head) {
        if(head==null) return head;

        ListNode temp = head;
        ListNode prv=null;

        while(temp!=null){
            ListNode curr=temp.next;
            temp.next=prv;
            prv=temp;
            temp=curr;
        }
        return prv;
    }
}