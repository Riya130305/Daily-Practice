class Solution(object):
    def firstUniqChar(self, s):
        """
        :type s: str
        :rtype: int
        """
        dist={}

        for i in s:
            if i in dist:
                dist[i]+=1
            else:
                dist[i]=1

        for i in range(len(s)):
            if dist[s[i]] == 1:
                return i

        return -1