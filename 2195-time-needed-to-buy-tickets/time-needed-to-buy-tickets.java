class Solution {
    public int timeRequiredToBuy(int[] arr, int k) {
        Queue<Integer> q = new LinkedList<>();
        int n=arr.length;
        int count=0;
        for(int i=0;i<n;i++)
        {
            q.add(i);
        }
        while(q.size()>0)
        {
            int val=q.poll();
            count++;
            arr[val]--;
            if(arr[val]>0)
            {
                q.add(val);
            }
            else if(val==k)
            {
                return count;
            }

        }
        return count;
    }
}