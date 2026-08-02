class Solution {
    // res(i,j-1,grid,freshOrange,q);
public:
    void resursionFour(int i, int j,vector<vector<int>>& grid, int &freshOrange, queue<vector<int>> &q){
        //base case
        if(i<0 || j>grid[0].size()-1 || j<0 || i>grid.size()-1) return;

        if(grid[i][j]==1){
            q.push({i,j});
            grid[i][j]=2;
            freshOrange--;
        }
    }    
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int n=grid.size();
        int m=grid[0].size(), freshOrange=0;
        queue<vector<int>> q;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==2){
                    q.push({i,j});
                }
                else if(grid[i][j]==1){
                    freshOrange++;
                }
            }
        }

        int min=0;
        while(!q.empty()){
            int n=q.size();
            bool flag=false;
            for(int k=0;k<n;k++){
                vector<int> arr= q.front();
                int i=arr[0];
                int j=arr[1];
                q.pop();

                int before=freshOrange; 

                resursionFour(i,j-1,grid,freshOrange,q);
                resursionFour(i-1,j,grid,freshOrange,q);
                resursionFour(i,j+1,grid,freshOrange,q);
                resursionFour(i+1,j,grid,freshOrange,q);

                if(before!=freshOrange){
                    flag=true;
                }

            }
            if(flag==true){
                min++;
            }
        }
        if(freshOrange!=0){
            return -1;
        }
        return min;
    }
};