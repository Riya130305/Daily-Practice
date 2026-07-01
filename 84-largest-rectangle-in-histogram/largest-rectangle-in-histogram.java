
class Solution {
    public int largestRectangleArea(int[] arr) {
        int n=arr.length;
        int[] nse= new int[n];
        int[] pse= new int[n];

        Arrays.fill(nse,n);
        Arrays.fill(pse,-1);

        ArrayDeque<Integer> st = new ArrayDeque<>();
        st.add(n-1);
        for(int i=n-2;i>=0;i--){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                nse[i] = st.peek();
            }
            st.push(i);
        }

        st.clear();

        st.add(0);
        for(int i=1;i<n;i++){
            while(!st.isEmpty() && arr[st.peek()]>=arr[i]){
                st.pop();
            }
            if(!st.isEmpty()){
                pse[i] = st.peek();
            }
            st.push(i);
        }

        System.out.println(Arrays.toString(nse));
        System.out.println(Arrays.toString(pse));

       int max=0;
        for(int i=0;i<n;i++){
                int width=nse[i]-pse[i]-1;
                int ans=arr[i]*width;
                max=Math.max(ans,max);
            }
        return max;

    }
}