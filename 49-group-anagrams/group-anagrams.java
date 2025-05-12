class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String,List<Integer>> mp = new HashMap<>();
        for(int i=0;i<strs.length;i++){
            char[] ch = strs[i].toCharArray();
            Arrays.sort(ch);
            String s = new String(ch);
            List<Integer> temp = mp.getOrDefault(s, new ArrayList<Integer>());
            temp.add(i);
            mp.put(s, temp);
        }

        List<List<String>> ls = new ArrayList<>();
        for(Map.Entry<String, List<Integer>> e: mp.entrySet()){
            List<String> temp = new ArrayList<>();
            for(Integer i: e.getValue()){
                temp.add(strs[i]);
            }
            ls.add(temp);
        }

        return ls;
    }
}