class Solution:
    def coinChange(self, coins: List[int], amount: int) -> int:
        # dp = [[-1]*(amount+1)]*(len(coins))
        dp = [[-1]*(amount+1) for _ in range(len(coins))]
        coins.sort()
        # print(coins)
        # print(dp)
        res = self.solve(0, coins, amount, dp)
        # print(dp)
        return res if res!=100000 else -1

    def solve(self, i: int, coins: List[int], amount: int, dp: list[list[int]]):
        #base case
        if amount == 0:
            return 0
        if i==len(coins)-1:
            if amount%coins[-1] == 0:
                return int(amount/coins[-1])
            return -1
        # if i<0 or amount<0:
        #     return -1

        # print(amount)
        if dp[i][amount] != -1:
            return dp[i][amount]


        res = self.solve(i, coins, amount - coins[i], dp) + 1 if amount-coins[i]>=0 else 100000
        res2 = self.solve(i+1, coins, amount, dp)
        if res2==-1:
            res2 = 100000
        # if res == -1 and res2 == -1:
        #     return -1
        # elif res != -1 and res2 != -1:
        #     dp[i][amount] =  min(res + 1, res2)
        # elif res != -1:
        #     dp[i][amount] =  res + 1
        # else: 
        #     dp[i][amount] = res2
        dp[i][amount] = min(res, res2)
        return dp[i][amount]

        