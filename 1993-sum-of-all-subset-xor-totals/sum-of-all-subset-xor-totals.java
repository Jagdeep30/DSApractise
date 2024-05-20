// class Solution {
//     public int subsetXORSum(int[] nums) {
//         int ans = 0;
//         ArrayList<Integer> subset = new ArrayList<>();
//         ans = solve(ans,subset,nums,0);
//         return ans;
//     }

//     static int solve(int ans, ArrayList<Integer> subset, int[]nums, int index){
//         //base case
//         if(index == nums.length){
//             int xor = 0;
//             for(int i=0;i<subset.size();i++){
//                 xor^=subset.get(i);
//             }
//             ans+=xor;
//             return ans;
//         }

//         //processing
        

//         //exclude
//         ans = solve(ans,subset,nums,index+1);
//         //include
//         subset.add(nums[index]);
//         ans = solve(ans,subset,nums,index+1);
//         return ans;
//     }
// }





class Solution {
    public int subsetXORSum(int[] nums) {
        int ans = 0;
        // ArrayList<Integer> subset = new ArrayList<>();
        int x = 0;
        ans = solve(ans,x,nums,0);
        return ans;
    }

    static int solve(int ans, int x, int[]nums, int index){
        //base case
        if(index == nums.length){
            // int xor = 0;
            // for(int i=0;i<subset.size();i++){
            //     xor^=subset.get(i);
            // }
            ans+=x;
            return ans;
        }

        //processing
        

        //exclude
        ans = solve(ans,x,nums,index+1);
        //include
        // subset.add(nums[index]);
        x^=nums[index];
        ans = solve(ans,x,nums,index+1);
        return ans;
    }
}