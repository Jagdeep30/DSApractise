class Solution {
    public int findLeastNumOfUniqueInts(int[] arr, int k) {
        Map<Integer,Integer> mp = new HashMap<>();
        List<List<Integer>> f = new ArrayList<>();
        int n = arr.length;
        for(int i=0;i<n;i++){
            mp.put(arr[i],mp.getOrDefault(arr[i],0)+1);
        }
        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            List<Integer> temp = new ArrayList<>();
            temp.add(e.getKey());
            temp.add(e.getValue());
            f.add(temp);
        }
        Collections.sort(f,(a,b)->{
            return Integer.compare(a.get(1),b.get(1));
        });
        // System.out.println(f);
        // return 0;

        int ans = 0;

        for(int i=0;i<f.size();i++){
            int ele = f.get(i).get(1);
            if(ele>k){
                // System.out.println(i);
                ans = f.size()-i;
                break;
            }
            else{
                k-=ele;
                // System.out.println(k);
            }
        }
        return ans;
    }
}