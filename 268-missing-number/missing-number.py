class Solution:
    def missingNumber(self, nums: List[int]) -> int:
        xor = 0
        n = len(nums)
        for i in range(n+1):
            xor^=i
        for i in nums:
            xor^=i
        return xor