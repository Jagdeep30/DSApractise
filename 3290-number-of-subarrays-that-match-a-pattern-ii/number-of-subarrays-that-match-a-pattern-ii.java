class Solution {
    public int countMatchingSubarrays(int[] nums, int[] pattern) {
        //using the z value algorithm
        int n = nums.length;
        int p = pattern.length;

        List<Integer> nums2 = new ArrayList<>(n+p);

        for(int i=0;i<pattern.length;i++){
            nums2.add(pattern[i]);
        }
        nums2.add(-3);

        for(int i=0;i<n-1;i++){
            if(nums[i+1]>nums[i])nums2.add(1);
            else if(nums[i+1]==nums[i])nums2.add(0);
            else nums2.add(-1);
        }

        // String z = "";
        // for(int i=0;i<p;i++){
        //     if(pattern[i]==-1){
        //         z+='2';
        //     }
        //     else
        //     z+=(Integer.toString(pattern[i]));
        // }
        // z+='$';
        // for(int i=0;i<n-1;i++){
        //     if(nums2[i]==-1){
        //         z+='2';
        //     }
        //     else
        //     z+=(Integer.toString(nums2[i]));
        // }

        //z-value algo
        int[] zarr = new int[nums2.size()];
        int s=0;
        int e=0;
        // int i=0;
        for(int i=0;i<nums2.size();i++){
            if(i>e){
                s=i;
                e=i;
                while(e<nums2.size() && nums2.get(e)==nums2.get(e-i))e++;
                e--;
                zarr[i]=e-s+1;
            }
            else{
                if(zarr[i-s]<(e-i+1)){
                    zarr[i] = zarr[i-s];
                }
                else{
                    s=i;
                    while(e<nums2.size() && nums2.get(e)==nums2.get(e-i))e++;
                    e--;
                    zarr[i]=e-s+1;
                }
            }
        }
        int ans = 0;
        for(int i=0;i<zarr.length;i++){
            if(zarr[i]==p)ans++;
        }

        return ans;
    }
}