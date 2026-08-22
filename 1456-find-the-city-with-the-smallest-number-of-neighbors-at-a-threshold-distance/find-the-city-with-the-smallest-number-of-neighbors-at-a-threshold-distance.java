class Solution {
    public int min=Integer.MAX_VALUE;
    public int ans=-1;

    public void dijistra(int n,int i, List<List<int[]>> adj,int[] dis,int distanceThreshold){
        dis[i]=0;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));

        pq.add(new int[]{0,i});

        while(!pq.isEmpty()){

            int[] arr = pq.poll();
            int w=arr[0];
            int node=arr[1];

            for(int[] nbr: adj.get(node)){
                int newNode= nbr[0];
                int wt = nbr[1];

                if(dis[newNode] > wt+w){
                    if(wt+w <=distanceThreshold){
                        dis[newNode]=wt+w;
                        pq.add(new int[]{dis[newNode],newNode});
                    }
                }
            }
                  }
    }
    public int findTheCity(int n, int[][] edges, int distanceThreshold) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edg:edges){
            int u=edg[0];
            int v=edg[1];
            int w=edg[2];

            adj.get(u).add(new int[]{v,w});
            adj.get(v).add(new int[]{u,w});

        }

        for(int i=0;i<n;i++){
            int[] dis= new int[n];
            Arrays.fill(dis,Integer.MAX_VALUE);
            
            dijistra(n,i,adj,dis,distanceThreshold);

            int cityCount=0;

            for(int j=0;j<n;j++){
                if(j != i  && dis[j]!=Integer.MAX_VALUE){
                    cityCount++;
                }
            }

            if(cityCount <= min){
                min=cityCount;
                ans=i;
            }
        }
        
        return ans;
    }
}