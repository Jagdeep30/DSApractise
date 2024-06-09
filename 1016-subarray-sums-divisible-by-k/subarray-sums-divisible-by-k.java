class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int sum = 0;
        int count = 0;
        Map<Integer, Integer> mp = new HashMap<>();
        mp.put(0, 1); // always one prefix sum that is initially 0

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            int rem = sum % k; // Calculate the remainders of current sum

            if (rem < 0) { // Handle negative remainders to ensure they are positive
                rem = k + rem;
            }

            if (mp.containsKey(rem)) { // If remainder has seen before, it means there are subarrays
                count += mp.get(rem); // which sum to multiple of k. Add the count of occurrences
            }

            mp.put(rem, mp.getOrDefault(rem, 0) + 1); // Increment the count for this remainder in the map
        }
        return count;
    }
}