class Solution:
    def findMin(self, nums: List[int]) -> int:
        s = 0
        e = len(nums)-1
        ans = 50001

        while(s<=e):
            mid = (int)(s+(e-s)/2)

            if nums[s]<=nums[e]:
                ans = min(ans,nums[s])
                break
            elif nums[s]<=nums[mid]:
                ans = min(ans,nums[s])
                s = mid + 1
            else:
                ans = min(ans,nums[mid])
                e = mid - 1
        return ans