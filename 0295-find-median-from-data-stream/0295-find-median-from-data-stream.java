class MedianFinder {
    PriorityQueue<Integer> maxh;
    PriorityQueue<Integer> minh;
    public MedianFinder() {
        maxh = new PriorityQueue<>(Collections.reverseOrder());
        minh = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        if(maxh.size()==0){
            maxh.add(num);
        }
        else{
            if(num>=maxh.peek()){
                minh.add(num);
            }
            else{
                maxh.add(num);
            }

            if(maxh.size()-minh.size()>1)minh.add(maxh.poll());
            else if(minh.size()-maxh.size()>=1)maxh.add(minh.poll());
        }
    }
    
    public double findMedian() {
        int n = minh.size()+maxh.size();
        if(n%2==0){
            return ((double)minh.peek()+maxh.peek())/2;
        }else return maxh.peek();
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */