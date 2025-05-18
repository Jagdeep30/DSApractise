class Solution {
    public int firstUniqChar(String s) {
        int[][] c = new int[26][2];
        for(int i=0;i<s.length();i++){
            int ind = s.charAt(i)-'a';
            c[ind][0]++;
            c[ind][1] = i; 
        }

        
        for(int i=0;i<26;i++)System.out.println(Arrays.toString(c[i]));
        int ans = 100001;
        for(int i=0;i<26;i++){
            if(c[i][0]==1)ans = Math.min(ans, c[i][1]);
        }
        if(ans!=100001)return ans;
        return -1;
    }
}