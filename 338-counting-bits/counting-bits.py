class Solution:
    def countBits(self, n: int) -> List[int]:
        ans = []
        # ans.append(0)
        for i in range(n+1):
            ans.append(i.bit_count())
            # if i%2==0:
            #     ans.append(ans[int(i/2)])
            # else:
            #     ans.append(ans[int(i/2)]+1)

        # return ans

        #  output = []

        # for num in range(n+1):
        #     ans.append(num.bit_count())

        return ans