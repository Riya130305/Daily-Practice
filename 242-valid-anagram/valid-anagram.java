class Solution {
    public boolean isAnagram(String s, String t) {
        int s1=s.length();
        int s2=t.length();
        if(s1!=s2) return false;
        int[] char1 = new int[26];
        int i=0,j=0;
        while(i< s1 && j<s2){
            char1[s.charAt(i)-'a']++;
            char1[t.charAt(j)-'a']--;
            i++;j++;
        }
        for(int k:char1){
            if(k!=0) return false;
        }
        return true;
    }
}