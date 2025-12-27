class Solution {
    public int minArrivalsToDiscard(int[] arr, int w, int m) {
        int cnt = 0;
        Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();

        for (int i = 1; i <= arr.length; i++) {
            int type = arr[i - 1];
            int window = Math.max(1, i - w + 1);

            PriorityQueue<Integer> q = map.computeIfAbsent(type, k -> new PriorityQueue<>());
            while (!q.isEmpty() && q.peek() < window) {
                q.poll();
            }
            if (q.size() < m) {
                q.offer(i);
            } else {
                cnt++;
            }
        }
        return cnt;
    }
}