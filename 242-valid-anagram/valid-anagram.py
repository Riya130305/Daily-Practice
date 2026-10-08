class Solution(object):
    def isAnagram(self, s, t):
        """
        :type s: str
        :type t: str
        :rtype: bool
        """
        if(len(s)!=len(t)):
            return False

        dist1={}
        dist2={}

        for i in s:
            if i in dist1:
                dist1[i] +=1
            else:
                dist1[i] = 1

        for i in t:
            if i in dist2:
                dist2[i] +=1
            else:
                dist2[i] = 1
        
        if(dist1 ==  dist2):
            return True
        return False
