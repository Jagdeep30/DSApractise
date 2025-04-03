class Solution:
    def countBits(self, n: int) -> List[int]:
        ans = []
        ans.append(0)
        for i in range(1,n+1):
            if i%2==0:
                ans.append(ans[int(i/2)])
            else:
                ans.append(ans[int(i/2)]+1)

        return ans