class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        Queue<Integer> q= new LinkedList<>(); 
        int[] dis= new int[numCourses];
        ArrayList<ArrayList<Integer>> adj= new ArrayList<>(); 
        for(int i=0;i<numCourses;i++) 
        { 
            adj.add(new ArrayList<Integer>()); 
        } 
        for(int[] edg:prerequisites) { 
            int u=edg[0]; 
            int v=edg[1]; 
            adj.get(v).add(u); 
            dis[u]++;
        }

        for(int i=0;i<numCourses;i++)
        {
            if(dis[i]==0)
            {
                q.add(i);
            }
        }

        while(!q.isEmpty())
        {
            int val=q.poll();
            for(int edg:adj.get(val))
            {
                if(dis[edg]!=0)
                {
                    dis[edg]--;
                }
                if(dis[edg]==0)
                {
                    q.add(edg);
                }
            }
        }
        for(int i=0;i<dis.length;i++)
        {
            if(dis[i]!=0)
            {
                return false;
            }
        }
        return true;

    }
}