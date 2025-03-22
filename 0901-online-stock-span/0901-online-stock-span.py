class StockSpanner:
    stack: list
    i: int
    def __init__(self):
        self.stack = []
        self.i=0

    def next(self, price: int) -> int:
        self.i+=1
        while self.stack and self.stack[0][1]<=price:
            self.stack.pop(0)

        if self.stack:
            ans = self.i-self.stack[0][0]
        else:
            ans = self.i
        
        self.stack.insert(0,(self.i,price))
        return ans


# Your StockSpanner object will be instantiated and called as such:
# obj = StockSpanner()
# param_1 = obj.next(price)