class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Queue<String> q = new LinkedList<>();
        Map<String, Boolean> mp = new HashMap<>();
        for (int i = 0; i < wordList.size(); i++)mp.put(wordList.get(i), true);
        if(!mp.getOrDefault(endWord,false))return 0;
        // System.out.println(mp);
        char[] c = new char[26];
        for(int i=0;i<26;i++){
            c[i] = (char)('a'+i);
        }
            // System.out.println(c);
        Set<String> set = new HashSet<>();
        int steps = 1;
        q.add(beginWord);
        q.add("");
        while (!q.isEmpty()) {
            String tt = q.poll();
            char[] t = tt.toCharArray();
            if (tt.equals(endWord)) {
                if(mp.getOrDefault(endWord,false))break;
                else return 0;
            }
            if (tt.equals("") && q.isEmpty()) {
                steps = -1;
                break;
            }
            if (tt.equals("")) {
                steps++;
                q.add("");
                continue;
            }
            for (int i = 0; i < c.length; i++) {
                for (int j = 0; j < t.length; j++) {
                    if (c[i] != t[j]) {
                        String temp = tt.substring(0, j) + c[i] + tt.substring(j + 1);
                       
                        if (mp.getOrDefault(temp, false) && !set.contains(temp)) {
                            // System.out.println(temp);
                            set.add(temp);
                            q.add(temp);
                        }
                    }
                }
            }
        }
        if(steps==-1)return 0;
        return steps;
    }
}