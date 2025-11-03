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
        PriorityQueue<ListNode> pq= new PriorityQueue<>((a,b)->(a.val-b.val));
        for(ListNode i:lists)
        {
            if(i!=null){
            pq.add(i);
            }
        }
        ListNode temp= new ListNode(0);
        ListNode dummy=temp;

        while(!pq.isEmpty())
        {
            ListNode t=pq.poll();
            dummy.next=t;
            dummy=dummy.next;
             if(t.next!=null)
            {
                pq.add(t.next);
            }
        }
        return temp.next;
    }
}