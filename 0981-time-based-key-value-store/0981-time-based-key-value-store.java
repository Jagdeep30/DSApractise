class TimeMap {
    HashMap<String,List<Pair<String,Integer>>> mp;
    public TimeMap() {
        mp = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        List<Pair<String,Integer>> ls = mp.getOrDefault(key, new ArrayList<Pair<String,Integer>>());
        Pair<String,Integer> p = new Pair<>(value, timestamp);
        ls.add(p);
        mp.put(key,ls);
    }
    
    public String get(String key, int timestamp) {
        // System.out.println(mp);
        List<Pair<String,Integer>> ls = mp.getOrDefault(key,null);
        if(ls==null)return "";
        int val = binarySearch(timestamp, ls);
        if(ls.get(val).getValue()<=timestamp)return ls.get(val).getKey();
        return "";
    }
    static int binarySearch(int t, List<Pair<String,Integer>> ls){
        int s = 0;
        int e = ls.size()-1;
        int temp = -1;
        while(s<=e){
            int mid = s + (e-s)/2;
            if(ls.get(mid).getValue()<=t){
                temp = s;
                s = mid+1;
            }
            else e = mid-1;
        }
        return temp!=-1?temp:s;
    }
}

/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */