class Solution {
public:
    int shortestPathBinaryMatrix(vector<vector<int>>& grid) {
        
        int ans=-1;
        int n=grid.size();
        int m=grid[0].size();

        queue<vector<int>> q;
        vector<vector<bool>> visited(n,vector<bool>(m,false));

        q.push({0,0,1});
        visited[0][0]=true;

        if(grid[0][0]!=0 || grid[n-1][m-1]!=0) return -1;

        int r[]={-1,-1,-1,0,0,1,1,1};
        int c[]={-1,0,1,-1,1,-1,0,1};

        while(!q.empty()){

            auto arr=q.front();
            int i=arr[0];
            int j=arr[1];
            int dis=arr[2];
            //ans=dis;
            q.pop();

            if(i==n-1 && j==m-1) return dis;

            for(int k=0;k<8;k++){
                int newR=r[k]+i;
                int newC=c[k]+j;

                if(newR>=0 && newC>=0 && newR<=n-1 && newC<=m-1 && grid[newR][newC]==0 && visited[newR][newC]==false){
                    q.push({newR, newC, dis+1});
                    visited[newR][newC]=true;
                }
            } 
        }
        return -1;
    }
};