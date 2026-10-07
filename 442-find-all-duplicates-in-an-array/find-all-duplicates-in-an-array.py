class Solution(object):
    def findDuplicates(self, nums):
        """
        :type nums: List[int]
        :rtype: List[int]
        """
        dup=[]
        # count=0
        idx=0
        dist={}

        for i in nums:
            if(i in dist):
                dup.append(i)
            else:
                dist[i] = 1
        return dup        
        