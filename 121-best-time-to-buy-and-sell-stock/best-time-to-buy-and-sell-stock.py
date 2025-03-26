class Solution:
    def maxProfit(self, prices: List[int]) -> int:
        ans = 0
        mx = prices[-1]
        for ele in prices[::-1]:
            ans = max(ans, mx-ele)
            mx = max(mx,ele)

        return ans
        