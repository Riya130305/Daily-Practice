class Solution {
    public int findCircleNum(int[][] isConnected) {
        int n=isConnected.length;
        //ADJ LIST
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {
            int j=0;
            for(int edg:isConnected[i])
            {
                if(edg==1)
                {
                    adj.get(i).add(j);
                }
                j++;
            }
        }
        int count=0;
        boolean[] visited= new boolean[n];
        for(int i=0;i<n;i++)
        {
            if(!visited[i])
            {
                count++;
                dfs(adj,i,visited);
            }
        }
        return count;

    }
    public void dfs(ArrayList<ArrayList<Integer>> adj,int node,boolean[] visited)
    {
        visited[node]=true;
        for(int nbr:adj.get(node))
        {
                if(!visited[nbr])
                {
                    dfs(adj,nbr,visited);
                }
            
        }
    }
}