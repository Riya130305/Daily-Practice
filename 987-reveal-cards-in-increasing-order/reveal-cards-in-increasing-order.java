class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        // USED DEQUE O(1)
        Deque<Integer> dq = new ArrayDeque<>();
        int n=deck.length;
        int[] ans = new int[n];
        Arrays.sort(deck);
        dq.addFirst(deck[n-1]);//17
        for(int i=deck.length-2;i>=0;i--)
        {
            if(!dq.isEmpty())
            {
                int val=dq.pollLast();
                dq.addFirst(val);
                dq.addFirst(deck[i]);
            }
        }
        for(int i=0;i<n;i++)
        {
            ans[i]=dq.pollFirst();
        }
        return ans;
    }
}