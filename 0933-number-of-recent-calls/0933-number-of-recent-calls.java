class RecentCounter {
    List<Integer> ls;
    public RecentCounter() {
        ls = new ArrayList<>();
    }
    
    public int ping(int t) {
        ls.add(t);
        int ind = find(t-3000);
        return ls.size()-ind;
    }
    
    public int find(int target){
        int s=0;
        int e=ls.size()-1;
        while(s<e){
            int mid = s+(e-s)/2;
            if(ls.get(mid)==target)return mid;
            else if(ls.get(mid)<target)s = mid+1;
            else e = mid;
        }

        return e;
    }
}

/**
 * Your RecentCounter object will be instantiated and called as such:
 * RecentCounter obj = new RecentCounter();
 * int param_1 = obj.ping(t);
 */