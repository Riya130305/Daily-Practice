class Solution {
    public boolean isAnagram(String s, String t) {
        int i=0;
        int[] char1= new int[26];
        if(s.length()!=t.length()) return false;

        for(i=0;i<s.length();i++){
            char1[s.charAt(i)-'a']++;
            char1[t.charAt(i)-'a']--;

        }
        for(int j: char1){
            if(j!=0){
                return false;
            }
        }
        return true;
    }
}