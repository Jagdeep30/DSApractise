class Solution {
    public String reverseVowels(String s) {
        StringBuilder st = new StringBuilder(s);
        int i=0;
        int j=s.length()-1;
        Map<Character,Boolean> mp = new HashMap<>();
        mp.put('a',true);
        mp.put('e',true);
        mp.put('i',true);
        mp.put('o',true);
        mp.put('u',true);
        mp.put('A',true);
        mp.put('E',true);
        mp.put('I',true);
        mp.put('O',true);
        mp.put('U',true);
        while(i<j){
            if(!mp.getOrDefault(st.charAt(i),false)){
                i++;
                continue;
            }
            if(!mp.getOrDefault(st.charAt(j),false)){
                j--;
                continue;
            }

            char c = st.charAt(i);
            st.setCharAt(i,st.charAt(j));
            st.setCharAt(j,c);
            i++;
            j--;
        }

        return st.toString();
    }
}