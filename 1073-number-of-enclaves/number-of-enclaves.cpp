class Solution {
public:
    int numEnclaves(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size();

        vector<vector<bool>> visited(n,vector<bool>(m,false));// o(n*m)
        queue<vector<int>> q;//o(n)

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //boundary 1 is added to queue
                if(i==0 || j==0 || i==n-1 || j==m-1){
                    if(grid[i][j]==1){
                    q.push({i,j});
                    visited[i][j]=true;
                    }
                }
            }
        }

        while(!q.empty()){
            auto node=q.front();
            q.pop();
            int i=node[0];
            int j=node[1];

            // 4 direction call
            int r[]={0,-1,0,1};
            int c[]={-1,0,1,0};

            for(int k=0;k<4;k++){
                 
                int nr=i+r[k];
                int nc=j+c[k];

                if(nr>=0 && nc>=0 && nr<n && nc<m && visited[nr][nc]==false && grid[nr][nc]==1) {
                    q.push({nr,nc});
                    visited[nr][nc]=true;
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    count++;
                }
            }
        }
        return count ;
    }
};