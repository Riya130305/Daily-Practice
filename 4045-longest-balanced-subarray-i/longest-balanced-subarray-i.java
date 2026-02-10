class Solution {
    public int longestBalanced(int[] nums) {
    int n=nums.length;    
    int max=0;
    for(int i=0;i<n;i++){
    HashSet<Integer> s1= new HashSet<>();
    HashSet<Integer> s2= new HashSet<>();
  
    for(int j=i;j<n;j++)
    {
        if(nums[j]%2==0)
        {
            s1.add(nums[j]);
        }
        else
        {
            s2.add(nums[j]);
        }
        if(s1.size()==s2.size())
        {
            max=Math.max(max,j-i+1);
        }
        
    }
    }
    return max;

    }
}