class Solution {
public:
    ListNode* deleteDuplicates(ListNode* head) {

        if(head == nullptr)
            return nullptr;

        set<int> st;

        ListNode* curr = head;
        ListNode* prev = nullptr;

        while(curr != nullptr){

            if(st.find(curr->val) == st.end()){
                // Value not present
                st.insert(curr->val);
                prev = curr;
                curr = curr->next;
            }
            else{
                // Duplicate found
                prev->next = curr->next;
                curr = curr->next;
            }
        }

        return head;
    }
};