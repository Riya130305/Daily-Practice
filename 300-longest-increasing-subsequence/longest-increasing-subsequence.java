class Solution {
    public int lengthOfLIS(int[] nums) {
    //    int n=nums.length;
    //    int[] dp=new int[n];
    //    Arrays.fill(dp,1);
      
    //    for(int i=1;i<n;i++){
    //         for(int j=0;j<i;j++){
    //             if(nums[i]>nums[j]){
    //                 dp[i] = Math.max(dp[i], dp[j] + 1);
    //             }
    //         }
    //     } 
    //     int max=-1;
    //     //Returing the max value from the dp array
    //     for(int i=0;i<n;i++){
    //         max=Math.max(max,dp[i]);
    //     }
    //     return max;
    // }

    // PRINTING THE ARRAY OF LIS
    int n=nums.length;
    int[] dp =new int[n];
    int[] parent=new int[n];
    Arrays.fill(dp,1);
    for(int i=0;i<n;i++)
    {
        parent[i]=i;
    }

    for(int i=1;i<n;i++)
    {
        for(int j=0;j<i;j++)
        {
            if(nums[i]>nums[j])
            {
                if(dp[i]<dp[j]+1)
                {
                    dp[i]=dp[j]+1;
                    parent[i]=j;
                }
            }
        }

    }
    //finding the max value
    int max=-1;
    int lastIdx=-1;
    for(int i=0;i<n;i++)
    {
        if(dp[i]>max)
        {
            max=dp[i];
            //strong the large element
            lastIdx=i;
        }
    }
    ArrayList<Integer> arr = new ArrayList<>();
    arr.add(nums[lastIdx]);
    while(parent[lastIdx]!=lastIdx)
    {
        arr.add(nums[parent[lastIdx]]);
        lastIdx=parent[lastIdx];
    }
    Collections.reverse(arr);
    System.out.println(arr);
    return max;
    }
}