class Solution {
    public int findTheLongestSubstring(String s) {
        Map<Character,Integer> mp = new HashMap<>();
        mp.put('a',1);
        mp.put('e',2);
        mp.put('i',4);
        mp.put('o',8);
        mp.put('u',16);
        int mask = 0;
        int max = 0;
        int[] found = new int[32];
        Arrays.fill(found,-1);
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            // if(ch!='a' && ch!='e' && ch!='i' && ch!='o' && ch!='u')continue;
            int val = mp.getOrDefault(ch,0);
            mask = mask ^ val;
            if(mask!=0 && found[mask]==-1){
                found[mask] = i;
            }
            max = Math.max(max,i-found[mask]);
        }

        return max;
    }
}