class Solution {
    public boolean hasAllCodes(String s, int k) {
        int n = s.length();
        if(Math.pow(2,k)+1 > n && k!=1)return false;
        // StringBuilder sb = new StringBuilder();
        // String t = ""
        Set<String> st = new HashSet<>();
        // for(int i=0;i<k;i++){
        //     sb.append(s.charAt(i));
        // }
        // st.add(sb.toString());
        int i=0;
        int j=k;
        while(j<=n){
            st.add(s.substring(i,j));
            j++;i++;
        }
        if(st.size() == Math.pow(2,k))return true;
        return false;
    }
}