class Solution:
    def getSum(self, a: int, b: int) -> int:
        MASK = 0xFFFFFFFF  # Mask to get last 32 bits
        MAX_INT = 0x7FFFFFFF  # Max positive 32-bit integer

        x = a & MASK
        y = b & MASK

        while y != 0:
            car = (x & y) << 1
            x = x ^ y
            y = car & MASK  # Ensure it remains 32-bit

        # Convert to a signed integer if the result exceeds MAX_INT
        return x if x <= MAX_INT else ~(x ^ MASK)
        # return b==0? a:getSum(a^b, (a&b)<<1);
        # aa = bin(a)[2:]
        # bb = bin(b)[2:]

        # i = len(aa)-1
        # j = len(bb)-1

        # carry = 0

        # ans = ''
        # one = False
        # two = False

        # while i>=0 and j>=0:
        #     if aa[i] == '1':
        #         one = True
        #     else:
        #         one = False
        #     if bb[j] == '1':
        #         two = True
        #     else:
        #         two = False

        #     if not one and not two:
        #         if carry:
        #             ans = '1' + ans
        #         else:
        #             ans = '0' + ans
        #         carry = 0
        #     elif one and two:
        #         if carry:
        #             ans = '1' + ans
        #         else:
        #             ans = '0' + ans
        #         carry = 1
        #     else:
        #         if carry:
        #             ans = '0' + ans
        #         else:
        #             ans = '1' + ans
        #     i-=1
        #     j-=1

        # while i>=0:
        #     if aa[i] == '1':
        #         one = True
        #     else:
        #         one = False
        #     if not one:
        #         if carry:
        #             ans = '1' + ans
        #         else:
        #             ans = '0' + ans
        #         carry = 0
        #     else:
        #         if carry:
        #             ans = '0' + ans
        #         else:
        #             ans = '1' + ans
        #     i-=1

        # while j>=0:
        #     if bb[j] == '1':
        #         two = True
        #     else:
        #         two = False
        #     if not two:
        #         if carry:
        #             ans = '1' + ans
        #         else:
        #             ans = '0' + ans
        #         carry = 0
        #     else:
        #         if carry:
        #             ans = '0' + ans
        #         else:
        #             ans = '1' + ans
        #     j-=1

        # if carry:
        #     ans = '1' + ans

        # return int(ans, 2)