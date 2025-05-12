class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ls = new ArrayList<>();
        if(p.length()>s.length())return ls;

        int[] a = new int[26];
        int[] b = new int[26];
        int n = p.length();
        
        for(Character ch: p.toCharArray()){
            a[ch-'a']++;
        }

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            b[ch-'a']++;
        }

        for(int i=n;i<s.length();i++){
            if(Arrays.equals(a,b)){
                ls.add(i-n);
            }
            char ch = s.charAt(i);
            b[ch-'a']++;

            b[s.charAt(i-n)-'a']--;
        }

        if(Arrays.equals(a,b)){
            ls.add(s.length()-n);
        }

        
        return ls;
    }
}