class Solution {
    public int lengthOfLongestSubstring(String s) {
        int max=0;
        int len=0;
        HashSet<Character> set = new HashSet<>();
        int i=0;
        int j=0;
        while(j<s.length())
        {
            while(set.contains(s.charAt(j)))
            {
                set.remove(s.charAt(i));
                i++;
            }
            set.add(s.charAt(j));
            len =j-i+1;
            max=Math.max(max,len);
            j++;
            // if(!set.contains(s.charAt(j)))
            // {
            //     len=j-i+1;
            // }
            // else
            // {
            //     while(set.contains(s.charAt(i)))
            //     {
            //         set.remove(set.get(i));
            //         i++;
            //     }
            //     len=j-i+1;
            // }
            // set.add(s.charAt(j));
            // max=Math.max(max,len);
            // j++;
        }
        return max;
    }
}