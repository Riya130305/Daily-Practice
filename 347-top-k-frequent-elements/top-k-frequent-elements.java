class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        int[] arr = new int[k];
        //min heap
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i:nums)
        {
            map.put(i,map.getOrDefault(i,0)+1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->map.get(a)-map.get(b));

        for(int val:map.keySet())
        {
           // pq.offer(new int[]{nums[i],map.get(nums[i])});
            pq.add(val);
            if(pq.size()>k)
            {
                pq.poll();
            }
        }
        int i=0;
        while(pq.size()>0)
        {
            arr[i]=pq.poll();
            i++;
        }
        return arr;
    }
}