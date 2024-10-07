class MinStack {
public:
    int arr[100];
    int tp;
    
    MinStack() {
        // int arr[100];
        tp = -1;
        // min = INT_MAX;
    }
    
    void push(int val) {
        tp++;
        arr[tp] = val;
        // if(val<min)min=val;
    }
    
    void pop() {
        if(tp<0)return;
        tp--;
    }
    
    int top() {
        return arr[tp];
    }
    
    int getMin() {
        int min = INT_MAX;
        for(int i=tp;i>=0;i--){
            if(arr[i]<min)min=arr[i];
        }
        return min;
    }
};

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack* obj = new MinStack();
 * obj->push(val);
 * obj->pop();
 * int param_3 = obj->top();
 * int param_4 = obj->getMin();
 */