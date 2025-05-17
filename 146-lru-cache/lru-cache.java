class Node{
    int key;
    int val;
    Node next;
    Node prev;

    Node(int key, int val){
        this.key = key;
        this.val = val;
        next = null;
        prev = null;
    }
}
class LRUCache {
    Node head;
    Node tail;
    int size;
    int cap;
    Map<Integer,Node> mp;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        size = 0;
        this.cap = capacity;
        mp = new HashMap<>();
    }
    
    public int get(int key) {
        Node ans = mp.getOrDefault(key, null);
        if(ans==null){
            return -1;
        }

        if(head == tail && head == ans){
            return ans.val;
        }
        else if(ans == tail){
            return ans.val;
        }
        else if(ans == head){
            head = head.next;
            ans.next.prev = null;
            ans.next = null;
            tail.next = ans;
            ans.prev = tail;
            tail = tail.next;
        }
        else{
            ans.prev.next = ans.next;
            ans.next.prev = ans.prev;
            ans.next = null;
            tail.next = ans;
            ans.prev = tail;
            tail = tail.next;
        }

        return ans.val;
    }
    
    public void put(int key, int value) {
        if(mp.getOrDefault(key,null)!=null){
            this.get(key);
            tail.val = value;
            return;
        }
        Node n = new Node(key,value);
        if(head == null){
            head = n;
            tail = n;
        }
        else{
            tail.next = n;
            n.prev = tail;
            tail = tail.next;
        }
        size+=1;
        mp.put(key,n);

        if(size>cap){
            mp.put(head.key, null);
            size-=1;
            head = head.next;
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */