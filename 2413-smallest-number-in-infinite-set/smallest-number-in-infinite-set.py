class SmallestInfiniteSet:
    arr: list[bool]
    def __init__(self):
        self.arr = [True]*1001

    def popSmallest(self) -> int:
        for i in range(1,1001):
            if self.arr[i]:
                self.arr[i] = False
                return i
        
        return -1

    def addBack(self, num: int) -> None:
        self.arr[num] = True


# Your SmallestInfiniteSet object will be instantiated and called as such:
# obj = SmallestInfiniteSet()
# param_1 = obj.popSmallest()
# obj.addBack(num)