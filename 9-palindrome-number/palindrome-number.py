class Solution(object):
    def isPalindrome(self, x):
        """
        :type x: int
        :rtype: bool
        """
        st = str(x)
        i=0
        j=len(st)-1

        while i<j:
            if(st[i] != st[j]):
                return False
            i+=1
            j-=1

        return True
