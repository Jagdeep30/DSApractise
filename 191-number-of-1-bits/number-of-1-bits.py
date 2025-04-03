class Solution:
    def hammingWeight(self, n: int) -> int:
        num = bin(n)
        ans = 0
        for i in num:
            if i=='1':
                ans+=1
        return ans