class Solution {
    public int orangesRotting(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        //int count=0;
        int freshOrg=0;
        //int[][] visited= new int[n][m];
        Queue<int[]> q= new LinkedList<>();

        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(grid[i][j]==2)
                {
                    q.add(new int[]{i,j,0});
                }
                else if(grid[i][j]==1)
                {
                    freshOrg++;
                }
            }
        }
        return bfs(grid,n,m,freshOrg,q);
    }
    public static int bfs(int[][] grid,int n, int m,int freshOrg,Queue<int[]>q)
    {
        int[] row={0,-1,0,1};
        int[] col={-1,0,1,0};
        int maxTime=0;
        
        while(!q.isEmpty())
        {
            int[] val=q.poll();
            int u=val[0];
            int v=val[1];
            int wt=val[2];
            maxTime=Math.max(maxTime,wt);
            for(int k=0;k<4;k++)
            {
                int nrow=u+row[k];
                int ncol=v+col[k];

                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && grid[nrow][ncol]==1)
                {
                    freshOrg--;
                    grid[nrow][ncol]=2;
                    q.add(new int[]{nrow,ncol,wt+1});
                }
            }
        }
        return freshOrg==0 ? maxTime : -1;
    }
}