class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int [] edg:times){
            int u=edg[0];
            int v=edg[1];
            int wt=edg[2];

            adj.get(u).add(new int[]{v,wt});
        }

        int[] dis= new int[n+1];
        PriorityQueue<int[]> q = new PriorityQueue<>(
    (a, b) -> a[1] - b[1]
);


        Arrays.fill(dis,Integer.MAX_VALUE);
        q.add(new int[]{k,0});
        dis[k]=0;

        while(!q.isEmpty()){
            //int size=q.size();

           
                int[] arr = q.poll();
                //q.pop();

                int node=arr[0];
                int wt=arr[1];

                for(int[] nbr:adj.get(node)){
                    int newNode=nbr[0];
                    int w=nbr[1];

                    if(dis[newNode] > wt+w){
                        dis[newNode]=wt+w;
                        q.add(new int[]{newNode,dis[newNode]});
                    }
                }
            
        }

        int max=0;
        for(int i=1;i<=n;i++){
            if(dis[i]==Integer.MAX_VALUE) return -1;
            max=Math.max(max,dis[i]);
        }
        return max;
    }
}