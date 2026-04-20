class Solution {
    public int[] dailyTemperatures(int[] temp) {
        int n=temp.length;
        int[] arr=new int[n];

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.push(n-1);
        for(int i=n-1;i>=0;i--)
        {
            while(!st.isEmpty() && temp[st.peek()]<=temp[i]){
                st.pop();
            }
            if(!st.isEmpty() && temp[st.peek()]>=temp[i]){
                // System.out.println("i-->"+i+" temp-->"+temp[i]+" "+Math.abs(st.peek()-i));
                arr[i]=Math.abs(st.peek()-i);
            }
            st.push(i);
        }
        return arr; 
    }
}