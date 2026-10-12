import math
class Solution(object):
    def missingNumber(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        max1 = max(nums)
        list1 = [0] * (max1+1)

        for i in range(len(nums)):
            list1[nums[i]]=1

        for i in range(len(list1)):
            if list1[i] == 0:
                return i
        return max1+1