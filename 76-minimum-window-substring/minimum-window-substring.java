class Solution {
    public String minWindow(String s, String t) {
        int i=0, j=0, min=Integer.MAX_VALUE,start=0;
        HashMap<Character,Integer> map= new HashMap<>();

        HashMap<Character,Integer> mapT= new HashMap<>();
        for(char ch : t.toCharArray()) {
            mapT.put(ch, mapT.getOrDefault(ch, 0) + 1);
        }
        int have = 0;
        int required = t.length();

        while(j<s.length()){
            map.put(s.charAt(j),map.getOrDefault(s.charAt(j),0)+1);

           if(mapT.containsKey(s.charAt(j)) && map.get(s.charAt(j)) <= mapT.get(s.charAt(j))){
                have++;
           }

            while(have  == required){

                if(j-i+1 < min){
                    min=j-i+1;
                    start=i;
                }
                map.put(s.charAt(i),map.get(s.charAt(i))-1);

                // requirment break ho gaii
                if(mapT.containsKey(s.charAt(i))&& map.get(s.charAt(i)) < mapT.get(s.charAt(i))){
                    have--;
                }
                if(map.get(s.charAt(i))==0){
                    map.remove(s.charAt(i));
                }
                
                i++;
            }
            j++;
        }

       if(min == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(start, start + min);
    }
}