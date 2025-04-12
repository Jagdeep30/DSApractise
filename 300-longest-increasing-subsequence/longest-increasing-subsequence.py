class Solution:
    def lengthOfLIS(self, nums: List[int]) -> int:
        dp = []
        length = 0
        for i in nums:
            if length==0:
                length+=1
                dp.append(i)
                continue
            ind = self.bs(dp, i)
            if ind==length:
                length+=1
                dp.append(i)
            else:
                dp[ind] = i
        
        return length
    
    def bs(self, dp, target):
        s = 0
        e = len(dp)
        while s<e:
            mid = s+(int((e-s)/2))
            if dp[mid]>=target:
                e = mid
            else:
                s = mid + 1

        return e