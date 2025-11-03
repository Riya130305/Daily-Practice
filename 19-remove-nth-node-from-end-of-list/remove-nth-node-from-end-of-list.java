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
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp =head;
        while(temp!=null)
        {
            arr.add(temp.val);
            temp=temp.next;
        }
        int c=0;
        arr.remove(arr.size()-n);
        ListNode ans=new ListNode(0);
        ListNode dummy=ans ;
        for(int i=0;i<arr.size();i++)
        {
            dummy.next=new ListNode(arr.get(i));
            dummy=dummy.next;
        }
        return ans.next;
    }
}