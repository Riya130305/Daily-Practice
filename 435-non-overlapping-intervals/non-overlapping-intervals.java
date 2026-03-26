class Solution {
    public int eraseOverlapIntervals(int[][] arr) {
        // Sort on the basic of ending intervals;
        Arrays.sort(arr,(a,b)->Integer.compare(
            a[1],b[1]
        ));
        int remove=0;
        int end=arr[0][1];
        for(int i=1;i<arr.length;i++)
        {
            if(end<=arr[i][0]) end=arr[i][1];

            else remove++;
        }
        return remove;
    }
}