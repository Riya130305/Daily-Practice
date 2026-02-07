class Solution {
    public int minimumDeletions(String s) {
        Stack<Character> st = new Stack<>();
        int count=0;
        for(char i:s.toCharArray())
        {
            if(i=='b')
            {
                st.push(i);
            }
            else if(i=='a' && !st.isEmpty())
            {
                count++;
                st.pop();
            }
        }
        return count;
    }
}