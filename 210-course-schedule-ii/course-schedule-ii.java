class Solution {
   public static int[] findOrder(int n, int[][] array)
    {
        int[] ans = new int[n];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();

        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }

        int[] inDegree= new int[n];
        Queue<Integer> q= new LinkedList<>();

        for(int edg[]:array)
        {
            int u=edg[1];
            int v=edg[0];
            adj.get(u).add(v);
            inDegree[v]++;
        }

        for(int i=0;i<n;i++)
        {
            if(inDegree[i]==0)
            {
                q.add(i);
            }
        }
        int i=0;
        while(!q.isEmpty())
        {
            int val=q.poll();
            ans[i++]=val;
            for(int nbr:adj.get(val)){
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
        if(i!=ans.length)
        return new int[0];
        return ans;
   }
}