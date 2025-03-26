class Solution:
    def twoSum(self, nums: List[int], target: int) -> List[int]:
        mp = {}
        for ind, ele in enumerate(nums):
            # print(mp.get(target-ele))
            sec = mp.get(target-ele)
            if sec is not None:
                return [sec, ind]
            mp[ele] = ind
        # print(mp)
        return []