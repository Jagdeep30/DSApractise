class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> st = new HashSet<>();
        List<Integer> num2 = new ArrayList<>();
        for(int i:nums2)num2.add(i);
        for(int i:nums1){
            if(num2.contains(i))st.add(i);
        }

        int[] ans = new int[st.size()];
        int i=0;
        for(int num:st)ans[i++]=num;

        return ans;
    }
}