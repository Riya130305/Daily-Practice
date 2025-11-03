// //Using Recursion(TLE)
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int ans=sol(word1,word2,0);
//         return ans;
//     }
//     public static int sol(String s1,String s2,int cnt){
//         if(s1.length()==0 && s2.length()!=0){
//             return s2.length();
//         }
//         if(s2.length()==0 && s1.length()!=0){
//             return s1.length();
//         }
//         if(s1.length()==0 && s2.length()==0){
//             return 0;
//         }

//         char ch1=s1.charAt(0);
//         char ch2=s2.charAt(0);
//         if(ch1==ch2){
//             return sol(s1.substring(1),s2.substring(1),cnt);
//         }
//         else{
//             int insert=sol(s1,s2.substring(1),cnt+1);
//             int replace=sol(s1.substring(1),s2.substring(1),cnt+1);
//             int del=sol(s1.substring(1),s2,cnt+1);
//             return Math.min(del,Math.min(replace,insert))+1;
//         }

//     }
// }


// //Top down
// class Solution {
//     public int minDistance(String word1, String word2) {
//         int ans=sol(word1,word2,new int[word1.length()][word2.length()]);
//         return ans;
//     }
//     public static int sol(String s1,String s2,int[][]dp){
//         if(s1.length()!=0&& s2.length()==0) return s1.length();
//         if(s1.length()==0&& s2.length()!=0) return s2.length();
//         if(s1.length()==0 && s2.length()==0) return 0;
//         if(dp[s1.length()-1][s2.length()-1]!=0) return dp[s1.length()-1][s2.length()-1];
//         char c1=s1.charAt(0);
//         char c2=s2.charAt(0);
//         if(c1==c2){
//             return dp[s1.length()-1][s2.length()-1]=sol(s1.substring(1),s2.substring(1),dp);
//         }
//         else{
//             int in=sol(s1,s2.substring(1),dp);
//             int rep=sol(s1.substring(1),s2.substring(1),dp);
//             int del=sol(s1.substring(1),s2,dp);
//             return dp[s1.length()-1][s2.length()-1]= Math.min(in,Math.min(rep,del))+1;
//         }
//     }
// }


//Bottom up
class Solution {
    public int minDistance(String word1, String word2) {
        return sol(word1,word2);
    }
    public static int sol(String s1,String s2){
        int[][] dp=new int[s1.length()+1][s2.length()+1];
        for(int col=0;col<dp[0].length-1;col++){
            dp[dp.length-1][col]=s2.length()-col;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][dp[0].length-1]=s1.length()-i;
        }
        for(int row=s1.length()-1;row>=0;row--){
            for(int col=s2.length()-1;col>=0;col--){
                if(s1.charAt(row)==s2.charAt(col)){
                    dp[row][col]=dp[row+1][col+1];
                }
                else{
                    dp[row][col]=Math.min(dp[row+1][col+1],Math.min(dp[row][col+1],dp[row+1][col]))+1;
                }
            }
        }
        return dp[0][0];
    }
}