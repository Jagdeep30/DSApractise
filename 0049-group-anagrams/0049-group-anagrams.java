class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] arr = strs[i].toCharArray();
            Arrays.sort(arr);
            String n = new String(arr);
            List<String> t = mp.getOrDefault(n,new ArrayList<String>());
            t.add(strs[i]);
            mp.put(n,t);
        }
        List<List<String>> ans = new ArrayList<>();
        for(Map.Entry<String,List<String>> e:mp.entrySet()){
            ans.add(e.getValue());
        }

        return ans;
    }
}