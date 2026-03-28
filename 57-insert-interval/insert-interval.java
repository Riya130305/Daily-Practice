class Solution {
    public int[][] insert(int[][] in, int[] newInterval) {
        List<int[]> res = new ArrayList<>();
        int i = 0;
        int n = in.length;
        //  add all intervals before overlap
        while (i < n && in[i][1] < newInterval[0]) {
            res.add(in[i]);
            i++;
        }

        // merge overlapping intervals
        while (i < n && in[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], in[i][0]);
            newInterval[1] = Math.max(newInterval[1], in[i][1]);
            i++;
        }
        res.add(newInterval);

        //add remaining intervals
        while (i < n) {
            res.add(in[i]);
            i++;
        }

        return res.toArray(new int[res.size()][]);
    }
}