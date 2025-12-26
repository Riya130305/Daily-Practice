class Solution {
    public long minimumTime(int[] time, int totalTrips) {
        long s=1;
        long e=(long)totalTrips*Arrays.stream(time).min().getAsInt();
        //long ans=0;
        while(s<e)
        {
            long mid=s+(e-s)/2;
            if(fun(time,mid,totalTrips)>=totalTrips)
            {
                // ans=mid;
                e=mid;
            }
            else
            {
                s=mid+1;
            }
        }
        return s;
    }
    public static long fun(int[] time, long mid,int totalTime)
    {
        long sum=0;
        for(int i:time)
        {
            sum+=(mid/i);
        }
        return sum;
    }
}