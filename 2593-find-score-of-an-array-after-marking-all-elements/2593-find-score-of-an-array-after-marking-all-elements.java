class Solution {
    public long findScore(int[] nums) {
        PriorityQueue<Pair<Integer,Integer>> pq = new PriorityQueue<>((a,b)->{
            if(a.getValue().equals(b.getValue()))return a.getKey()-b.getKey();
            return a.getValue()-b.getValue();
        });
        for(int i=0;i<nums.length;i++){
            pq.add(new Pair<Integer,Integer>(i,nums[i]));
        }
        Map<Integer,Boolean> mp = new HashMap<>();
        // System.out.println(pq);
        long score = 0;
        while(!pq.isEmpty()){
            Pair<Integer,Integer> p = pq.poll();
            if(!mp.getOrDefault(p.getKey(),false)){
                score+=p.getValue();
                mp.put(p.getKey(),true);
                if(p.getKey()+1<nums.length)mp.put(p.getKey()+1,true);
                if(p.getKey()-1>=0)mp.put(p.getKey()-1,true);
            }
        }
        return score;
    }
}