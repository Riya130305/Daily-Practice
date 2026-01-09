class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        //ADj list is given but need to reverse the node so making the adj list again (TOPO+BFS)
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0;i<graph.length;i++)
        {
            adj.add(new ArrayList<>());
        }
        int[] inDegree= new int[graph.length];
        for(int i=0;i<graph.length;i++)
        {
            for(int edg:graph[i])//graph[i][0], graph[i][1]....
            {
                adj.get(edg).add(i);
                inDegree[i]++;//eg->0 per kitni inDegree hai
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
            for(int nbr:adj.get(val))//as adj mai humari reverse values hai
            {
                if(inDegree[nbr]!=0)
                {
                    inDegree[nbr]--;
                }
                if(inDegree[nbr]==0)
                {
                    q.add(nbr);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}