class Solution:
    def productExceptSelf(self, nums: List[int]) -> List[int]:
        larr = [1]
        rarr = [1]
        for i,v in enumerate(nums):
            if i==0:
                continue
            
            larr.append(larr[i-1] * nums[i-1])
        # print(nums)
        nums.reverse()
        # print(nums)
        for i,v in enumerate(nums):
            if i==0:
                continue
            
            rarr.append(rarr[i-1] * nums[i-1])

        rarr.reverse()

        # print(larr)
        # print(rarr)

        ans = [larr[i]*rarr[i] for i in range(0,len(nums))]
        return ans