class SmallestInfiniteSet {
    PriorityQueue<Integer> pq;
    public SmallestInfiniteSet() {
        pq = new PriorityQueue<>();
        for(int i=1;i<=1000;i++)pq.add(i);
    }
    
    public int popSmallest() { 
        int num = pq.poll();
        while(!pq.isEmpty() && pq.peek()==num)pq.poll();
        return num;
    }
    
    public void addBack(int num) {
        pq.add(num);
    }
}

/**
 * Your SmallestInfiniteSet object will be instantiated and called as such:
 * SmallestInfiniteSet obj = new SmallestInfiniteSet();
 * int param_1 = obj.popSmallest();
 * obj.addBack(num);
 */