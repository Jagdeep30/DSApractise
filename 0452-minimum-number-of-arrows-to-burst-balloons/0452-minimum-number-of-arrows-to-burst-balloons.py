from functools import cmp_to_key
class Solution:
    def findMinArrowShots(self, points: List[List[int]]) -> int:
        points.sort(key = cmp_to_key(lambda a,b: a[0]-b[0] if a[0]!=b[0] else a[1]-b[1]))

        ans = 1
        right = points[0][1]
        # print(points)

        for i in range(1,len(points)):
            if points[i][0] <= right:
                right = min(points[i][1], right)
            else:
                ans+=1
                right = points[i][1]

        return ans
        