import math
class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max1=max(nums)

        nums.sort()

        for i in range(max1):
            if nums[i] != i:
                return i
        return max1+1