class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        int[] ans = new int[nums1.length];

        Map<Integer,Integer> mp = new HashMap<>();
        mp.put(nums2[nums2.length-1],-1);
        st.push(nums2[nums2.length-1]);
        for(int i=nums2.length-2;i>=0;i--){
            while(!st.isEmpty() && st.peek()<=nums2[i])st.pop();
            if(st.isEmpty()){
                st.push(nums2[i]);
                mp.put(nums2[i],-1);
            }
            else{
                mp.put(nums2[i],st.peek());
                st.push(nums2[i]);
            }
        }

        // System.out.println(mp);

        for(int i=0;i<nums1.length;i++){
            ans[i] = mp.get(nums1[i]);
        }

        return ans;
    }
}