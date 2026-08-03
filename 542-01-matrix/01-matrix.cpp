class Solution {
public:
    void recursionCall(int i, int j,vector<vector<int>>& mat,int count){
        int n=mat.size();
        int m=mat[0].size();
        if(i<0 || j<0 || i>n-1 || j>m-1) return;
        
        if(mat[i][j]==1){
            count++;
        }
        mat[i][j]=count;
    }    
public:
    vector<vector<int>> updateMatrix(vector<vector<int>>& mat) {
        int n=mat.size();
        int m=mat[0].size();

        vector<vector<int>> ans(n,vector<int>(m,-1)) ;
        queue<vector<int>> q;

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
               
                if(mat[i][j]==0){
                    q.push({i,j});
                    ans[i][j]=0;
                }
            }
        }
        int delRow[]={-1,1,0,0};
        int delCol[]={0,0,-1,1};

        while(!q.empty()){
            auto curr=q.front();
            q.pop();

            int i=curr[0];
            int j=curr[1];

            for(int k=0;k<4;k++){
                int ni=i+delRow[k];
                int nj=j+delCol[k];

                 // boundary check
                if(ni<0 || nj<0 || ni>=n || nj>=m)
                    continue;

                 if(ans[ni][nj] == -1){

                    ans[ni][nj] = ans[i][j] + 1;

                    q.push({ni,nj});
                }

            }
        }
        
        return ans;
    }
};


                    // recursionCall(i,j-1,mat,count);
                    // recursionCall(i-1,j,mat,count);
                    // recursionCall(i,j+1,mat,count);
                    // recursionCall(i+1,j,mat,count);