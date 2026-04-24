class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i=0, j=0,k=0,max=0;
        HashMap<Character,Integer> map = new HashMap<>();
        while(j<s.length()){
            while(map.containsKey(s.charAt(j))){
                map.remove(s.charAt(i));
                i++;
            }
            if(!map.containsKey(s.charAt(j))){
                map.put(s.charAt(j),k+1);
            }
            max=Math.max(max,j-i+1);
            j++;
        }
        return max;
    }
}