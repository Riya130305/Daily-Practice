class Solution {
    public int trap(int[] height) {
        int n=height.length;
        int[] leftArr= new int[n];
        int[] rightArr=new int[n];
        int max=0;
        for(int i=0;i<n;i++)
        {
            max=Math.max(max,height[i]);
            leftArr[i]=max;
        }
        max=0;
        for(int i=n-1;i>=0;i--)
        {
            max=Math.max(max,height[i]);
            rightArr[i]=max;
        }
        int min=0;
        for(int i=0;i<n;i++)
        {
            min+=Math.min(leftArr[i],rightArr[i])-height[i];
        }
        return min;
    }
}