class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();
        //max heap sort on the basis of distance 
        PriorityQueue<int[]>pq= new PriorityQueue<>((a,b)-> {
        if(a[1]==b[1]){
        return b[0]-a[0];
        }
        else{
        return b[1]-a[1];
    }
        }
        );

        for(int i=0;i<arr.length;i++)
        {
            int diff=Math.abs(arr[i]-x);
            pq.offer(new int[]{arr[i],diff});
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        while(pq.size()>0)
        {
            res.add(pq.poll()[0]);
        }
        Collections.sort(res);
        return res;
    }
}