class Solution {
    public List<String> letterCombinations(String digits) {
        if(digits.equals(""))return new ArrayList<String>();
        Map<Character,List<Character>> mp = new HashMap<>();
        mp.put('2',new ArrayList<Character>(Arrays.asList('a','b','c')));
        mp.put('3',new ArrayList<Character>(Arrays.asList('d','e','f')));
        mp.put('4',new ArrayList<Character>(Arrays.asList('g','h','i')));
        mp.put('5',new ArrayList<Character>(Arrays.asList('j','k','l')));
        mp.put('6',new ArrayList<Character>(Arrays.asList('m','n','o')));
        mp.put('7',new ArrayList<Character>(Arrays.asList('p','q','r','s')));
        mp.put('8',new ArrayList<Character>(Arrays.asList('t','u','v')));
        mp.put('9',new ArrayList<Character>(Arrays.asList('w','x','y','z')));

        List<String> ans = new ArrayList<>();
        solve(0,digits,mp,ans,"");
        return ans;
    }

    static void solve(int i, String d, Map<Character,List<Character>> mp, List<String> ans, String curr){
        if(i==d.length()){
            ans.add(curr);
            return;
        }
        List<Character> ls = mp.get(d.charAt(i));
        for(int j=0;j<ls.size();j++){
            solve(i+1,d,mp,ans,curr+ls.get(j));
        }
        return;
    }
}