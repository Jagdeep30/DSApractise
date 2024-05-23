// class Solution {
//     public int beautifulSubsets(int[] nums, int k) {
//         List<Integer> output = new ArrayList<Integer>();
//         Map<String,Boolean> v= new HashMap<>();
//         Map<Integer,Boolean> has = new HashMap<>();
//         int n = nums.length;
//         Arrays.sort(nums);
//         return solve(0,n,k,output,has,nums,v)-1;
//     }

//     static int solve(int i, int n, int k, List<Integer> output, Map<Integer,Boolean> has,int[] nums, Map<String,Boolean> v){
//         //base case
//         if(i==n){
//             if(v.getOrDefault(output.toString(),false)){
//                 return 0;
//             }
//             else{
//                 v.put(output.toString(),true);
//             }
//             return 1;
//         }


//         int res = 0;

//         if(!has.getOrDefault(nums[i]-k,false)  &&  !has.getOrDefault(nums[i]+k,false)){
//             output.add(nums[i]);
//             has.put(nums[i],true);
//             res += solve(i+1,n,k,output,has,nums,v);
//             output.remove(output.size()-1);
//             has.put(nums[i],false);
//         }
//         res += solve(i+1,n,k,output,has,nums,v);

//         return res;
//     }
// }

class Solution {
    public int dfs(int[] nums, int idx, int k, HashMap<Integer, Integer> mp) {
        if (idx == nums.length) return 1;

        int taken = 0;
        if (!mp.containsKey(nums[idx] - k) && !mp.containsKey(nums[idx] + k)) {
            mp.put(nums[idx], mp.getOrDefault(nums[idx], 0) + 1);
            taken = dfs(nums, idx + 1, k, mp);
            mp.put(nums[idx], mp.get(nums[idx]) - 1);
            if (mp.get(nums[idx]) == 0) {
                mp.remove(nums[idx]);
            }
        }
        
        int notTaken = dfs(nums, idx + 1, k, mp);
        
        return taken + notTaken;
    }

    public int beautifulSubsets(int[] nums, int k) {
        HashMap<Integer, Integer> mp = new HashMap<>();
        int ans = dfs(nums, 0, k, mp);
        return ans - 1;
    }
}