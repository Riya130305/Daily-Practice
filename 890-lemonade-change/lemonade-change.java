class Solution {
    public boolean lemonadeChange(int[] b) {
        int five=0, ten=0, tt=0;
        for(int i=0;i<b.length;i++)
        {
            if(b[i]==5) five++;
            if(b[i]==10 )
            {
                if(five>0)
                {
                    five--;
                    ten++;
                }
                else
                {
                    return false;
                }
                
            }
            if(b[i]==20)
            {
                if(five>0 && ten>0)
                {
                    five--;
                    ten--;
                }
                else if(five>=3) five-=3;
                
                else return false;
            }
            
        }
        
        return true;
    }
}