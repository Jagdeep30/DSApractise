class Solution {
    public String customSortString(String order, String s) {
        Map<Character,Integer> mp = new HashMap<>();
        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);
            mp.put(ch,mp.getOrDefault(ch,0)+1);
        }
        String ans = "";
        for(int i=0;i<order.length();i++){
            char ch = order.charAt(i);
            int count = mp.getOrDefault(ch,0);
            if(count!=0){
                while(count!=0){
                    ans+=ch;
                    count--;
                }
                mp.put(ch,0);
            }
        }

        for(Map.Entry<Character,Integer> e:mp.entrySet()){
            int count = e.getValue();
            char ch = e.getKey();
            if(count!=0){
                while(count!=0){
                    ans+=ch;
                    count--;
                }
                // ans+=e.getKey();
            }
        }

        return ans;
    }
}