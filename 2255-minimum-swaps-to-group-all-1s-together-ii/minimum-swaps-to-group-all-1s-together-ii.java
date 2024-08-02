class Solution {
    public int minSwaps(int[] nums) {
        int total = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1)total++;
        }

        List<Integer> arr = new ArrayList<Integer>();
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }
        for(int i=0;i<nums.length;i++){
            arr.add(nums[i]);
        }

        int min = Integer.MAX_VALUE;
        int zero = 0;
        int i=0;
        int j=0;
        while(j<total){
            if(arr.get(j)==0)zero++;
            j++;
        }

        while(j<arr.size()){
            min = Math.min(min,zero);
            if(arr.get(j)==0)zero++;
            if(arr.get(i)==0)zero--;
            j++;i++;
        }
        return min;
    }
}