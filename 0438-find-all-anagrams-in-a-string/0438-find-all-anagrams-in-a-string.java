class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        if(p.length() > s.length())return new ArrayList<Integer>();
        int[] arr = new int[26];
        int[] temp = new int[26];

        for(int i=0;i<p.length();i++){
            arr[p.charAt(i)-'a']++;
        }
        for(int i=0;i<p.length();i++){
            temp[s.charAt(i)-'a']++;
        }

        List<Integer> ls = new ArrayList<Integer>();
        if(Arrays.equals(arr,temp))ls.add(0);
        int j=0;
        for(int i=p.length();i<s.length();i++){
            temp[s.charAt(i)-'a']++;
            temp[s.charAt(j)-'a']--;
            j++;
            if(Arrays.equals(arr,temp))ls.add(j);
        }
        return ls;
    }
}