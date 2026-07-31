class Solution {
public:
    vector<int> NSE(vector<int>& arr){
        int n=arr.size();
        vector<int> nse(n);
        stack<int>st;
        //st.push(n);

        for(int i=n-1;i>=0;i--){
            while(!st.empty() && arr[st.top()]>arr[i]){
                st.pop();
            }
            if(st.empty()){
                nse[i]=n;
            }
            else {
                nse[i]=st.top();
            }
            st.push(i);
        }
        return nse;
    }    
public:
    vector<int> PSEE(vector<int>& arr){
        int n=arr.size();
        vector<int> pse(n);
        stack<int>st;

        for(int i=0;i<n;i++){
            while(!st.empty() && arr[st.top()]>=arr[i]){
                st.pop();
            }
            if(st.empty()){
                pse[i]=-1;
            }
            else if(!st.empty()){
                pse[i]=st.top();
            }
            st.push(i);
        }
        return pse;
    }    
public:
    int largestRectangleArea(vector<int>& heights) {
        vector<int> nse=NSE(heights);
        vector<int> pse=PSEE(heights);
        int max1=0;
        for(int i=0;i<heights.size();i++){
            int dif=abs(pse[i]-nse[i])-1;
            int val=dif*heights[i];
            max1=max(max1,val);
        }
        return max1;
    }
};