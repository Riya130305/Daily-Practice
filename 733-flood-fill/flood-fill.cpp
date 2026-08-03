class Solution {
public:
    void dfs(int i,int j,vector<vector<int>>& image,vector<vector<bool>>& visited,int val,int color){
        if(i<0 || j<0 || i>image.size()-1 || j>image[0].size()-1 || image[i][j]!=val || visited[i][j]==true) return;

        image[i][j]=color;
        visited[i][j]=true;

        dfs(i,j-1,image,visited,val,color) ;
        dfs(i-1,j,image,visited,val,color);
        dfs(i,j+1,image,visited,val,color);
        dfs(i+1,j,image,visited,val,color);
    }
       

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n=image.size();
        int m=image[0].size();
        
     //   vector<vector<int>> arr(n,vector<int>(m)); //sc -> O(N2)
        vector<vector<bool>> visited(n,vector<bool>(m,false)); //sc -> O(N2)

      

        int val=image[sr][sc];

        if(val==color)
    return image;
        
       dfs(sr,sc,image,visited,val,color);

        return image;
    }
};