class Solution {
    public int lengthOfLongestSubstring(String s) {

        int max=0;
        for(int i=0;i<s.length();i++){
            HashMap<Character, Integer> map = new HashMap<>();
            map.put(s.charAt(i),i);
            for(int j=i+1;j<s.length();j++){
                if(map.containsKey(s.charAt(j))){
                    //max=Math.max(map.size(),max);
                    break;
                }
                else{
                map.put(s.charAt(j),j);
                }
            }
                max=Math.max(map.size(),max);
        }
        return max;
    }
}