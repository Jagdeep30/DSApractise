class Solution {
    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        PriorityQueue<List<Integer>> pq = new PriorityQueue<>((a,b)->{
            return a.get(2)-b.get(2);
        });
        List<Integer> ele = new ArrayList<>(Arrays.asList(0,0,nums1[0]+nums2[0]));
        List<List<Integer>> ans = new ArrayList<>();
        Set<List<Integer>> temp = new HashSet<>();
        pq.add(ele);
        temp.add(ele);
        while(k!=0){
            List<Integer> ls = pq.poll();
            int u = ls.get(0);
            int v = ls.get(1);
            ans.add(new ArrayList<Integer>(Arrays.asList(nums1[u],nums2[v])));
            k--;
            if(u+1<n){
                List<Integer> t = new ArrayList<Integer>(Arrays.asList(u+1,v,nums1[u+1]+nums2[v]));
                if(!temp.contains(t)){
                    pq.add(t);
                    temp.add(t);
                }
            }
            if(v+1<m){
                List<Integer> t = new ArrayList<Integer>(Arrays.asList(u,v+1,nums1[u]+nums2[v+1]));
                if(!temp.contains(t)){
                    pq.add(t);
                    temp.add(t);
                }
            }
            // System.out.println(pq);
        }
        return ans;
    }
}