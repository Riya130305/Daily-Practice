class Solution {
    public int[][] merge(int[][] intervals) {
        int n=intervals.length;
        int m=intervals[0].length;
        Arrays.sort(intervals,(a,b)->Integer.compare(a[0],b[0]));
        ArrayList<int[]> res = new ArrayList<>();
        if(n==1){
         res.add(new int[]{intervals[0][0],intervals[0][1]});
         return res.toArray(new int[res.size()][]);
        }
        res.add(new int[]{intervals[0][0],intervals[0][1]});
        for(int i=1;i<n;i++)
        {
            int[] temp= res.get(res.size()-1);
            if(temp[1]>=intervals[i][0])
            {
               temp[1] = Math.max(temp[1], intervals[i][1]);
            }
            else
            {
                res.add(new int[]{intervals[i][0],intervals[i][1]});
            }
        }
        return res.toArray(new int[res.size()][]);
    }
}