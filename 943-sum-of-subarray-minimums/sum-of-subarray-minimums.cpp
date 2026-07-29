class Solution {
public:
    vector<int> NSE(vector<int>& arr){
        int n=arr.size();
        vector<int> ans(n);

        stack<int>st;
        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.top()] >= arr[i]){
                st.pop();
            }
            if(!st.empty()){
                ans[i]=st.top();
            }
            else{
                ans[i]=n;
            }
            st.push(i);
        }
        return ans;
    }
public:
    vector<int>  PSEE(vector<int>& arr){
        int n=arr.size();
        vector<int> ans(n);
        stack<int>st;
        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.top()] > arr[i]){
                st.pop();
            }
            if(!st.empty()){
                ans[i]=st.top();
            }
            else{
                ans[i]=-1;
            }
            st.push(i);
        }
        return ans;
    }


public:
    int sumSubarrayMins(vector<int>& arr) {
        vector<int> nes= NSE(arr);
        vector<int> pse=PSEE(arr);
        long long sum=0;
        int mod =1000000007;
        for(int i=0;i<arr.size();i++){
            long long left=i-pse[i];
            long long right=nes[i]-i;
            sum=(sum+(left*right*arr[i]))%mod;

        }
        return (int) sum;
    }
};