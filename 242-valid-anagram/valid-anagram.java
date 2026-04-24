class Solution {
    public boolean isAnagram(String s, String t) {
        int s1=s.length();
        int s2=t.length();
        if(s1!=s2) return false;
        HashMap<Character,Integer> map1= new HashMap<>();
        HashMap<Character,Integer> map2= new HashMap<>();
        int i=0,j=0,c1=1,c2=1;
        while(i<s1 && j<s2){
            map1.put(s.charAt(i), map1.getOrDefault(s.charAt(i), 0) + 1);
            map2.put(t.charAt(j), map2.getOrDefault(t.charAt(j), 0) + 1);
            i++;
            j++;
        }
        if(map1.equals(map2)) return true;
        return false;
    
    }
}