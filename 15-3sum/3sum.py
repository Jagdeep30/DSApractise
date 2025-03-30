class Solution:
    def threeSum(self, nums: List[int]) -> List[List[int]]:
        nums.sort()
        print(nums)
        ans = []
        n = len(nums)

        i = 0
        while i<n:
            j = i+1
            k = n-1
            while j<k:
                sum = nums[i]+nums[j]+nums[k]
                if sum==0:
                    temp = [nums[i],nums[j],nums[k]]
                    ans.append(temp)
                    j+=1
                    while j<k and nums[j]==nums[j-1]:
                        j+=1
                    k-=1
                    while j<k and nums[k]==nums[k+1]:
                        k-=1
                elif sum<0:
                    j+=1
                    while j<k and nums[j]==nums[j-1]:
                        j+=1
                else:
                    k-=1
                    while j<k and nums[k]==nums[k+1]:
                        k-=1

            i+=1
            while i<n and nums[i]==nums[i-1]:
                i+=1

        return ans