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
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        if(l1==nullptr && l2==nullptr) return nullptr;
        ListNode* a=l1;
        ListNode* b=l2;
        ListNode* dummy= new ListNode(0);
        ListNode* ans=dummy;
        int carry=0;
        while(a!=nullptr && b!=nullptr){
            int sum=(a->val+b->val)+carry;
            carry=sum/10; //1
            int base=sum%10; //1
            ListNode* val = new ListNode(base);
            ans->next=val;
            ans=ans->next;
            a=a->next;
            b=b->next;
        }

        while(a!=nullptr){
           int sum=a->val+carry;
            carry=sum/10; //1
            int base=sum%10; //1
            ListNode* val = new ListNode(base);
             ans->next=val;
            ans=ans->next;
            a=a->next;
        }

        while(b!=nullptr){
           int sum=b->val+carry;
            carry=sum/10; //1
            int base=sum%10; //1
            ListNode* val = new ListNode(base);
            ans->next=val;
            ans=ans->next;
            b=b->next;
        }

        if(carry >0){
            ListNode* val = new ListNode(carry);
            ans->next=val;
            ans=ans->next;
        }

        return dummy->next;
    }
};