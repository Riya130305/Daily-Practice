class Solution {
    public int findKthLargest(int[] nums, int k) {
        if(nums.length==0)
        return 0;
        //min
        PriorityQueue<Integer> pq= new PriorityQueue<>();
        pq.offer(nums[0]);
        for(int i=1;i<nums.length;i++)
        {
            pq.offer(nums[i]);
            if(pq.size()>k)
            pq.poll();
        }
        return pq.poll();
    }
}