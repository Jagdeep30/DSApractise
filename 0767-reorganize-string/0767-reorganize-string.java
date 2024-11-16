class Solution {
    public String reorganizeString(String s) {
        int n = s.length();
        Map<Character,Integer> mp = new HashMap<>();
        char[] arr = s.toCharArray();
        for(int i=0;i<arr.length;i++)mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>((a,b) -> {
            return b.getValue()-a.getValue();
        });

        for(Map.Entry<Character,Integer> e: mp.entrySet()){
            // if(e.getValue()>n/2)return "";
            pq.add(e);
        }

        String ans = "";
        char prev = ' ';
        while(!pq.isEmpty()){
            Map.Entry<Character,Integer> e = pq.poll();
            if(prev==e.getKey()){
                if(pq.isEmpty())return "";
                Map.Entry<Character,Integer> temp = pq.poll();
                pq.add(e);
                e = temp;
            }
            ans+=e.getKey();
            e.setValue(e.getValue()-1);
            if(e.getValue()>0)pq.add(e);
            prev = e.getKey();
        }
        return ans;
    }
}