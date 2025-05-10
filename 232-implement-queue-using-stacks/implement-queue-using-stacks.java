class MyQueue {
    Stack<Integer> s;
    Stack<Integer> ss;
    int top;
    public MyQueue() {
        top = 0;
        s = new Stack<Integer>();
        ss = new Stack<Integer>();
    }
    
    public void push(int x) {
        if(top == 0)top = x;

        s.push(x);
    }
    
    public int pop() {
        if(s.size()==0)return -1;

        while(s.size()!=0){
            ss.push(s.pop());
        }
        int ans = ss.pop();
        if(ss.size()!=0)top = ss.peek();
        else top = 0;
        while(ss.size()!=0){
            s.push(ss.pop());
        }

        return ans;
    }
    
    public int peek() {
        return top;
    }
    
    public boolean empty() {
        return s.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */