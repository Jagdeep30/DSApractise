class Solution:
    def dailyTemperatures(self, temperatures: List[int]) -> List[int]:
        ans = []
        # ans.append(0)
        stack = []
        temperatures.reverse()
        # stack.append((0, temperatures[0]))
        for ele in enumerate(temperatures):
            while stack and stack[0][1] <= ele[1]:
                stack.pop(0)
            
            # print(ele[1])
            # print(stack)
            if stack:
                ans.insert(0, ele[0] - stack[0][0])
            else:
                ans.insert(0,0)
            
            stack.insert(0, ele)
        
        return ans