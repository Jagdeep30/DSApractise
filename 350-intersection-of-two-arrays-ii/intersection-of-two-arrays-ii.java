class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        List<Integer> ls = new ArrayList<>();

        int[] mp = new int[1001];
        int[] mpp = new int[1001];

        for(int i=0;i<nums1.length;i++){
            mp[nums1[i]]++;
        }
        for(int i=0;i<nums2.length;i++){
            mpp[nums2[i]]++;
        }

        for(int i=0;i<=1000;i++){
            if(mp[i] != 0 && mpp[i] != 0){
                for(int j=0;j<Math.min(mp[i],mpp[i]);j++)ls.add(i);
            }
        }

        int[] ans = new int[ls.size()];
        for(int i=0;i<ans.length;i++){
            ans[i] = ls.get(i);
        }

        return ans;
    }
}