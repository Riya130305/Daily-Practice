/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */

class Solution {
public:

    vector<TreeNode*> inorder;

    void traversal(TreeNode* root)
    {
        if(root==nullptr)
            return;

        traversal(root->left);

        inorder.push_back(root);

        traversal(root->right);
        
    }


    void recoverTree(TreeNode* root) {

        traversal(root);

        vector<TreeNode*> sorted = inorder;

        sort(sorted.begin(), sorted.end(), [](TreeNode* a, TreeNode* b) {
        return a->val < b->val;
        });


        int first=-1;
        int second=-1;


        for(int i=0;i<inorder.size();i++)
        {
            if(inorder[i]!=sorted[i])
            {
                if(first==-1)
                    first=i;
                else
                    second=i;
            }
        }


        swap(inorder[first]->val,inorder[second]->val);
    }
};

// T.C -> Traversal O(n) Sorting O(n log n) --> O(nlog(n))
// S.C -> O(n);


// class Solution {
// public:
//     TreeNode* prv=nullptr;
//     TreeNode* first=nullptr;
//     TreeNode* second=nullptr;

//     void inOrder(TreeNode* root){
//         if(root==nullptr) return ;

//         inOrder(root->left);

//         if(prv!=nullptr && prv->val > root->val ){
//             if(first==nullptr){
//                 first=prv;
//             }
//             second=root;
//         }

//         prv=root;
//         inOrder(root->right);
//     }    

// public:
//     void recoverTree(TreeNode* root) {
//         if(root==nullptr) return ;
        
//         inOrder(root);

//         // swap logic
//         int temp= first->val;
//         first->val=second->val;
//         second->val=temp;
//     }
// };

// //T.C -> O(N)
// //S.C -> O(H)