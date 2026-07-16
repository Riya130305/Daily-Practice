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
        ListNode* fast =head;

        while(fast!=nullptr && fast->next!=nullptr){
            slow=slow->next;
            fast=fast->next->next;
        }
        ListNode* temp=slow;
        ListNode* pre=nullptr;

        while(temp!=nullptr){
            ListNode* curr= temp->next;
            temp->next=pre;
            pre=temp;
            temp=curr;
        }
      // cout << slow->val << endl;
        while(head!=nullptr && pre!=nullptr){
            if(head->val!=pre->val) return false;
            //  cout << head->val << endl;
            head=head->next;
            // cout << slow->val << endl;
            pre=pre->next;
        }
        return true;
    }
};