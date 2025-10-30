class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        fun(candidates,target,ans,path,0);
        return ans;
    }
     public static void fun(int[] candidates,int target,List<List<Integer>> arr,List<Integer> path,int idx)
    {
        // base caseif(t)
        if(target==0)
        {
            arr.add(new ArrayList<>(path));
            return;
        }
        if(target<0)
        return;
        for(int i=idx;i<candidates.length;i++)
        {
            if(i>idx && candidates[i]==candidates[i-1])
            {
                continue;
            }
            path.add(candidates[i]);
            fun(candidates, target -candidates[i], arr, path, i+1);
            path.remove(path.size()-1);
            
        }
    }
   
}