/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode* oddEvenList(ListNode* head) {
        int count=1;
        ListNode* even=new ListNode(0);
        ListNode* odd= new ListNode(0);
        ListNode* eHead=even;
        ListNode* oHead=odd;

        while(head!=nullptr){
            ListNode* nextNode=head->next;  // save next node

            head->next=nullptr;
            if(count%2==1){
                odd->next=head;
                //cout << "ODD " << odd->next->val << endl;
                odd=odd->next;
            }
            else{
                even->next=head;
                //cout << "EVEN " << even->next->val << endl;
                even=even->next;
            }
            count++;
            head=nextNode;
        }
        odd->next=eHead->next;
        return oHead->next;
    }    
};