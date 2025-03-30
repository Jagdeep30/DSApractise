class Solution:
    def findMin(self, nums: List[int]) -> int:
        s=0
        e=len(nums)-1
        while(s<e):
            mid = (int)(s+(e-s)/2)
            if nums[mid]>nums[e]:
                s = mid + 1
            elif nums[mid]>=nums[s]:
                e = mid
            else:
                s+=1
        
        return nums[e]