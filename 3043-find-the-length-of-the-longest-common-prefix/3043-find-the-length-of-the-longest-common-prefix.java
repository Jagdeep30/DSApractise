class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        Set<String> st = new HashSet<>();
        for(int i=0;i<arr1.length;i++){
            String t = Integer.toString(arr1[i]);
            for(int j=0;j<t.length();j++){
                st.add(t.substring(0,j+1));
            }
        }
        int max = 0;
        for(int i=0;i<arr2.length;i++){
            String t = Integer.toString(arr2[i]);
            for(int j=0;j<t.length();j++){
                if(st.contains(t.substring(0,j+1))){
                    max = Math.max(max,j+1);
                }
            }
        }
        return max;
    }
}