class Solution {
    public int reverseBits(int n) {
        int ans =0;
        for(int i=0;i<32;i++)
        {
            // right shift
            ans<<=1;
            ans |=(n&1);//to takeout the last bit 
            n>>=1;
        }
        return ans;
    }
}