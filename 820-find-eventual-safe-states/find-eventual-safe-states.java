class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //ADj list is given but need to reverse the node so making the adj list again
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] inDegree= new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            for(int edg:graph[i])
            {
                adj.get(edg).add(i);
                inDegree[i]++;
            }
        }


        List<Integer> ans = new ArrayList<>();
        Queue<Integer> q = new LinkedList<>();
        
        for(int i=0;i<graph.length;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        
        while(!q.isEmpty())
        {
            int val=q.poll();
            ans.add(val);
            for(int nbr:adj.get(val))
            {
                // for(int i=0;i<nbr.length;i++)
                // {
                    if(inDegree[nbr]!=0)
                    {
                        inDegree[nbr]--;
                    }
                    if(inDegree[nbr]==0)
                    {
                        q.add(nbr);
                    }
                // }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}