class Solution {
    public int countPaths(int n, int[][] roads) {
        int mod=1000000007;
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edg: roads){
            int u=edg[0];
            int v=edg[1];
            int wt=edg[2];

            adj.get(u).add(new int[]{v,wt});
            adj.get(v).add(new int[]{u,wt});
        }


        
        PriorityQueue<long[]> pq=new PriorityQueue<>((a,b)->Long.compare(a[0],b[0]));
        long[] dis= new long[n];
        int[] pathCount= new int[n];

        Arrays.fill(dis,Long.MAX_VALUE);
        dis[0]=0;
        pathCount[0]=1;
        pq.add(new long[]{0,0});

        while(!pq.isEmpty()){
            long[] arr = pq.poll();
            long wt=arr[0];
            int node=(int)arr[1];

            for(int[] nbr: adj.get(node)){
                int newNode=nbr[0];
                long w=(long)nbr[1];

                if(dis[newNode] > w+wt){
                    dis[newNode] = wt+w;
                    pq.add(new long[]{dis[newNode],newNode});
                    pathCount[newNode]=pathCount[node];
                }
                else if(dis[newNode] == w+wt){
                    pathCount[newNode]=(pathCount[newNode] + pathCount[node])%mod;
                }
            }
        } 
        return pathCount[n-1];
    }
}