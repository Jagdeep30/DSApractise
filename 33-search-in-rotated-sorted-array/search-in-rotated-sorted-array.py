class Solution:
    def search(self, nums: List[int], target: int) -> int:
        s = 0
        e = len(nums)-1

        while(s<e):
            mid = (int)(s+(e-s)/2)

            if nums[mid]==target:
                return mid
            
            if nums[mid]>=nums[0]:
                if target>=nums[0]:
                    if target<nums[mid]:
                        e = mid
                    else:
                        s = mid + 1
                else:
                    s = mid + 1
            else:
                if target>=nums[0]:
                    e = mid
                else:
                    if target<nums[mid]:
                        e = mid
                    else:
                        s = mid + 1
        
        if nums[e]==target:
            return e
        return -1