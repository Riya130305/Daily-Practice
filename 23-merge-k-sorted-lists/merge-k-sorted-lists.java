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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(ListNode head:lists)
        {
            while(head!=null)
            {
                pq.add(head.val);
                head=head.next;
            }
        }
        ListNode dummy= new ListNode(0);
        ListNode a=dummy;
        while(pq.size()>0)
        {
            a.next=new ListNode(pq.poll());
            a=a.next;
        }
        return dummy.next;
    }
}