class Solution {
    public int totalWaviness(int num1, int num2) {
        int count=0;

        for(int a=num1;a<=num2;a++){
            String s= String.valueOf(a);
            for(int i=1;i<s.length()-1;i++){
                if(s.charAt(i)> s.charAt(i-1) && s.charAt(i)>s.charAt(i+1)||(s.charAt(i)< s.charAt(i-1) && s.charAt(i)<s.charAt(i+1))){
                    count++;
                }
            }
        }
        return count;
    }
}