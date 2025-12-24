class Solution {
    public boolean closeStrings(String word1, String word2) {

        if (word1.length()!=word2.length())
            return false;

        HashMap<Character, Integer> map1 = new HashMap<>();
        HashMap<Character, Integer> map2 = new HashMap<>();

        for (char c:word1.toCharArray())
        {
            map1.put(c, map1.getOrDefault(c, 0)+1);
        }

        for (char c:word2.toCharArray()) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        if(!map1.keySet().equals(map2.keySet()))
            return false;
        List<Integer> f1 = new ArrayList<>(map1.values());
        List<Integer> f2 = new ArrayList<>(map2.values());

        Collections.sort(f1);
        Collections.sort(f2);

        return f1.equals(f2);
    }
}
