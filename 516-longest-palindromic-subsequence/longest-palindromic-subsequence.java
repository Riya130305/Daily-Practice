class Solution {
    public int longestPalindromeSubseq(String s) {
        StringBuilder sb = new StringBuilder(s);
        String r=sb.reverse().toString();
        int m=s.length();
        int[][]dp = new int[m+1][m+1];
        for(int i=1;i<=m;i++)
        {
            for(int j=1;j<=m;j++)
            {
                if(r.charAt(i-1)==s.charAt(j-1))
                {
                    dp[i][j]=dp[i-1][j-1]+1;
                }
                else
                {
                    dp[i][j]=Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[m][m];
    }
}