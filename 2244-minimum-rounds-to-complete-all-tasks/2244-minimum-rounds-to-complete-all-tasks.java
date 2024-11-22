class Solution {
    public int minimumRounds(int[] tasks) {
        Map<Integer,Integer> mp = new HashMap<>();
        for(int i=0;i<tasks.length;i++){
            mp.put(tasks[i],mp.getOrDefault(tasks[i],0)+1);
        }

        int ans = 0;
        for(Map.Entry<Integer,Integer> e : mp.entrySet()){
            int n = e.getKey();
            int c = e.getValue();
            if(c==1)return -1;
            int th = c%3==0?c/3:c/3+1;
            int two = c%2==0?c/2:c/2+1;
            ans+= Math.min(th,two);
        }
        return ans;
    }
}