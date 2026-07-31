class Solution {
public:

    vector<int> NSE(vector<int>& arr){

        int n=arr.size();

        vector<int> nse(n);

        stack<int> st;

        for(int i=n-1;i>=0;i--){

            while(!st.empty() && arr[st.top()]>=arr[i])
                st.pop();

            if(st.empty())
                nse[i]=n;
            else
                nse[i]=st.top();

            st.push(i);
        }

        return nse;
    }

    vector<int> PSEE(vector<int>& arr){

        int n=arr.size();

        vector<int> pse(n);

        stack<int> st;

        for(int i=0;i<n;i++){

            while(!st.empty() && arr[st.top()]>=arr[i])
                st.pop();

            if(st.empty())
                pse[i]=-1;
            else
                pse[i]=st.top();

            st.push(i);
        }

        return pse;
    }

    int largestHistogram(vector<int>& height){

        vector<int> nse=NSE(height);

        vector<int> pse=PSEE(height);

        int ans=0;

        for(int i=0;i<height.size();i++){

            int width=nse[i]-pse[i]-1;

            ans=max(ans,width*height[i]);
        }

        return ans;
    }

    int maximalRectangle(vector<vector<char>>& matrix) {

        if(matrix.empty()) return 0;

        int n=matrix.size();

        int m=matrix[0].size();

        vector<int> height(m,0);

        int ans=0;

        for(int i=0;i<n;i++){

            for(int j=0;j<m;j++){

                if(matrix[i][j]=='1')
                    height[j]++;
                else
                    height[j]=0;
            }

            ans=max(ans,largestHistogram(height));
        }

        return ans;
    }
};