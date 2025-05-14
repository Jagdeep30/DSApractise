class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nums1 = new int[n * 2];
        for (int i = 0; i < n * 2; i++) {
            nums1[i] = nums[i % n];
        }

        Stack<Integer> st = new Stack<>();
        int[] ans = new int[n];
        Arrays.fill(ans, -1); // Initialize with -1

        for (int i = nums1.length - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= nums1[i]) {
                st.pop();
            }
            if (i < n) {
                if (!st.isEmpty()) {
                    ans[i] = st.peek();
                }
            }
            st.push(nums1[i]);
        }

        return ans;
    }
}
