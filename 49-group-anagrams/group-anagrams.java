class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<String>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            List<String> temp = mp.getOrDefault(s, new ArrayList<String>());
            temp.add(strs[i]);
            mp.put(s, temp);
        }

        List<List<String>> ls = new ArrayList<>();
        for(Map.Entry<String, List<String>> e: mp.entrySet()){
            ls.add(e.getValue());
        }

        return ls;
    }
}