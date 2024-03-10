class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        // Set<Integer> st = new HashSet<>();
        // List<Integer> num2 = new ArrayList<>();
        // for(int i:nums2)num2.add(i);
        // for(int i:nums1){
        //     if(num2.contains(i))st.add(i);
        // }

        // int[] ans = new int[st.size()];
        // int i=0;
        // for(int num:st)ans[i++]=num;

        // return ans;

        Arrays.sort(nums1);
        Arrays.sort(nums2);

        System.out.println(Arrays.toString(nums1));
        System.out.println(Arrays.toString(nums2));

        List<Integer> st = new ArrayList<>();
        int i=0;
        int j=0;
        int n=nums1.length;
        int m=nums2.length;

        while(i<n && j<m){
            if(nums1[i]==nums2[j]){
                st.add(nums1[i]);
                i++;j++;
                while(i<n && nums1[i]==nums1[i-1])i++;
                while(j<m && nums2[j]==nums2[j-1])j++;
            }
            else if(nums1[i]<nums2[j]){
                i++;
            }
            else j++;
        }

        int[] ans = new int[st.size()];
        // System.out.println(st);
        i=0;
        for(int num:st)ans[i++]=num;
        return ans;
    }
}