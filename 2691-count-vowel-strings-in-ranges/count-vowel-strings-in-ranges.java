class Solution {
    public int[] vowelStrings(String[] words, int[][] queries) {

        int n = words.length;
        int[] prefix = new int[n];
        for (int i=0; i<n; i++) {
            String s = words[i];

            boolean isValid = isVowel(s.charAt(0)) && isVowel(s.charAt(s.length() - 1));
            if (i==0) {
                prefix[i]= isValid ? 1 : 0;
            } else {
                prefix[i]= prefix[i -1] + (isValid ? 1 : 0);
            }
        }
        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int l = queries[i][0];
            int r = queries[i][1];

            if (l == 0) {
                ans[i] = prefix[r];
            } else {
                ans[i] = prefix[r] - prefix[l - 1];
            }
        }

        return ans;
    }

    private boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
}