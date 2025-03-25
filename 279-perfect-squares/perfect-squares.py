# class Solution:
#     def numSquares(self, n: int) -> int:
#         dp = [[0]*(n) for _ in range(n+1)]
#         # print(dp)
#         return self.solve(n, n, dp)

#     def solve(self, n: int, i: int, dp:List[List[int]]) -> int:
#         if n == 0:
#             # print("n==0")
#             return 0
#         if i==1:
#             # print(f"i==1,,n=={n}")
#             return n
#         if i>n or int(i ** 0.5) ** 2 != i:
#             # if dp[n][i] !=0:
#                 # return dp[n][i]
#             res = self.solve(n, i-1, dp)
#             # print(f"i=={i},,n=={n},,res=={res}")
#             return res
#         if n == i:
#             # print("n==i,,n={n}")
#             return 1

#         if dp[n][i] != 0:
#             return dp[n][i]

#         # print(f"n=={n},,i=={i}")
#         mini = float('inf')
#         #choose
#         ##choose same again
#         mini = min(mini,self.solve(n-i, i, dp)+1)
#         ##choose less
#         mini = min(mini,self.solve(n-i, i-1, dp)+1)
#         #not choose
#         mini = min(mini,self.solve(n, i-1, dp))
#         dp[n][i] = mini
#         return mini

from collections import deque

class Solution:
    def numSquares(self, n: int) -> int:
        # Generate all possible perfect squares ≤ n
        squares = [i * i for i in range(1, int(n**0.5) + 1)]
        
        # BFS setup
        queue = deque([(n, 0)])  # (remaining value, steps)
        visited = set()

        while queue:
            remaining, steps = queue.popleft()

            if remaining == 0:
                return steps  # Found the minimum steps

            for square in squares:
                next_val = remaining - square
                if next_val < 0:
                    break  # No need to continue with larger squares
                if next_val not in visited:
                    visited.add(next_val)
                    queue.append((next_val, steps + 1))

        return -1  # Should never reach here
