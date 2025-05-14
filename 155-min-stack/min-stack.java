class MinStack {
    class Node{
        int val;
        int min;

        Node(int a, int b){
            this.val = a;
            this.min = b;
        }
    }

    List<Node> ls;
    Node top;
    public MinStack() {
        ls = new ArrayList<>();
        top = null;
    }
    
    public void push(int val) {
        Node n = new Node(val, Math.min(val, top==null?val:top.min));
        ls.add(n);
        top = n;
    }
    
    public void pop() {
        ls.remove(ls.size()-1);
        if(ls.size()==0)top = null;
        else top = ls.get(ls.size()-1);
    }
    
    public int top() {
        return top.val;
    }
    
    public int getMin() {
        return top.min;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */