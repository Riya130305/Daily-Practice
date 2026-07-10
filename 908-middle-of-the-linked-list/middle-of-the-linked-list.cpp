class Solution {
public:
    ListNode* middleNode(ListNode* head) {

        vector<ListNode*> arr;

        while(head != nullptr) {
            arr.push_back(head);
            head = head->next;
        }

        return arr[arr.size()/2];
    }
};