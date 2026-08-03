class Solution {
public:
    void dfs(int i,int j,vector<vector<int>>& image,int val,int color){
        if(i<0 || j<0 || i>image.size()-1 || j>image[0].size()-1 || image[i][j]!=val) return;

        image[i][j]=color;

        dfs(i,j-1,image,val,color) ;
        dfs(i-1,j,image,val,color);
        dfs(i,j+1,image,val,color);
        dfs(i+1,j,image,val,color);
    }
       

public:
    vector<vector<int>> floodFill(vector<vector<int>>& image, int sr, int sc, int color) {
        int n=image.size();
        int m=image[0].size();
        
     //   vector<vector<int>> arr(n,vector<int>(m)); //sc -> O(N2)
        //vector<vector<bool>> visited(n,vector<bool>(m,false)); //sc -> O(N2)

        int val=image[sr][sc];

        if(val==color)
        return image;
        
       dfs(sr,sc,image,val,color);

        return image;
    }
};