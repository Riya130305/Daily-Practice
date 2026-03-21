class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
       
        int m=g.length,i=0,j=0;
        int n=s.length,count=0;
        while(i<m && j<n)
        {
            if(s[j]>=g[i])
            {
                i++;
                count++;
            }
            j++;
        }
        return count;
    }
}