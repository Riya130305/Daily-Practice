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
    public ListNode mergeTwoLists(ListNode h1, ListNode h2) {
        ListNode i=h1;
        ListNode j=h2;
        ListNode temp = new ListNode(0);
        ListNode dummy = temp;
        
        while(i!= null && j!=null){
            if(i.val < j.val){
                dummy.next = i;
                
                i=i.next;
            }
            else {
                dummy.next = j;
                
                j=j.next;
            }
            dummy=dummy.next;
        }

        while(i!=null){
            dummy.next = i;
            dummy=dummy.next;
            i=i.next;

        }
        while(j!=null){
            dummy.next = j;
            dummy=dummy.next;
            j=j.next;
        }

    return temp.next;
    }
}