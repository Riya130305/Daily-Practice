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
    ListNode* rotateRight(ListNode* head, int k) {
         if(head==nullptr || head->next==nullptr || k==0)
            return head;
            
        ListNode* temp=head;
        int count=1;

        while(temp->next!=nullptr){
            count++;
            temp=temp->next;
        }

        int c=0;
        k=k%count;

        if(k==0) return head;
        temp->next=head;
        // Tail node
        int tail=count-k;
        temp=head;
        ListNode* dummy= new ListNode(0);
        ListNode* newNode=dummy;

        for(int i=1;i<tail;i++){
            temp=temp->next;
        }
        newNode->next=temp->next;
        temp->next=nullptr;
       

        return dummy->next;
    }
};