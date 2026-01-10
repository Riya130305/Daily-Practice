class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int end=Arrays.stream(piles).max().getAsInt();
        int start=1;

        while(start<=end)
        {
            int mid=start+(end-start)/2;
            if(fun(piles,mid)<=h)
            {
                end=mid-1;
            }
            else
            {
                start=mid+1;
            }

        }
        return start;
    }

    public static int fun(int[]piles,int mid)
    {
        int sum=0;
        for(int i=0;i<piles.length;i++)
        {
            sum+=Math.ceil((double)piles[i]/mid);
        }
        return sum;
    }
}