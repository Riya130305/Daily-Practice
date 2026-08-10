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
    bool isPalindrome(ListNode* head) {
        ListNode* slow=head;
        ListNode* fast=head;

        while(fast!=nullptr && fast->next!=nullptr){
            slow=slow->next;
            fast=fast->next->next;
        }

        ListNode* temp=slow;
        ListNode* prv=nullptr;

        while(temp!=nullptr){
            ListNode* curr=temp->next;
            temp->next=prv;
            prv=temp;
            temp=curr;
        }

        while(prv!=nullptr && head!=nullptr){
            if(head->val!=prv->val) return false;
            head=head->next;
            prv=prv->next;
        }
        return true;
    }
};