class Solution:
    dp: list
    def climbStairs(self, n: int) -> int:
        self.dp = [-1]*(n+1)
        return self.solve(n)

    def solve(self, i: int):
        if i<=2:
            return i

        if self.dp[i] != -1:
            return self.dp[i]

        res = self.solve(i-1) + self.solve(i-2)
        self.dp[i] = res
        return res