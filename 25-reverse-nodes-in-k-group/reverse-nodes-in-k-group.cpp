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
    ListNode* reverseKGroup(ListNode* head, int k) {
        if(head==nullptr || k==1) return head;
        vector<int> arr;
        ListNode* temp =head;
        
        while(temp!=nullptr){
            arr.push_back(temp->val);
            temp=temp->next;
        } 
        int count=0;
        for(int i=0;i+k<=arr.size();i+=k){
            // count++;
            // if(count==k){
                swap(arr,i,k);
            // }
        }
        // ListNode* prv=nullptr;
        // int count=0;

        // while(temp!=nullptr){
        //     if(count<=k){
        //         count++;
        //         ListNode* curr= temp->next;
        //         temp->next=prv;
        //         prv=temp;
        //         temp=curr;
        //     }
        //     else{
        //         count=0;
        //         temp=temp->next;
        //     }
        // }
        ListNode* dummy=new ListNode(0);
        ListNode* tail=dummy;
        for(int i=0;i<arr.size();i++){
            tail->next=new ListNode(arr[i]);
            tail=tail->next;
        }
        return dummy->next;
    }
public:
    void swap(vector<int> &arr,int i,int k){
        int st=i;
        int end=i+k-1;

        while(st<end){
            int temp=arr[st];
            arr[st]=arr[end];
            arr[end]=temp;

            st++;
            end--;
        }
        return ;
    }
};