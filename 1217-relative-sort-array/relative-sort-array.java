class Solution {
    public int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer,Integer> mp = new TreeMap<>();
        int n = arr1.length;
        int m = arr2.length;
        for(int i=0;i<n;i++){
            mp.put(arr1[i],mp.getOrDefault(arr1[i],0)+1);
        }
        // System.out.println(mp);
        int[] ans = new int[n];
        int k = 0;
        for(int i=0;i<m;i++){
            int val = mp.getOrDefault(arr2[i],0);
            for(int j=0;j<val;j++){
                ans[k++] = arr2[i];
            }
            if(val!=0)mp.put(arr2[i],-1);
        }
        // System.out.println(mp);

        // Set<Integer> st = new TreeSet<>();
        // for(Map.Entry<Integer,Integer> e:mp.entrySet()){
        //     if(e.getValue()!=-1){
        //         for(int i=0;i<e.getValue();i++){
        //             st.add(e.getKey());
        //         }
        //     }
        // }

        // System.out.println(st);

        for(Map.Entry<Integer,Integer> e:mp.entrySet()){
            if(e.getValue()!=-1){
                for(int i=0;i<e.getValue();i++){
                    ans[k++] = e.getKey();
                }
            }
        }

        return ans;
    }
}