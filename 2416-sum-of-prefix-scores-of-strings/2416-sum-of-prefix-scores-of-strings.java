class Solution {
    public int[] sumPrefixScores(String[] words) {
        Map<String,Integer> mp = new HashMap<>();
        Map<Integer,List<String>> mpp = new HashMap<>();
        for(int i=0;i<words.length;i++){
            String word = words[i];
            String temp = "";
            for(int j=0;j<word.length();j++){
                temp+=word.charAt(j);
                mp.put(temp,mp.getOrDefault(temp,0)+1);
                List<String> arr = mpp.getOrDefault(i,new ArrayList<String>());
                arr.add(temp);
                mpp.put(i,arr);
            }
        }
        int[] ans = new int[words.length];
        for(int i=0;i<words.length;i++){
            List<String> temp = mpp.get(i);
            int t = 0;
            for(int j=0;j<temp.size();j++){
                t+=mp.getOrDefault(temp.get(j),0);
            }
            ans[i] = t;
        }

        return ans;
    }
}