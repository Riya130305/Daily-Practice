class Solution {
public:
    string removeKdigits(string num, int k) {
        if(k==num.size()) return "0";
        stack<char> st;
        //string s;
        st.push(num[0]);
        for(int i=1;i<num.size();i++){
            while(!st.empty() && num[i] < st.top() && k>0){
                //cout<< "pop " << st.top() << endl;
                st.pop();
                k--;
            }
            st.push(num[i]); 
        }

        while(k > 0){
            st.pop();
            k--;
        }

        string ans;

        while(!st.empty()){
            ans.push_back(st.top());
            st.pop();
        }
        reverse(ans.begin(),ans.end());
        while(ans[0]=='0' && ans.size()>1) {
            ans.erase(0,1);
        }
        if(ans.size()==1 && ans[0]=='0'){
            return "0";
        }
        return ans;
        
    }
};