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
        ListNode temp1=head;
        ListNode temp2=mid(head);
        ListNode t=temp2;
        temp2=null;
        while(t!=null)
        {
            ListNode res= t.next;
            t.next=temp2;
            temp2=t;
            t=res;
        }
        while(temp2!=null)
        {
            if(temp1.val!=temp2.val)
            {
                return false;
            }
            temp1=temp1.next;
            temp2=temp2.next;
        }
        return true;
    }
    public ListNode mid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;

        while(fast!=null && fast.next!=null)
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        return slow;
    }
}