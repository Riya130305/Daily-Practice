class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        //  2-D array
        // int m=text1.length();
        // int n=text2.length();
        // int[][]dp = new int[m+1][n+1];

        // for(int i=1;i<=m;i++)
        // {
        //     for(int j=1;j<=n;j++)
        //     {
        //         if(text1.charAt(i-1)==text2.charAt(j-1))
        //         {
        //             dp[i][j]=dp[i-1][j-1]+1;
        //         }
        //         else
        //         {
        //             dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
        //         }
        //     }
        // }
        // return dp[m][n];

        //2 1-D array

        int m= text1.length();
        int n=text2.length();

        int[]dp=new int[n+1];
        for(int i=1;i<=m;i++)
        {
             int temp[]=new int[n+1];
            for(int j=1;j<=n;j++)
            {
                if(text1.charAt(i-1)==text2.charAt(j-1))
                {
                    temp[j]=dp[j-1]+1;
                }
                else
                {
                    temp[j]=Math.max(dp[j],temp[j-1]);
                }    
            }
            dp=temp;
        }
        return dp[n];
    }
}