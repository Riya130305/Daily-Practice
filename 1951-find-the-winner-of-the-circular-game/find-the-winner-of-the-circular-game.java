class Solution {
    public int findTheWinner(int n, int k) {
        Queue<Integer> q = new LinkedList<>();

        for(int i=1;i<=n;i++)
        {
            q.add(i);
        }
        int count=1;
        while(q.size()>1)
        {
          int val = q.poll();
           if(count%k!=0)
           {
              q.add(val);
           }
            count++;
            if(q.size()==1)
            {
                return q.poll();
            }
        }
        return q.poll();
    }
}