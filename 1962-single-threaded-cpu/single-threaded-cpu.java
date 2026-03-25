import java.util.*;

class Solution {
    public int[] getOrder(int[][] t) {
        int n = t.length;
        int[] ans = new int[n];
        int j = 0;

        int[][] arr = new int[n][3];

        // {enqueueTime, processingTime, index}
        for (int i = 0; i < n; i++) {
            arr[i][0] = t[i][0];
            arr[i][1] = t[i][1];
            arr[i][2] = i;
        }

        // Sort by enqueueTime
        Arrays.sort(arr, (a, b) -> Integer.compare(a[0], b[0]));

        // Min-Heap: {processingTime, index}
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> {
            if (a[0] == b[0]) return a[1] - b[1];
            return a[0] - b[0];
        });

        int i = 0;
        long timer = 0;

        while (i < n || !pq.isEmpty()) {

            // If no task available, jump time
            if (pq.isEmpty()) {
                timer = Math.max(timer, arr[i][0]);
            }

            // Add all available tasks
            while (i < n && arr[i][0] <= timer) {
                pq.add(new int[]{arr[i][1], arr[i][2]});
                i++;
            }

            // Process the shortest job
            int[] curr = pq.poll();
            ans[j++] = curr[1];
            timer += curr[0];
        }

        return ans;
    }
}