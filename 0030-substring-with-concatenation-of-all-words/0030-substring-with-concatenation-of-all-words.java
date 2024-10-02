class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> ans = new ArrayList<>();
        Map<String,Integer> mp = new HashMap<>();
        int wLen = words[0].length();
        int n = words.length;
        for(int i=0;i<words.length;i++){
            mp.put(words[i],mp.getOrDefault(words[i],0)+1);
        }

        for(int i=0;i<=s.length()-(wLen*n);i++){
            Map<String,Integer> temp = new HashMap<String,Integer>(mp);
                // System.out.println(temp);
            for(int j=0;j<n;j++){
                String word = s.substring(j*wLen + i,j*wLen + i + wLen);
                int fq = temp.getOrDefault(word,0);
                if(fq==0)break;
                temp.put(word,fq-1);
                if(j==n-1){
                    ans.add(i);
                }
            }
        }
        return ans;
    }
}