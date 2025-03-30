class Solution:
    def maxProduct(self, nums: List[int]) -> int:
        prod = 1
        ans = -11

        for i in nums:
            prod*=i
            ans = max(ans,prod)
            if prod==0:
                prod = 1

        prod = 1
        for i in nums[::-1]:
            prod*=i
            ans = max(ans,prod)
            if prod==0:
                prod=1
        
        return ans