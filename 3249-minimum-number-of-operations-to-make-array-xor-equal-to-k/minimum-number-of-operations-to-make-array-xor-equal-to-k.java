// class Solution {
//     public int minOperations(int[] nums, int k) {
//         int n = nums.length;
//         String[] arr = new String[n];
//         Map<Integer,Integer> mp = new HashMap<>();
//         int maxL = 0;

//         for(int i=0;i<n;i++){
//             arr[i] = Integer.toBinaryString(nums[i]);
//             maxL = Math.max(maxL,arr[i].length());
//         }


        
//         // for(int i=0;i<n;i++){
//         //     System.out.println(arr[i]);
//         // }

//         // for(int i=maxL-1;i>=0;i--){
//         for(int j=0;j<n;j++){
//             for(int i=0;i<arr[j].length();i++){
//                 int ind = maxL-arr[j].length() + i;
//                 if(arr[j].charAt(i)=='1'){
//                     mp.put(ind,mp.getOrDefault(ind,0)+1);
//                 }
//             }
//         }

//         for(int i=0;i<maxL;i++){
//             if(mp.getOrDefault(i,-1)==-1)mp.put(i,0);
//         }

//         System.out.println(mp);
//         // }

//         int ans = 0;
//         String kk = Integer.toBinaryString(k);
//         // int[] req = new int[kk.length()];

//         for(Map.Entry<Integer,Integer> e:mp.entrySet()){
//             int i = e.getKey();
//             int j = e.getValue();
//             int reqInd = maxL-kk.length() + kk.length()>=maxL?-i:i;
//             int req = 0;
//             if(reqInd>=kk.length())req = 0;
//             else req = kk.charAt(reqInd) - '0';

//             int val1 = req%2;
//             int val2 = j%2;
//             if(!((val1==0 && val2==0) || (val1==1 && val2==1)))ans++;
//         }

//         return ans;
//     }
// }
class Solution {
    public int minOperations(int[] nums, int k) {
        int finalXor = 0;
        // XOR of all integers in the array.
        for (int n : nums) {
            finalXor = finalXor ^ n;
        }
        
        int count = 0;
        // Keep iterating until both k and finalXor becomes zero.
        while (k > 0 || finalXor > 0) {
            // k % 2 returns the rightmost bit in k,
            // finalXor % 2 returns the rightmost bit in finalXor.
            // Increment counter, if the bits don't match.
            if ((k % 2) != (finalXor % 2)) {
                count++;
            }
            
            // Remove the last bit from both integers.
            k /= 2;
            finalXor /= 2;
        }
        
        return count;
    }
}