class Solution:
    def maxSubArray(self, nums: List[int]) -> int:
        sum = 0
        ans = -sys.maxsize - 1
        for i in nums:
            sum += i
            ans = max(ans,sum)
            if sum<0:
                sum=0
        
        return ans