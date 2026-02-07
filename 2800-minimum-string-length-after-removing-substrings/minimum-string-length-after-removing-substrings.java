import java.util.ArrayList;

class Solution {
    public int minLength(String s) {
        ArrayList<Character> arr = new ArrayList<>();
        for (char c : s.toCharArray()) {
            arr.add(c);
        }

        int i = 0;
        while (i < arr.size() - 1) { 
            char current = arr.get(i);
            char next = arr.get(i + 1);

            if ((current == 'A' && next == 'B') || (current == 'C' && next == 'D')) {
                
                arr.remove(i + 1);
                arr.remove(i);
               
                i = Math.max(0, i - 1); 
            } else {
                
                i++;
            }
        }
        return arr.size();
    }
}