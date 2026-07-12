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
    ListNode* mergeTwoLists(ListNode* list1, ListNode* list2) {
        ListNode* i=list1;
        ListNode* j=list2;
        ListNode* dummy= new ListNode(0);
        ListNode* tail=dummy;

        while(i!=nullptr && j!=nullptr){
            if(i->val < j->val){
                tail->next=i;
                tail=tail->next;
                i=i->next;
            }
            else{
                tail->next=j;
                tail=tail->next;
                j=j->next;
            }
        }

        while(i!=nullptr){
            tail->next=i;
            tail=tail->next;
            i=i->next;
        }
        while(j!=nullptr){
            tail->next=j;
             tail=tail->next;
            j=j->next;
        }
        return dummy->next;
    }
};