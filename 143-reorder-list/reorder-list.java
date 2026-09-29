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
    public void reorderList(ListNode head) {
        ListNode slow= head;
        ListNode fast= head;

        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }

        //ListNode list = slow.next;
        ListNode temp=slow.next;
        slow.next=null;
        ListNode prev = null;

        while(temp!=null){
            ListNode curr = temp.next;
            temp.next = prev;
            prev=temp;
            temp=curr;
            //System.out.println("PREV:"+prev.val);
        }
        ListNode ans =  new ListNode(0);
        ListNode dummy = ans ;
        int count = 1;

        while(prev!=null){
            if(count%2==1){
                dummy.next=head;
                System.out.println("head:"+head.val);
                head=head.next;
            }
            else{
                dummy.next=prev;
                System.out.println("prev:"+prev.val);
                prev=prev.next;
            }
            count++;
            dummy=dummy.next;
        }
        while(head!=null){
            dummy.next=head;
            dummy=dummy.next;
            head=head.next;

        }
    }
}