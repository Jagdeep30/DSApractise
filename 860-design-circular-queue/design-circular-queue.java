class MyCircularQueue {
    int[] q;
    int f;
    int r;
    int k;
    public MyCircularQueue(int k) {
        q = new int[k];
        f = -1;
        r = -1;
        this.k = k;
    }
    
    public boolean enQueue(int value) {
        if(this.isFull())return false;

        if(this.f==-1){
            f+=1;
            r+=1;
            q[r] = value;
            return true;
        }
        r = r + 1;
        r = r%k;

        if(r!=-1 && r==f)return false;

        q[r] = value;
        return true;
    }
    
    public boolean deQueue() {
        if(f==-1)return false;

        if(r==f){
            q[f] = -1;
            f = -1;
            r = -1;
            return true;
        }

        q[f] = -1;
        f+=1;
        f = f%k;
        return true;
    }
    
    public int Front() {
        return f!=-1?q[f]:-1;
    }
    
    public int Rear() {
        return f!=-1?q[r]:-1;
    }
    
    public boolean isEmpty() {
        if(f==-1 && r==-1)return true;
        return false;
    }
    
    public boolean isFull() {
        if(f==-1 && r==-1)return false;
        if(f<=r){
            if(r-f+1 == k)return true;
            return false;
        }

        return r+1==f;
    }
}

/**
 * Your MyCircularQueue object will be instantiated and called as such:
 * MyCircularQueue obj = new MyCircularQueue(k);
 * boolean param_1 = obj.enQueue(value);
 * boolean param_2 = obj.deQueue();
 * int param_3 = obj.Front();
 * int param_4 = obj.Rear();
 * boolean param_5 = obj.isEmpty();
 * boolean param_6 = obj.isFull();
 */