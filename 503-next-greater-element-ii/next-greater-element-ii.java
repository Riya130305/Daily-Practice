class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n= nums.length;
        int[] arr = new int[n];
        Arrays.fill(arr,-1);
        Stack<Integer> st = new Stack<>();
        st.push(n-1);
        for(int i=2*n-1;i>=0;i--)
        {
           
                while(!st.isEmpty() && nums[i%n]>=nums[st.peek()]){
                    st.pop();
                
            }
            if(!st.isEmpty() ){
                arr[i%n]=nums[st.peek()];
                
            }
            st.push(i%n);
        }

        return arr;
    }
}