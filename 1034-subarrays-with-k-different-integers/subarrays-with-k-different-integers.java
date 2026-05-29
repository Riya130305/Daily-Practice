class Solution{
    public int subarraysWithKDistinct(int[] nums, int k){
        return fun(nums,k)-fun(nums,k-1);
}
public int fun(int[] nums, int k){
    int i=0,j=0,count=0;
        HashMap<Integer,Integer> map= new HashMap<>();
        while(j<nums.length){
           map.put(nums[j],map.getOrDefault(nums[j],0)+1);
           while(map.size()>k){
            map.put(nums[i],map.get(nums[i])-1);
            if(map.get(nums[i])==0) map.remove(nums[i]);
            i++;
           }
           if(map.size()<=k) count+=(j-i+1);
           j++;
        }
        return count;
    }
}



// Brute Force solution

// class Solution{
//     public int subarraysWithKDistinct(int[] nums, int k){
//              int count=0;
//         for(int i=0;i<nums.length;i++)
//         {
//             int size=k;
//             HashMap<Integer,Integer> map = new HashMap<>();
//             for(int j=i;j<nums.length;j++)
//             {
//                   map.put(nums[j],map.getOrDefault(nums[j],0)+1);
//                   if(map.size()==k){
//                     count++;
//                 }
//             }  
//         }
//         return count;
//     }
// }


// Brute force solution map

// class Solution {
//     public int subarraysWithKDistinct(int[] nums, int k) {
//        return fun(nums,k)-fun(nums,k-1);
//     }
//     public int fun(int[] nums, int k){
//          int count=0;
//         for(int i=0;i<nums.length;i++)
//         {
//             int size=k;
//             // ArrayList<Integer> arr = new ArrayList<>();
//             HashMap<Integer,Integer> map = new HashMap<>();
//             for(int j=i;j<nums.length;j++)
//             {
//                   map.put(nums[j],map.getOrDefault(nums[j],0)+1);
//                   if(map.size()<=k){
//                     count++;
//                 }
//             }  
//         }
//         return count;
//     }
// }