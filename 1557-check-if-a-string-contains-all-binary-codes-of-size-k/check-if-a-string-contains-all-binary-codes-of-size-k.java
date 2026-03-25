class Solution {
    public boolean hasAllCodes(String s, int k) {
        // Fixed sized sliding window + HashSet
        int size=(int)Math.pow(2,k);
        HashSet<String> set = new HashSet<>();

        for(int i=k;i<=s.length();i++)
        {
            int start=i-k;
            String st= s.substring(start,k+start);
            if(!set.contains(st))
            {
                set.add(st);
            }
            if(set.size()==size) return true;
            
        }
        return false;
    }
}