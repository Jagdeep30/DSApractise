class Node{
    int val;
    int key;
    Node next;
    Node prev;
    Node(){
        val = -1;
        prev = null;
        next = null;
    }
    Node(int val, int key){
        this.key = key;
        this.val = val;
    }
}
class LRUCache {
    Map<Integer,Node> mp;
    Node head;
    Node tail;
    int size;
    int cap;
    public LRUCache(int capacity) {
        head = null;
        tail = null;
        mp = new HashMap<Integer,Node>();
        size = 0;
        cap = capacity;
    }
    
    public int get(int key) {
        Node n = mp.getOrDefault(key,null);
        if(n==null)return -1;
        if(n==tail)return n.val;
        if(n == head){
            head = head.next;
            if(head!=null)head.prev = null;
        }
        else{
            n.prev.next = n.next;
        }
        n.next = null;
        n.prev = tail;
        tail.next = n;
        tail = n;
        return n.val;
    }
    
    public void put(int key, int value) {
        Node t = mp.getOrDefault(key,null);
        if(t!=null){
            t.val = value;
            get(key);
            return;
        }
        if(size==cap && head!=null){
            mp.remove(head.key);
            head = head.next;
            if(head!=null)head.prev = null;
            size--;
        }
        Node n = new Node(value,key);
        if(tail==null)tail=n;
        else{
            tail.next = n;
            n.prev = tail;
            tail = tail.next;
        }
        if(head==null)head=n;
        mp.put(key,n);
        size++;
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */