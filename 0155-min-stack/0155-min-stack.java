class MinStack {
    Pair<Integer,Integer>[] arr;
    int top;
    public MinStack() {
        arr = new Pair[30000];
        top = -1;
    }
    
    public void push(int val) {
        int min = val;
        if(top>-1){
            // System.out.println("top is "+arr.get(top));
            min = Math.min(min,arr[top].getValue());
        }
        // arr.add(new Pair<Integer,Integer>(Integer.MAX_VALUE,Integer.MAX_VALUE));
        arr[top+1] = new Pair<Integer,Integer>(val,min);
        top++;

        // System.out.println(arr);
        return;
    }
    
    public void pop() {
        if(top<0)return;
        top--;
    }
    
    public int top() {
        return arr[top].getKey();
    }
    
    public int getMin() {
        return arr[top].getValue();
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