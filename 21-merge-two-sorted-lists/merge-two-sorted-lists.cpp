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
        vector<ListNode*> arr;
        int i=0;
        while(list1!=nullptr){
            arr.push_back(list1);
            list1=list1->next;
        }
        while(list2!=nullptr){
            arr.push_back(list2);
            list2=list2->next;
        }
        sort(arr.begin(), arr.end(),[](ListNode* a, ListNode* b){
            return a->val < b->val;
        });

        if(arr.empty())
        return nullptr;

        for(int i=0;i<arr.size()-1;i++){
            arr[i]->next=arr[i+1];
        }
        arr.back()->next=nullptr;
        return arr[0];
    }
};